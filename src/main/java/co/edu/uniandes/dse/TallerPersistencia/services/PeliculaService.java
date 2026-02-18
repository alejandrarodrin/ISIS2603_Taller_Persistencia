package co.edu.uniandes.dse.TallerPersistencia.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.TallerPersistencia.entities.PeliculaEntity;
import co.edu.uniandes.dse.TallerPersistencia.repositories.PeliculaRepository;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    
    public PeliculaEntity crearPelicula(PeliculaEntity pelicula) throws IllegalArgumentException {

        if (pelicula.getNombre() == null || pelicula.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la película no puede ser vacío.");
        }

        Optional<PeliculaEntity> peliculaExistente = peliculaRepository.findByNombre(pelicula.getNombre());
        if (peliculaExistente.isPresent()) {
            throw new IllegalArgumentException("Ya existe una película con este mismo nombre.");
        }

        if (pelicula.getAño() <= 1930) {
            throw new IllegalArgumentException("El año de la película debe ser mayor a 1930.");
        }

        return peliculaRepository.save(pelicula);
    }
}

