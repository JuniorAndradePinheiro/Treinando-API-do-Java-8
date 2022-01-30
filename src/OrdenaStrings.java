import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<String>();
		palavras.add("Alura");
		palavras.add("Casa do C�digo");
		palavras.add("Caelum");

//		Comparator<String> comparador = new ComparadorPorTamanho();
//		Collections.sort(palavras,comparador);

		// Dando um new na interface Comparator e j� implemntado o m�todo e com isso n�o
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

		// Usando LAMBDA (INTERFACES QUE S� TEM UM M�TODO S�O CHAMADAS DE INTERFACES FUNCIONAIS)
//		palavras.sort((String s1, String s2 )-> {
//				if(s1.length() < s2.length())
//					return -1;			
//				if(s1.length() > s2.length()) 
//					return 1;			
//				return 0;
//		});

		//esse c�digo faz exatamente a mesma coisa que o c�digo acima. Ao inv�s de usar o m�todo da Comparator que tive que implementar eu estou usando um m�tod de compara��o que j� existe da classe Integer
		palavras.sort((String s1, String s2) -> Integer.compare(s1.length(), s2.length()));
		
		// Esse c�digo � equivalente o de cima, e ao inv�s de usar o compare de Integer estou usando um m�todo da interface Comparator
		// Para cada Stirng "s" dentro de "palavras" pega o tamanho e passa como parametro para o "comparing" que por sua vez ser� usado pelo "sort" para ordenar as strings
		palavras.sort(Comparator.comparing(s -> s.length()));
		
		// Aqui estou usando o m�todo reference
		palavras.sort(Comparator.comparing(String::length));
				
		
		//Aqui estou dividindo a linha de cima para mostrar oque est� sendo feito de forma mais explicita
		Comparator<String> comparador =  Comparator.comparing(s -> s.length());
		palavras.sort(comparador);

		System.out.println(palavras);

//		Consumer<String> consumidor = new ImprimeNaLinha();
//		palavras.forEach(consumidor);

		// O c�digo abaixo est� utilizando algo chamado de classe an�nima, que nada mais
		// � do que dar um new direto na interface
		// normalmente n�o � poss�vel dar um new em uma interface pois faltar�
		// argumentos, por conta disso j� estou implementando o m�todo que seria
		// implmentado na classe ImprimeNaLinha
		// dessa forma n�o preciso criar uma classe pequena e inst�ncia-la

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