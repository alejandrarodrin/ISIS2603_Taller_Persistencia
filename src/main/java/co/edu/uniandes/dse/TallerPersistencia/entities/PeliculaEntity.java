package co.edu.uniandes.dse.TallerPersistencia.entities;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import co.edu.uniandes.dse.TallerPersistencia.entities.DirectorEntity;
import co.edu.uniandes.dse.TallerPersistencia.entities.Entity;




@Entity

public class PeliculaEntity extends BaseEntity {

    private String titulo;

    private Integer anioLanzamiento;

    @OneToMany(mappedBy = "director", fetch = FetchType.LAZY)
    private List<DirectorEntity> directoresList = new ArrayList<>();

    @OneToMany(mappedBy = "pelicula", fetch = FetchType.LAZY)
    private List<ActorEntity> actoresList = new ArrayList<>();


    
}
