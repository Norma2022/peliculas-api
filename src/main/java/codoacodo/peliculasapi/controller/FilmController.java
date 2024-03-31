package codoacodo.peliculasapi.controller;

import codoacodo.peliculasapi.model.Film;
import codoacodo.peliculasapi.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class FilmController {


    @Autowired
    FilmService filmService;

    @GetMapping("")
    public List<Film> getAllFilms(){
        return filmService.traerTodosLosFilms();
    }

    @PostMapping("/agregar")
    public void createFilm(@RequestBody Film film){
        filmService.crearFilm(film);
    }

    @GetMapping("/{id}")
    public Film findFilmById(@PathVariable Long id){
        return filmService.buscarFilmPorId(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteFilm(@PathVariable Long id){
        filmService.borrarFilmPorId(id);
    }

    @PutMapping("/actualizar")
    public Film updateFilm(@RequestBody Film film){
        return filmService.actualizarFilm(film);
    }
}

