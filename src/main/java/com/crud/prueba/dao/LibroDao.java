package com.crud.prueba.dao;

import com.crud.prueba.domain.Libro;
import org.springframework.data.repository.CrudRepository;

// Se indica la clase Domain y el tipo de dato del ID o PK de esta.
public interface LibroDao extends CrudRepository<Libro, Long>{
    
}
