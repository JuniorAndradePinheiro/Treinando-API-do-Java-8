import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
 
public class Exercicio2 {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<String>();
		palavras.add("Alura");
		palavras.add("Casa do Código");
		palavras.add("Caelum");

//		palavras.forEach(new Consumer<String>(){
//		    public void accept(String palavra) {
//		        System.out.println(palavra);
//		    }
//		});
		
		//palavras.sort((String s1, String s2) -> Integer.compare(s1.length(), s2.length()));
		palavras.sort(Comparator.comparing( s -> s.length()));
		palavras.sort(Comparator.comparing(String::length));
		
		
		palavras.forEach(word -> System.out.println(word));
		palavras.forEach(System.out::println);
	}

}
