package com.crud.prueba.service;

import com.crud.prueba.domain.Libro;
import java.util.List;

public interface LibroService {
    public List<Libro> listrarLibros();
    
    public void guardar(Libro libro);
    
    public void eliminar(Libro libro);
    
    public Libro buscarLibro(Libro libro);
}
