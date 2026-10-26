package leo.astray.examenjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import leo.astray.examenjpa.repository.IAsignaturaRepository;
import leo.astray.examenjpa.repository.IEstudianteRepository;
import leo.astray.examenjpa.repository.IMatriculaRepository;

@SpringBootApplication
public class ExamenjpaApplication implements CommandLineRunner {

	@Autowired
	private IAsignaturaRepository asignaturaRepository;

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Autowired
	private IMatriculaRepository matriculaRepository;

	public static void main(String[] args) {
		SpringApplication.run(ExamenjpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Compruebo que me conecta a la base de datos
		System.out.println("Estoy Conectado");

		// Bloque 1
		// Ejecutamos count sobre los 3 repositorios para verificar el data.sql
		System.out.println("Cantidad de Asignaturas: " + asignaturaRepository.count());
		System.out.println("Cantidad de Estudiantes: " + estudianteRepository.count());
		System.out.println("Cantidad de Matriculas: " + matriculaRepository.count());

		// Ejecutamos findAll sobre un estudiante, mostrando la relacion con expediente
		estudianteRepository.findAll().forEach(estudiante -> {
			System.out.println("Estudiante: " + estudiante.getNombre() + " " + estudiante.getApellidos());
			System.out.println("Expediente Académico: " + estudiante.getExpedienteAcademico().getNumeroExpediente());
		});

		// Bloque 2

	}

}
