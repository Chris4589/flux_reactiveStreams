package com.webflux.webflux.models.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("productos")
public class Producto {
  
  @Id 
  private String id;

  private String nombre;

  private Date createAt;

  public Producto(String nombre) {
    this.nombre = nombre;
  }

  public Producto() {}

  public String getId() {
    return this.id;
  }
  public void setId(String id) {
    this.id = id;
  }

  public String getNombre() {
    return this.nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Date getCreateAt() {
    return this.createAt;
  }
  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }

}
