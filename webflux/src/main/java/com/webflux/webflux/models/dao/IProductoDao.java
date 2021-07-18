package com.webflux.webflux.models.dao;

import com.webflux.webflux.models.entity.Producto;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IProductoDao extends ReactiveMongoRepository<Producto, String> {
  
}
