package com.example.retoreactivefuntional.emails;

public class Email implements Comparable<Email>{

    private final String correo;
    private  Boolean enviado;

    public Email(String correo,Boolean enviado) {
        this.correo = correo;
        this.enviado=enviado;
    }

    public Boolean getEnviado() {
        return enviado;
    }

    public void setEnviado(Boolean enviado) {
        this.enviado = enviado;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int compareTo(Email o) {
        return 0;
    }
}
