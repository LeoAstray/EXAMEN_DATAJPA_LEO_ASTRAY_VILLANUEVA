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
		System.out.println("Count de Asignaturas: " + asignaturaRepository.count());
		System.out.println("Count de Estudiantes: " + estudianteRepository.count());
		System.out.println("Count de Matriculas: " + matriculaRepository.count());

		// Ejecutamos findAll sobre un estudiante, mostrando la relacion con expediente
		estudianteRepository.findAll().forEach(estudiante -> {
			System.out.println("Estudiante: " + estudiante.getNombre() + " " + estudiante.getApellidos());
			System.out.println("Expediente: " + estudiante.getExpedienteAcademico().getNumeroExpediente());
		});

		// Bloque 2
		// Probamos el metodo de busqueda por dni mostrando los datos por consola
		estudianteRepository.findByDni("12345678A").ifPresent(estudiante -> {
			System.out.println(
					"Estudiante buscaado por DNI: " + estudiante.getNombre() + " " + estudiante.getApellidos());
		});

		// Probamos el metodo de busqueda de matriculas aprobadas e iterar sore el
		// resultado imprimiendo fecha, nota y alumno
		matriculaRepository.findByCalificacionGreaterThanEqual(5.0).forEach(matricula -> {
			System.out.println("Matriculas aprobadas: " + matricula.getFechaMatriculacion() + " - "
					+ matricula.getCalificacion() + " - " + matricula.getEstudiante().getNombre() + " "
					+ matricula.getEstudiante().getApellidos());
		});

		// Probamos el contador de asignaturas por creditos
		System.out.println("Asignaturas con 6 creditos: " + asignaturaRepository.countByCreditos(6));

		// Bloque 3
		// Invocamos la consulta nativeQuery pasando un parámetro y verificamos que la
		// bdd devuelva los registros
		System.out.println(
				"Nombres completos de los estudiantes en AD-01: "
						+ estudianteRepository.findNombresCompletosByCodigoAsignatura("AD-01").toString());
	}

}
