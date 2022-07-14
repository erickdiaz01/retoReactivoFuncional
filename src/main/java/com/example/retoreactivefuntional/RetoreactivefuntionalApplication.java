package com.example.retoreactivefuntional;

import com.example.retoreactivefuntional.emails.ListOfEmails;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RetoreactivefuntionalApplication {



	public static void main(String[] args) {

		SpringApplication.run(RetoreactivefuntionalApplication.class, args);
		ListOfEmails listOfEmails = new ListOfEmails();
		listOfEmails.cantidadDeCorreos();
		listOfEmails.cantidadDeCorreosDominio();
		listOfEmails.comprobarCorreosCorrectos();
		listOfEmails.listasDeDominios();
	}

}
