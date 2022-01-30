import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestaCursoStream {

	public static void main(String[] args) {

		List<Curso> cursos = new ArrayList<>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 133));
		cursos.add(new Curso("C", 55));

		cursos.sort(Comparator.comparing(c -> c.getAlunos()));

		cursos.forEach(c -> {
			System.out.println(c.getNome() + ": " + c.getAlunos());
		});

		cursos.sort(Comparator.comparing(Curso::getAlunos));
		cursos.forEach(Curso::getNome);

		cursos.stream().filter(c -> c.getAlunos() >= 50).forEach(c -> {
			System.out.println(c.getNome() + ": " + c.getAlunos());
		});
		
		Stream<String> nomes = cursos.stream().map(Curso::getNome);
		System.out.println(nomes);
		
		
		cursos.stream()
		   .filter(c -> c.getAlunos() > 50)
		   .map(c -> c.getAlunos())
		   .forEach(System.out::println);
	
		//findAny devolve de forma aleatória um elemento "Optional" (uma nova classe que facilita trabalhar um nulls) que obedeça os critérios do filtro
		cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .findAny();
		
		cursos.stream()
		   .filter(c -> c.getAlunos() > 50).findFirst();

		cursos.stream().mapToInt(c -> c.getAlunos()).average();
		
		cursos.stream()
	    .mapToInt(c -> c.getAlunos())
	    .average();
		
		List<Curso> novalista = cursos.stream().filter(c -> c.getAlunos() > 50).collect(Collectors.toList());
		System.out.println(novalista);
		
		//convertendo o coleção filtrada em lista
		System.out.println(cursos.stream()
		   .filter(c -> c.getAlunos() > 50).collect(Collectors.toList()));
	}

}
