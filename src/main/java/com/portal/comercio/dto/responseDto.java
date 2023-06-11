package com.portal.comercio.dto;

import lombok.Data;
@Data
public class responseDto {
    private int codigo;
    private String mensaje;
    private Object respuesta;

    public responseDto() {
    }

    public responseDto(int codigo, String mensaje, Object respuesta){
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.respuesta = respuesta;
    }

    private void clear(){
        this.respuesta = null;
        this.mensaje = "";
        this.codigo = -1;
    }

    public void setResponse(int codigo, String mensaje, Object respuesta){
        clear();
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.respuesta = respuesta;
    }


    public void setResponse(int codigo, String mensaje){
        clear();
        this.codigo = codigo;
        this.mensaje = mensaje;
    }
}
