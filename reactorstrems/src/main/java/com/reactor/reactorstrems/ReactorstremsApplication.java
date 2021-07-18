package com.reactor.reactorstrems;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class ReactorstremsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ReactorstremsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		List<String> username = new ArrayList<>();
		username.add("Pedro");
		username.add("Diego");
		username.add("chinga tu madre");
		username.add("chinga tu vieja");

		Flux<String> usernameFlux = Flux.fromIterable(username);

		Flux<String> username2 = usernameFlux.filter( nombre -> nombre.contains("Diego") )
			.doOnNext(elemento -> 
				System.out.println(elemento)
			)
			.map(nombre -> nombre.toUpperCase()); //
		
			username2.subscribe( data -> {
			System.out.println("data: " + data);
		}, err -> {
			System.out.println("err: " + err);
		}, new Runnable(){

			@Override
			public void run() {
				System.out.println("Finalizo la ejecucion del obserbable, solo si todo esta correcto.");
				
			}
			
		});

		//flux = flujo
		//just = solo
		//doOnNext = hacer el siguiente
		Flux<String> nombres = Flux.just("Pedro", "Diego", "chinga tu madre", "chinga tu vieja");
			//puedo ejecutar el map antes we o varios map
			Flux<String> nombres2 = nombres.filter( nombre -> nombre.contains("chinga") )
			.doOnNext(elemento -> 
				System.out.println(elemento)
			)
			.map(nombre -> nombre.toUpperCase()); //
		
			nombres2.subscribe( data -> {
			System.out.println("data: " + data);
		}, err -> {
			System.out.println("err: " + err);
		}, new Runnable(){

			@Override
			public void run() {
				System.out.println("Finalizo la ejecucion del obserbable, solo si todo esta correcto.");
				
			}
			
		});
	}

}
