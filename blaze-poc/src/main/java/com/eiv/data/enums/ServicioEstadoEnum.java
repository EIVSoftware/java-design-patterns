package com.eiv.data.enums;

public enum ServicioEstadoEnum {

    INACTIVO(0),
    ACTIVO(1),
    ANULADO(2);

    private int dbValue;

    private ServicioEstadoEnum(int dbValue) {
        this.dbValue = dbValue;
    }

    public int getDbValue() {
        return dbValue;
    }

    public static ServicioEstadoEnum of(int dbValue) {

        switch (dbValue) {
            case 0:
                return INACTIVO;
            case 1:
                return ACTIVO;
            case 2:
                return ANULADO;
            default:
                throw new IllegalArgumentException(String.format(
                    "EL VALOR %s NO SE RECONOCE COMO UNA CONSTANTE DE <ServicioEstadoEnum>",
                    dbValue));
        }
    }
}
