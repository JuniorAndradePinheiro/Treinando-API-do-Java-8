import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Exercicio1 {
	
	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		
		Comparator<String> comparador = new OrdenaPorTamanho();
		palavras.sort(comparador);
		
		//Aqui estou usando uma action
		palavras.forEach(p -> {
			System.out.println(p);
		});
		
		//Aqui estou usando o Consumer(interface) que implementei na classe ImprimeNaLinha
		Consumer<String> consumidor = new ImprimeNaLinha();
		palavras.forEach(consumidor);
	}

}


class ImprimeNaLinha implements Consumer<String>{

    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}


class OrdenaPorTamanho implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		if(s1.length() < s2.length())
			return -1;
		if(s1.length() >  s2.length())
			return 1;
		return 0;
	}
	
}