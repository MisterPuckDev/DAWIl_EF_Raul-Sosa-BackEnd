package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.auth;

public enum Role {
    ADMIN(1),
    USER(2);

    private final int numericValue;

    Role(int numericValue) {
        this.numericValue = numericValue;
    }

    public int getNumericValue() {
        return numericValue;
    }
}
