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

    public responseDto(int codigo, String mensaje, Object respuesta, responseDtoEnum rspEnum){
        this.codigo = codigo;
        this.mensaje = String.format("[%s]: %s", rspEnum.name(), mensaje);
        this.respuesta = respuesta;
        this.rspEnum = rspEnum;
    }
    public responseDto(int codigo, String mensaje, responseDtoEnum rspEnum){
        this.codigo = codigo;
        this.mensaje = String.format("[%s]: %s", rspEnum.name(), mensaje);
        this.respuesta = null;
        this.rspEnum = rspEnum;
    }
    private void clear(){
        this.respuesta = null;
        this.mensaje = "";
        this.codigo = -1;
    }
    public void setResponse(int codigo, String mensaje, Object respuesta,  responseDtoEnum rspEnum){
        clear();
        this.codigo = codigo;
        this.mensaje = String.format("[%s]: %s", rspEnum.name(), mensaje);
        this.respuesta = respuesta;
        this.rspEnum = rspEnum;
    }
    public void setResponse(int codigo, String mensaje,  responseDtoEnum rspEnum){
        clear();
        this.codigo = codigo;
        this.mensaje = String.format("[%s]: %s", rspEnum.name(), mensaje);
        this.rspEnum = rspEnum;
    }
}
