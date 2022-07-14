package com.example.retoreactivefuntional.calculo;

import org.springframework.boot.SpringApplication;

import java.util.function.BiFunction;

/**
 * Clase que representa y configura la solucion al ejercicio de la derivada y antiderivada de una expresion
 * matematica
 * @author Erick Diaz
 * @date 14-07-2022
 */
public class Calculo {
    /**
     * Funcion que desarrolla la logica de una derivada simple de un monomio, obtiene como parametros
     * el coeficiente numerico del monomio y tambien el exponente al que esta elevado la variable
     * @param coeficiente
     * @param potencia
     * @return {String}
     */
    public String derivadaDeUnMonomio(Double coeficiente,Double potencia){
        if(coeficiente==0)return "La derivada de 0 es 0";
        return potencia==0?String.format("La derivada de %sX^%s es igual a 0",coeficiente,potencia):String.format("La derivada de %sX^%s es: %sX^%s",coeficiente,potencia,coeficiente*potencia,potencia-1);
    }

    /**
     * Funcion que desarrolla la logica de una antiderivada simple de un monomio, obtiene como parametros
     * el coeficiente numerico del monomio y tambien el exponente al que esta elevada la variable
     * @param coeficiente
     * @param potencia
     * @return {String}
     */
    public String integralDeUnMonomio(Double coeficiente,Double potencia){
        BiFunction<Double, Double, Double> productoCoeficientePotencia = (coeficient, potency) -> (coeficient / (potency + 1) == 1)?1D:coeficient / (potency + 1);
         return String.format("La antiderivada de:  %sX^%s  es: %sX^%s+C",coeficiente,potencia,productoCoeficientePotencia.apply(coeficiente,potencia),potencia+1);
    }


    public static void main(String[] args) {
        SpringApplication.run(Calculo.class, args);
        Calculo calculo = new Calculo();
        System.out.println(calculo.derivadaDeUnMonomio(7.0,3.0));
        System.out.println(calculo.integralDeUnMonomio(5.0,2.0));
    }
}
