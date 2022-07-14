package com.example.retoreactivefuntional.emails;

import java.util.List;

public class DataUtil {
    private final List<Email> listaDeEmails = List.of(
            new Email("xvega19@gmail.com",true),
            new Email("ignaramallo3@gmail.com",false),
            new Email("SFDaniefranco@gmail.com",true),
            new Email("tattortega.28@gmail.com",false),
            new Email(
                    "felipemaringiraldo@hotmail.com",true),
            new Email("oscarfarfan92@gmail.com",true),
            new Email("esteban.ea145@gmail.com",true),
            new Email("luismonroy1014@gmail.com",false),
            new Email("steventflorez94@gmail.com",true),
            new Email("pealveco@gmail.com",false),
            new Email("alejandro.yandd@gmail.com",false),
            new Email("mateog147@hotmail.com",false),
            new Email("diegofelipem99@gmail.com",true),
            new Email("erdiazb@gmail.com",false),
            new Email("duvanleal65@gmail.com",true),
            new Email("juandavidamayaardila@gmail.com",true),
            new Email("miller.gallegof@gmail.com",true),
            new Email("juandavidnaranjo75@gmail.com",true),
            new Email("santiago.m200@outlook.es",false),
            new Email("mmaurogg@gmail.com",false),
            new Email("danistcruz@gmail.com",true),
            new Email("jhedacro@gmail.com",false),
            new Email("sebama96@gmail.com",false),
            new Email("Job.andresvalencia@gmail.com",true),
            new Email("hernanvelasquez025@gmail.com",true),
            new Email("abced@hotmail.com",true),
            new Email("abced@hotmail.com",true),
            new Email("erickdiaz@outlook.com",true),
            new Email("erickd@outlook.com",false),
            new Email("erick123@hotmail.com",true)
    );



    public List<Email> getListaDeEmails() {
        return listaDeEmails;
    }
}
