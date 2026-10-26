package leo.astray.examenjpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import leo.astray.examenjpa.entity.Estudiante;

public interface IEstudianteRepository extends JpaRepository<Estudiante, Long> {

    Optional<Estudiante> findByDni(String dni);

    @Query(value = "SELECT CONCAT(e.nombre, ' ', e.apellidos) FROM estudiantes e "
            + "INNER JOIN matriculas m ON e.id_estudiante = m.id_estudiante "
            + "INNER JOIN asignaturas a ON m.id_asignatura = a.id_asignatura "
            + "WHERE a.codigo = :codigo", nativeQuery = true)
    List<String> findNombresCompletosByCodigoAsignatura(@Param("codigo") String codigo);

}
