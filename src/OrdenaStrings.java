import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<String>();
		palavras.add("Alura");
		palavras.add("Casa do Código");
		palavras.add("Caelum");

//		Comparator<String> comparador = new ComparadorPorTamanho();
//		Collections.sort(palavras,comparador);

		// Dando um new na interface Comparator e já implemntado o método e com isso não
		// preciso da classe ComparadorPorTamanho
//		palavras.sort(new Comparator<String>() {
//			@Override
//			public int compare(String s1, String s2) {
//				if(s1.length() < s2.length())
//					return -1;			
//				if(s1.length() > s2.length()) 
//					return 1;			
//				return 0;
//			}});

		// Usando LAMBDA (INTERFACES QUE SÓ TEM UM MÉTODO SÃO CHAMADAS DE INTERFACES FUNCIONAIS)
//		palavras.sort((String s1, String s2 )-> {
//				if(s1.length() < s2.length())
//					return -1;			
//				if(s1.length() > s2.length()) 
//					return 1;			
//				return 0;
//		});

		//esse código faz exatamente a mesma coisa que o código acima. Ao invés de usar o método da Comparator que tive que implementar eu estou usando um métod de comparação que já existe da classe Integer
		palavras.sort((String s1, String s2) -> Integer.compare(s1.length(), s2.length()));
		
		// Esse código é equivalente o de cima, e ao invés de usar o compare de Integer estou usando um método da interface Comparator
		// Para cada Stirng "s" dentro de "palavras" pega o tamanho e passa como parametro para o "comparing" que por sua vez será usado pelo "sort" para ordenar as strings
		palavras.sort(Comparator.comparing(s -> s.length()));
		
		// Aqui estou usando o método reference
		palavras.sort(Comparator.comparing(String::length));
				
		
		//Aqui estou dividindo a linha de cima para mostrar oque está sendo feito de forma mais explicita
		Comparator<String> comparador =  Comparator.comparing(s -> s.length());
		palavras.sort(comparador);

		System.out.println(palavras);

//		Consumer<String> consumidor = new ImprimeNaLinha();
//		palavras.forEach(consumidor);

		// O código abaixo está utilizando algo chamado de classe anônima, que nada mais
		// é do que dar um new direto na interface
		// normalmente não é possível dar um new em uma interface pois faltará
		// argumentos, por conta disso já estou implementando o método que seria
		// implmentado na classe ImprimeNaLinha
		// dessa forma não preciso criar uma classe pequena e instância-la

//		Consumer<String> consumidor = new Consumer<String>(){
//			@Override
//			public void accept(String s) {
//			System.out.println(s);	
//			}
//		};
//		
//		palavras.forEach(consumidor);

		palavras.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		});
		
		
	}

}













//class ComparadorPorTamanho implements Comparator <String>{
//
//	@Override
//	public int compare(String s1, String s2) {
//		if(s1.length() < s2.length())
//			return -1;			
//		if(s1.length() > s2.length()) 
//			return 1;			
//		return 0;
//	}
//}

//
//class ImprimeNaLinha implements Consumer<String>{
//	@Override
//	public void accept(String s) {
//		System.out.println(s);
//	}	
//}