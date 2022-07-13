package com.example.retoreactivefuntional.emails;

public class Email implements Comparable<Email>{

    private final String correo;
    private final Boolean enviado;

    public Email(String correo) {
        this.correo = correo;
        enviado = false;
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
