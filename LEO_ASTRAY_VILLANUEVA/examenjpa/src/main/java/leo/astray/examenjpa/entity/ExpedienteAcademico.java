package leo.astray.examenjpa.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "expedientes")
public class ExpedienteAcademico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String numeroExpediente;

    @Column(nullable = false)
    private LocalDate fechaApertura;

    @Column(nullable = false)
    private Double notaMediaAcceso;

    @OneToOne(mappedBy = "expedienteAcademico")
    private Estudiante estudiante;

    public ExpedienteAcademico() {
    }

    public ExpedienteAcademico(String numeroExpediente, LocalDate fechaApertura, Double notaMediaAcceso) {
        this.numeroExpediente = numeroExpediente;
        this.fechaApertura = fechaApertura;
        this.notaMediaAcceso = notaMediaAcceso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(String numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Double getNotaMediaAcceso() {
        return notaMediaAcceso;
    }

    public void setNotaMediaAcceso(Double notaMediaAcceso) {
        this.notaMediaAcceso = notaMediaAcceso;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

}
