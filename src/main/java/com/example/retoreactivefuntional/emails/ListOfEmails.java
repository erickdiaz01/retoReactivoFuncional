package com.example.retoreactivefuntional.emails;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListOfEmails {
    private Flux<Email> listaEmails;
    DataUtil emails = new DataUtil();

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

public Flux<Comparable<? extends Comparable<?>>> comprobarCorreosCorrectos(){

        return this.listaEmails.map(email -> {
        Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mat = pat.matcher(email.getCorreo());
        return mat.matches()==true?email:false;
    });
}

public Mono<Long> cantidadDeCorreos(){

        return this.listaEmails.count();
}

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









}
