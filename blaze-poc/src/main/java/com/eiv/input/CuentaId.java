package com.eiv.input;

import com.eiv.data.enums.OperatoriaEnum;

public interface CuentaId extends ServicioId {

    default @Override OperatoriaEnum getOperatoria() {
        return OperatoriaEnum.CUENTA_VISTA;
    }

}
