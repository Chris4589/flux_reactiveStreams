package com.webflux.webflux.controllers;

import java.time.Duration;

import com.webflux.webflux.models.dao.IProductoDao;
import com.webflux.webflux.models.entity.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class ProductoController {
  
  @Autowired
  private IProductoDao dao; 

  @GetMapping("/listar")
  public Flux<Producto> listar() {
    Flux<Producto> producto = dao.findAll();
    
    return producto;
  }

  @GetMapping("/listar-mono/{id}")
  public Mono<Producto> listarmono(@PathVariable String id) {
    Mono<Producto> producto = dao.findById(id);
    
    return producto;
  }

  @GetMapping("/listar2")//contra presión - basado en cantidad de elementos
  public Flux<Producto> listar2() {
    Flux<Producto> producto = dao.findAll()
    .delayElements(Duration.ofSeconds(1));//contra presión

    //producto.subscribe(System.out::println);
    
    return producto;
  }

  @GetMapping("/listar3")//chunked - basado en cantidad de elementos
  //chunked si es un apaginacion x cant de datos por consulta sin config
  //si son muchos datos si configurar
  public Flux<Producto> listar3() {
    Flux<Producto> producto = dao.findAll().repeat(5000);//contra presión

    producto.subscribe(System.out::println);
    
    return producto;
  }

}
