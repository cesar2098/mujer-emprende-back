package com.portal.comercio.dto;

public class responseDto {
    private int codigo;
    private String mensaje;
    private Object respuesta;

    public responseDto() {
    }
    
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public Object getRespuesta() {
        return respuesta;
    }
    public void setRespuesta(Object respuesta) {
        this.respuesta = respuesta;
    }
}
