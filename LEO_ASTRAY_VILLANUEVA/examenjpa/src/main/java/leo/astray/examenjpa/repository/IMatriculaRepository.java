package leo.astray.examenjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import leo.astray.examenjpa.entity.Matricula;

public interface IMatriculaRepository extends JpaRepository<Matricula, Long> {

    List<Matricula> findByCalificacionGreaterThanEqual(Double calificacion);

}
