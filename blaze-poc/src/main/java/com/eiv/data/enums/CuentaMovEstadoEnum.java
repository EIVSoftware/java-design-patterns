package com.eiv.data.enums;

public enum CuentaMovEstadoEnum {

    ANULADO(2),
    INICIADO(80),
    EN_TRAMITE(81),
    CANCELADO(82),
    APLICADO(83),
    NO_APLICADO(84),
    NO_PASO_POR_CAJA(85),
    CUENTA_CERRADA(86),
    CUENTA_INMOVILIZADA(88);

    private int dbValue;

    private CuentaMovEstadoEnum(int dbValue) {
        this.dbValue = dbValue;
    }

    public int getDbValue() {
        return dbValue;
    }

    public static CuentaMovEstadoEnum of(int dbValue) {
        switch (dbValue) {
            case 2:
                return ANULADO;
            case 80:
                return INICIADO;
            case 81:
                return EN_TRAMITE;
            case 82:
                return CANCELADO;
            case 83:
                return APLICADO;
            case 84:
                return NO_APLICADO;
            case 85:
                return NO_PASO_POR_CAJA;
            case 86:
                return CUENTA_CERRADA;
            case 88:
                return CUENTA_INMOVILIZADA;
            default:
                throw new IllegalArgumentException(String.format(
                        "EL VALOR %s NO SE RECONOCE COMO UNA CONSTANTE DE"
                        + " <CuentaMovEstadoEnum>", dbValue));
        }
    }
}
