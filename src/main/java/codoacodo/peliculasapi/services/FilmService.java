package codoacodo.peliculasapi.services;

import codoacodo.peliculasapi.model.Film;
import codoacodo.peliculasapi.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    FilmRepository filmRepository;


    public List<Film> traerTodosLosFilms() {
        return filmRepository.findAll();
    }

    public void crearFilm(Film film) {
        filmRepository.save(film);
    }

    public Film buscarFilmPorId(Long id) {
        return filmRepository.findById(id).orElse(null);
    }

    public void borrarFilmPorId(Long id) {
        filmRepository.deleteById(id);
    }

    public Film actualizarFilm(Film film) {
        filmRepository.save(film);
        return filmRepository.findById(film.getId()).orElse(null);
    }
}
