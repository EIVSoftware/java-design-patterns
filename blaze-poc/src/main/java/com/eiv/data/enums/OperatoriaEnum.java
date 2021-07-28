package com.eiv.data.enums;

public enum OperatoriaEnum {

    GENERAL(0),
    CUENTA_VISTA(3);

    private int dbValue;

    private OperatoriaEnum(int dbValue) {
        this.dbValue = dbValue;
    }

    public int getDbValue() {
        return dbValue;
    }

    public static OperatoriaEnum of(int dbValue) {

        switch (dbValue) {
            case 0:
                return GENERAL;
            case 3:
                return CUENTA_VISTA;
            default:
                throw new IllegalArgumentException(String.format(
                    "EL VALOR %s NO SE RECONOCE COMO UNA CONSTANTE DE <OperatoriaEnum>",
                    dbValue));
        }
    }
}
