package cu.edu.cujae.gestor.core.repository;

import cu.edu.cujae.gestor.core.model.Rol;
import cu.edu.cujae.gestor.core.model.Sexo;
import cu.edu.cujae.gestor.core.model.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {
    Sexo rol(Rol rol);
}
