package cu.edu.cujae.gestor.core.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Bug(
        @JsonAlias("titulo") String title,
        @JsonAlias("descripcion") String description,
        @JsonAlias("prioridad") String priority) {
}
