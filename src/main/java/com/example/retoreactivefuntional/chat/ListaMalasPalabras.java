package com.example.retoreactivefuntional.chat;

import java.util.Set;

/**
 * Clase que almacena la lista de malas palabras que hay que reemplazar
 * @author Erick Diaz
 * @date 14-07-2022
 */
public class ListaMalasPalabras {

    private final Set<String> malasPalabras=Set.of(
            "hijueputa","malparido","pirobo","puta","puto","maricon","idiota","cabron","gonorrea","malparida",
            "piroba","cabrona","maricona","verga"
    );

    public Set<String> getMalasPalabras() {
        return malasPalabras;
    }
}
