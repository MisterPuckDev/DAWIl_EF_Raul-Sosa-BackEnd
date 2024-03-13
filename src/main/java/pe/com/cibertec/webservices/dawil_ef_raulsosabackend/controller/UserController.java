package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.model.User;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.projections.ReportUserForCategory;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service.UserService;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.util.UtilExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<User>> list() {
        List<User> list = userService.list();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/search/{id}")
    @ResponseBody
    public ResponseEntity<User> search(@PathVariable("id") int id) {
        User ticket = null;

        try {
            ticket = userService.serachById(id);
            if (ticket == null) {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(ticket);
    }

    @GetMapping("/report/{id}")
    @ResponseBody
    public ResponseEntity<List<ReportUserForCategory>> getReport(@PathVariable("id") int id) {
        return new ResponseEntity<>(userService.getReport(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> add(@RequestBody User obj) {
        Map<String, Object> salida = new HashMap<>();

        try {
            obj.setId(0);
            User objUser = userService.add(obj);

            if (objUser == null) {
                salida.put("mensaje", "Ocurrio un error al intentar registrar");
            } else {
                salida.put("mensaje", "Registro con exito");
            }

        } catch (Exception e) {
            salida.put("mensaje", "Ocurrio un error durante el registro: " + e.getMessage());
            System.out.println("Ocurrio un error durante el registro: " + e.getMessage());
            return ResponseEntity.internalServerError().body(salida);
        }

        return ResponseEntity.ok(salida);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> update(@RequestBody User obj) {
        Map<String, Object> salida = new HashMap<>();

        try {
            User objUser = userService.update(obj);

            if (objUser == null) {
                salida.put("mensaje", "Ocurrio un error al intentar actualizar");
            } else {
                salida.put("mensaje", "Actualizacion con exito");
            }

        } catch (Exception e) {
            salida.put("mensaje", "Ocurrio un error durante la actualizacion: " + e.getMessage());
            System.out.println("Ocurrio un error durante la actualizacion: " + e.getMessage());
            return ResponseEntity.internalServerError().body(salida);
        }

        return ResponseEntity.ok(salida);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") int id) {
        Map<String, Object> salida = new HashMap<>();

        try {
            userService.delete(id);
            salida.put("mensaje", "Eliminacion con exito");
        } catch (Exception e) {
            salida.put("mensaje", "Ocurrio un error durante la eliminacion: " + e.getMessage());
            System.out.println("Ocurrio un error durante la eliminacion: " + e.getMessage());
            return ResponseEntity.internalServerError().body(salida);
        }

        return ResponseEntity.ok(salida);
    }

    private static String[] HEADERs = {"CÓDIGO", "NOMBRE", "APELLIDO", "CORREO", "USUARIO", "CONTRASEÑA", "ESTADO", "TIPO"};
    private static String SHEET = "Listado";
    private static String TITLE = "Listado de Usuario por Categoria";
    private static int[] HEADER_WITH = {3000, 10000, 6000, 10000, 20000, 10000, 20000, 20000};

    @PostMapping("/reportXLSX/{id}")
    public void reportXLSX(@PathVariable("id") int id,
                           HttpServletRequest request,
                           HttpServletResponse response) {

        Workbook excel = null;
        try {
            excel = new XSSFWorkbook();

            Sheet hoja = excel.createSheet(SHEET);

            hoja.addMergedRegion(new CellRangeAddress(0, 0, 0, HEADER_WITH.length - 1));

            for (int i = 0; i < HEADER_WITH.length; i++) {
                hoja.setColumnWidth(i, HEADER_WITH[i]);
            }

            CellStyle estiloHeadCentrado = UtilExcel.setEstiloHeadCentrado(excel);
            CellStyle estiloHeadIzquierda = UtilExcel.setEstiloHeadIzquierda(excel);
            CellStyle estiloNormalCentrado = UtilExcel.setEstiloNormalCentrado(excel);
            CellStyle estiloNormalIzquierda = UtilExcel.setEstiloNormalIzquierdo(excel);

            Row fila1 = hoja.createRow(0);
            Cell celAuxs = fila1.createCell(0);
            celAuxs.setCellStyle(estiloHeadIzquierda);
            celAuxs.setCellValue(TITLE);

            Row fila2 = hoja.createRow(1);
            Cell celAuxs2 = fila2.createCell(0);
            celAuxs2.setCellValue("");

            Row fila3 = hoja.createRow(2);
            for (int i = 0; i < HEADERs.length; i++) {
                Cell celda1 = fila3.createCell(i);
                celda1.setCellStyle(estiloHeadCentrado);
                celda1.setCellValue(HEADERs[i]);
            }

            List<ReportUserForCategory> lstSalida = userService.getReport(id);
            int rowIdx = 3;
            for (ReportUserForCategory obj : lstSalida) {
                Row row = hoja.createRow(rowIdx++);
                Cell cel0 = row.createCell(0);
                cel0.setCellValue(obj.getId());
                cel0.setCellStyle(estiloNormalCentrado);

                Cell cel1 = row.createCell(1);
                cel1.setCellValue(obj.getName());
                cel1.setCellStyle(estiloNormalIzquierda);

                Cell cel2 = row.createCell(2);
                cel2.setCellValue(obj.getLastname());
                cel2.setCellStyle(estiloNormalCentrado);

                Cell cel3 = row.createCell(3);
                cel3.setCellValue(obj.getEmail());
                cel3.setCellStyle(estiloNormalCentrado);

                Cell cel4 = row.createCell(4);
                cel4.setCellValue(obj.getUsername());
                cel4.setCellStyle(estiloNormalCentrado);

                Cell cel5 = row.createCell(5);
                cel5.setCellValue(obj.getPassword());
                cel5.setCellStyle(estiloNormalCentrado);

                Cell cel6 = row.createCell(6);
                cel6.setCellValue(obj.getIsActive());
                cel6.setCellStyle(estiloNormalCentrado);

                Cell cel7 = row.createCell(7);
                cel7.setCellValue(obj.getKind());
                cel7.setCellStyle(estiloNormalCentrado);
            }

            response.setContentType("application/vnd.ms-excel");
            response.addHeader("Content-disposition", "attachment; filename=ReporteUsuarios.xlsx");

            OutputStream outStream = response.getOutputStream();
            excel.write(outStream);
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (excel != null)
                    excel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
