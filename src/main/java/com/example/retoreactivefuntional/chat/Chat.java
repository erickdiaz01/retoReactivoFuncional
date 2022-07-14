package com.example.retoreactivefuntional.chat;

import org.springframework.boot.SpringApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Chat {
    private final String usuario;
    private Flux<Mono<String>> busDeChat;

    @Override
    public String toString() {
        return busDeChat.map(stringMono -> stringMono.toString()).toString();
    }

    private final Set<String> malasPalabras= new ListaMalasPalabras().getMalasPalabras();
    Scanner sc = new Scanner(System.in);
    public Chat() {
        System.out.println("Ingrese el nombre de usuario");
        this.usuario = sc.nextLine();
        System.out.println(String.format("Bienvenido %s!",this.usuario));
        this.busDeChat=Flux.empty();
    }

    public String getUsuario() {
        return usuario;
    }

    public Flux<Mono<String>> getBusDeChat() {
        return busDeChat;
    }

    public void setBusDeChat(Flux<Mono<String>> busDeChat) {
        this.busDeChat = busDeChat;
    }

    public Mono<String> mandarMensaje(){

        System.out.println("Envie un nuevo mensaje: ");
        String mensaje = sc.nextLine();
        List<String> mensajeEnviado = Arrays.stream(mensaje.split(" ")).collect(Collectors.toList());
        Mono<String> mensajeCambiado = Flux.fromIterable(mensajeEnviado).map(mensajeUsuario-> cambiarMalasPalabras(mensajeUsuario)).reduce((""),(concatenacion,mensajeAConcatenar)->concatenacion+=" "+mensajeAConcatenar);
        mensajeCambiado.subscribe(s -> System.out.println(s));
        setBusDeChat(this.busDeChat.concatWithValues(mensajeCambiado));
return mensajeCambiado;    }

    public String cambiarMalasPalabras(String mensaje){

return malasPalabras.contains(mensaje.toLowerCase())? "****":mensaje;
    }
    public static void main(String[] args) {
        SpringApplication.run(Chat.class, args);
        Chat chat = new Chat();
        Scanner sc = new Scanner(System.in);
        String decision;
        do{
            chat.mandarMensaje();
            System.out.println("Ingrese cualquier caracter si quiere enviar otro mensaje");
             decision = sc.nextLine();
        }while (decision!="");
        System.out.println("Gracias por utilizar nuestro servicio "+chat.getUsuario());
    }
}


