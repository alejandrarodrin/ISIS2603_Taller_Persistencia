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

    private String nombre;

    private int año;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
}
