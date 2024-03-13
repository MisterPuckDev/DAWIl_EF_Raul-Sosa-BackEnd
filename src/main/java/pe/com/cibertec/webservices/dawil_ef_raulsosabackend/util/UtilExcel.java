package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.util;

import org.apache.poi.ss.usermodel.*;

public class UtilExcel {
	
public static final String GUION = "-";
	
	public static CellStyle setEstiloHeadIzquierda(Workbook excel) {
		Font fuente = excel.createFont();
		fuente.setFontHeightInPoints((short) 10);
		fuente.setFontName("Arial");
		fuente.setBold(true);
		fuente.setColor(IndexedColors.WHITE.getIndex());
		
		CellStyle estiloCeldaIzquierda = excel.createCellStyle();
		estiloCeldaIzquierda.setWrapText(true);
		estiloCeldaIzquierda.setAlignment(HorizontalAlignment.LEFT);
		estiloCeldaIzquierda.setVerticalAlignment(VerticalAlignment.CENTER);
		estiloCeldaIzquierda.setFont(fuente);
		estiloCeldaIzquierda.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
		estiloCeldaIzquierda.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		return estiloCeldaIzquierda;
	}
	
	public static CellStyle setEstiloHeadCentrado(Workbook excel) {
		Font fuente = excel.createFont();
		fuente.setFontHeightInPoints((short) 10);
		fuente.setFontName("Arial");
		fuente.setBold(true);
		fuente.setColor(IndexedColors.WHITE.getIndex());
		
		CellStyle estiloCeldaCentrado = excel.createCellStyle();
		estiloCeldaCentrado.setWrapText(true);
		estiloCeldaCentrado.setAlignment(HorizontalAlignment.CENTER);
		estiloCeldaCentrado.setVerticalAlignment(VerticalAlignment.CENTER);
		estiloCeldaCentrado.setFont(fuente);
		estiloCeldaCentrado.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
		estiloCeldaCentrado.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		return estiloCeldaCentrado;
	}

	public static CellStyle setEstiloNormalCentrado(Workbook excel) {
		Font fuente = excel.createFont();
		fuente.setFontHeightInPoints((short) 10);
		fuente.setFontName("Arial");
		fuente.setBold(false);

		CellStyle estiloCeldaCentrado = excel.createCellStyle();
		estiloCeldaCentrado.setWrapText(true);
		estiloCeldaCentrado.setAlignment(HorizontalAlignment.CENTER);
		estiloCeldaCentrado.setVerticalAlignment(VerticalAlignment.CENTER);
		estiloCeldaCentrado.setFont(fuente);
		return estiloCeldaCentrado;
	}
	public static CellStyle setEstiloNormalIzquierdo(Workbook excel) {
		Font fuente = excel.createFont();
		fuente.setFontHeightInPoints((short) 10);
		fuente.setFontName("Arial");
		fuente.setBold(false);

		CellStyle estiloCeldaCentrado = excel.createCellStyle();
		estiloCeldaCentrado.setWrapText(true);
		estiloCeldaCentrado.setAlignment(HorizontalAlignment.LEFT);
		estiloCeldaCentrado.setVerticalAlignment(VerticalAlignment.CENTER);
		estiloCeldaCentrado.setFont(fuente);
		return estiloCeldaCentrado;
	}
	
}