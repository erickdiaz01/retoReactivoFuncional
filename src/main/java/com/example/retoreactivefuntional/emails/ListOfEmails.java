package com.example.retoreactivefuntional.emails;

import org.springframework.boot.SpringApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que representa y configura la logica de la solucion del ejercicio de los correos,
 * tiene como unico atribulo la lista de emails a manejar
 */
public class ListOfEmails {
    private Flux<Email> listaEmails;
    DataUtil emails = new DataUtil();

    /**
     * Enums de los posibles dominios de los correos
     */
    enum Dominio{
        GMAIL("@gmail.com"),
        OUTLOOK("@outlook.com"),
        HOTMAIL("@hotmail.com");

        String domain;

        public String getDomain() {
            return domain;
        }

        Dominio(String domain) {
          this.domain=domain;
        }
    }


    public ListOfEmails() {
        this.listaEmails = Flux.fromIterable(emails.getListaDeEmails());
    }

    public Flux<Email> emailsSinRepetir(){
        return this.listaEmails.distinct();
    }

    /**
     * Genera un Flux a partir de 3 listas de correos, cada una representada por un dominio en especial
     * @return {Flux<Email>}
     */
    public Flux<Email> listasDeDominios(){

        var listaDeDominioGmail =this.listaEmails.filter(email ->{
           Pattern pat = Pattern.compile(Dominio.GMAIL.getDomain());
           Matcher mat = pat.matcher(email.getCorreo());
           return mat.matches();
       });
    var listaDeDominioOutlook =this.listaEmails.filter(email ->{
        Pattern pat = Pattern.compile(Dominio.OUTLOOK.getDomain());
        Matcher mat = pat.matcher(email.getCorreo());
        return mat.matches();
    });
    var listaDeDominioHotmail =this.listaEmails.filter(email ->{
        Pattern pat = Pattern.compile(Dominio.HOTMAIL.getDomain());
        Matcher mat = pat.matcher(email.getCorreo());
        return mat.matches();
    });

return Flux.concat(listaDeDominioGmail,listaDeDominioOutlook,listaDeDominioHotmail);
}

    /**
     *Comprueba si los correos almacenados en la lista son validos o no y los devuelve como un Flux
     * @return {Flux<Comparable>}
     */
    public Flux<Comparable<? extends Comparable<?>>> comprobarCorreosCorrectos(){

        return this.listaEmails.map(email -> {
        Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mat = pat.matcher(email.getCorreo());
        return mat.matches()==true?email:"Correo no valido";
    });
}


    /**
     * Funcicion que contabiliza cuantos correos hay en la lista
     * @return {Mono<Long>}
     */
    public Mono<Long> cantidadDeCorreos(){

        return this.listaEmails.count();
}

    /**
     * Funcion que contabiliza la cantidad de correos que hay por cada dominio en especial
     * @return {Flux<Long>}
     */
    public Flux<Long> cantidadDeCorreosDominio(){
        var cantidadCorreosConGmail = this.listaEmails.map(email -> email.getCorreo()).filter(s ->
            s.contains(Dominio.GMAIL.domain)
        ).count();
    var cantidadCorreosConOutlook = this.listaEmails.map(email -> email.getCorreo()).filter(s ->
            s.contains(Dominio.OUTLOOK.domain)
    ).count();
    var cantidadCorreosConHotmail = this.listaEmails.map(email -> email.getCorreo()).filter(s ->
            s.contains(Dominio.HOTMAIL.domain)
    ).count();
    return Flux.concat(cantidadCorreosConGmail,cantidadCorreosConOutlook,cantidadCorreosConHotmail);

}

    /**
     * Funcion que verifica el estado de enviado a cada correo, si le fue enviado un correo esta funcion
     * cambia su estado a un false y vuelve a almacenar el correo con el nuevo estado
     * @return {Flux<Email>}
     */
    public Flux<Email>cambiarEstadoDeEnviado(){
        return listaEmails.map(email -> {
           if(email.getEnviado())email.setEnviado(false);
            return email;
        });
}

    public static void main(String[] args) {

        SpringApplication.run(ListOfEmails.class, args);
        ListOfEmails listOfEmails = new ListOfEmails();
        System.out.println(listOfEmails.cantidadDeCorreos().block());
        listOfEmails.cantidadDeCorreosDominio().toIterable().forEach(aLong -> System.out.println(aLong.longValue()));
        listOfEmails.listasDeDominios().toIterable().forEach(email -> System.out.println(email.getCorreo()));
        listOfEmails.comprobarCorreosCorrectos();
    }





}
