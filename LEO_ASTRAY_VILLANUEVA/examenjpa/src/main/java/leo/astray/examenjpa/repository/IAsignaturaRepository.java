package leo.astray.examenjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import leo.astray.examenjpa.entity.Asignatura;

public interface IAsignaturaRepository extends JpaRepository<Asignatura, Long> {

    long countByCreditos(Integer creditos);

}
