package cu.edu.cujae.gestor.core.repository;

import cu.edu.cujae.gestor.core.model.Rol;
import cu.edu.cujae.gestor.core.model.Sexo;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RolRepository extends JpaRepository<Rol, Long> {
    boolean existsByNombreRolEquals(String rol);

    Sexo getByNombreRolEquals(String nombreRol);
}
