package com.crud.prueba.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
// Anotación que contiene los métodos básicos de una Entidad (Set, Get, Constructor, etc).
@Data
// Anotación que indica que la clase es una ENTIDAD.
@Entity
// Anotación que corrije el posible error de síntaxis del nombre de una tabla.
@Table(name = "libro")
public class Libro implements Serializable{
    private static final long serialVersionUID = 1L;
    // Indica el campo que es PK
    @Id
    // Indica que este valor (el id) es autoincrementable.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_libro;
    private String nombre;
    private String paginas;
    private String autor;
    private String genero;
}
