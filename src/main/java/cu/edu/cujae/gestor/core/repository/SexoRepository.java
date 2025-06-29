package cu.edu.cujae.gestor.core.repository;

import cu.edu.cujae.gestor.core.model.Rol;
import cu.edu.cujae.gestor.core.model.Sexo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SexoRepository extends JpaRepository<Sexo,Long> {
    boolean existsByNombreSexoEquals(String sexo);

    Rol getSexoByNombreEquals(String nombre);
}
