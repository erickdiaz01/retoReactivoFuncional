package com.example.retoreactivefuntional.emails;

/**
 * Clase que modela la entidad email para la solucion del ejercicio del manejo de la lista de correos electronicos,
 * tiene como atributos la direccion de correo electronico y el estado de si le fue enviado o no algun correo
 */
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
