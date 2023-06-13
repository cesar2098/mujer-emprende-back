package com.portal.comercio.dto;

import lombok.Data;
@Data
public class responseDto {
    private int codigo;
    private String mensaje;
    private Object respuesta;
    private responseDtoEnum rspEnum;
    public responseDto() {
    }
}
