package com.crud.prueba.web;

import com.crud.prueba.domain.Libro;
import com.crud.prueba.service.LibroService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// Anotación que permite que la Clase sea reconocida como un controlador y componente administrado por Spring
@Controller
// Logging
@Slf4j
public class InitController {
    
    @Autowired
    private LibroService libroService;
    
    @GetMapping("/")
    public String inicio(Model model){
        // Buscar todos los libros.
        List<Libro> libros = libroService.listrarLibros();
        model.addAttribute("libros", libros);
        return "index";
    }
    
    // Método para redirigir a la página
    @GetMapping("/agregar")
    public String agregar(Libro libro){
        return "actualizar";
    }
    // No es GET debido al método en que recibe la información del formulario: POST
    @PostMapping("/guardar")
    public String guardar(Libro libro){
        libroService.guardar(libro);
        return "redirect:/";
    }
    
    // En este caso para modificar un libro debe recibir un ID o un campo para encontrar
    // la información de dicho libro, por lo tanto se le debe pasar el campo del id del libro.
    @GetMapping("/editar/{id_libro}")
    public String editar(Libro libro, Model model){
        libro = libroService.buscarLibro(libro);
        model.addAttribute("libro", libro);
        return "actualizar";
    }
    
    @GetMapping("/eliminar/{id_libro}")
    public String eliminar(Libro libro){
        libroService.eliminar(libro);
        return "redirect:/";
    }
}
