package leo.astray.examenjpa.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import leo.astray.examenjpa.enums.Convocatoria;

@Entity
@Table(name = "matriculas")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula")
    private Long id;

    @Column(nullable = false)
    private LocalDate fechaMatriculacion;

    @Column
    private Double calificacion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Convocatoria convocatoria;
}
