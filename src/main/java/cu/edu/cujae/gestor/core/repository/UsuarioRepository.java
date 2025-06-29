package cu.edu.cujae.gestor.core.repository;

import cu.edu.cujae.gestor.core.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
