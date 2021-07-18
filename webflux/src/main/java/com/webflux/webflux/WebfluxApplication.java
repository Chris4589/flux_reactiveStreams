package com.webflux.webflux;

import java.util.Date;

import com.webflux.webflux.models.dao.IProductoDao;
import com.webflux.webflux.models.entity.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class WebfluxApplication implements CommandLineRunner {

	@Autowired
	private IProductoDao dao;

	public static void main(String[] args) {
		SpringApplication.run(WebfluxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Flux.just( new Producto("PC Gammer"), new Producto("TC LCD") )
			.flatMap(product -> {
				product.setCreateAt(new Date());
				return dao.save(product);
			})
			.subscribe( product -> System.out.println(product.getId() + " " + product.getNombre()));
		
	}

}
