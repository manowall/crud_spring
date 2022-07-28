package com.crud.prueba.service;
// Anotación que identifica la Clase como un Servicio.

import com.crud.prueba.dao.LibroDao;
import com.crud.prueba.domain.Libro;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibroServiceImpl implements LibroService{

    // Anotación que inyecta la dependencia del objeto
    @Autowired
    private LibroDao libroDao;
    
    // Sobreescribir
    @Override
    /* Anotación para generar un commit o rollback en caso de que falle el proceso.
     como es consulta y no modifica la información, unicamente se le asigna el permiso de Leer */
    @Transactional(readOnly=true)
    public List<Libro> listrarLibros() {
        return (List<Libro>) libroDao.findAll();
    }

    @Override
    // En este caso si modifica la información, por lo tanto se deja solo la anotación.
    @Transactional
    public void guardar(Libro libro) {
        libroDao.save(libro);
    }

    @Override
    @Transactional
    public void eliminar(Libro libro) {
        libroDao.delete(libro);
    }

    @Override
    @Transactional(readOnly=true)
    public Libro buscarLibro(Libro libro) {
        return libroDao.findById(libro.getId_libro()).orElse(null);
    }
    
}
