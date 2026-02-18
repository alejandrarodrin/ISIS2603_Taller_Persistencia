package co.edu.uniandes.dse.TallerPersistencia.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.TallerPersistencia.entities.PeliculaEntity;
import co.edu.uniandes.dse.TallerPersistencia.repositories.PeliculaRepository;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import co.edu.uniandes.dse.TallerPersistencia.services.PeliculaService;


@DataJpaTest
@Transactional
@Import(PeliculaService.class) 

public class PeliculaServiceTest {

    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private TestEntityManager entityManager;

    private PodamFactory factory = new PodamFactoryImpl();

    @BeforeEach
    void setUp() {
        clearData();
        insertData();
    }

    private void clearData() {

        entityManager.getEntityManager()
      .createQuery("delete from PeliculaEntity")
      .executeUpdate();


        peliculaRepository.deleteAll();
    }

    
    @Test
    void testCrearPeliculaOK() {

        PeliculaEntity nuevaPelicula = factory.manufacturePojo(PeliculaEntity.class);
        nuevaPelicula.setNombre("Matrix");
        nuevaPelicula.setAño(1999);

        PeliculaEntity resultado = peliculaService.crearPelicula(nuevaPelicula);

        assertNotNull(resultado);
        assertEquals(1999, resultado.getAño());
    }

    
    @Test
    void testCrearPeliculaAnioInvalido() {

        PeliculaEntity nuevaPelicula = factory.manufacturePojo(PeliculaEntity.class);
        nuevaPelicula.setNombre("Pelicula");
        nuevaPelicula.setAño(1900);

        assertThrows(IllegalArgumentException.class, () -> {
            peliculaService.crearPelicula(nuevaPelicula);
        });
    }
}
