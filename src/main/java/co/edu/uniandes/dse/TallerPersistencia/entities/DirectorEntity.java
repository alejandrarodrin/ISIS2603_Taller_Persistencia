package co.edu.uniandes.dse.TallerPersistencia.entities;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import co.edu.uniandes.dse.TallerPersistencia.entities.PeliculaEntity;


@Entity

public class DirectorEntity extends BaseEntity {

    private String name;

    private String biografia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pelicula_id")
    private PeliculaEntity pelicula;

    @OneToMany(mappedBy = "director", fetch = FetchType.LAZY)
    private List<PeliculaEntity> peliculasList = new ArrayList<>();



    
}
