import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {

	public static void main(String[] args) {
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		LocalDate olimpiadasDoRio = LocalDate.of(2026, Month.JUNE, 5);
		int anos = olimpiadasDoRio.getYear( )- hoje.getYear();
		System.out.println(anos);
		
		
		//Classe que permite trabalhar com periodos por meio de métodos estáticos
		Period periodo = Period.between(hoje, olimpiadasDoRio); // retorna o perído entre hoje e olimpiadasDoRio 
		System.out.println(periodo.getYears() + " ano(s)");
		System.out.println(periodo.getMonths() + " mes(es)");
		System.out.println(periodo.getDays() + " dia(s)");
		
		//acrecentando mais 4 anos na data
		//é necessário fazer um novo localdate porque os objetos são imultatáveis nessa api, por conta disso se eu colocasse olimpiadasDoRio.plusYears() iria restornar o valor que já está alocado no objeto
		LocalDate proximaOlimpiadasDoRio = olimpiadasDoRio.plusYears(4);
		System.out.println(proximaOlimpiadasDoRio);
		
		//aqui estou defindo o formato que eu quero por meio da classe DateTimeFormatter
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		
		//Aqui estou unsadno o formatador como parametro de formatação da data
		System.out.println(olimpiadasDoRio.format(formatador));
		
		//para usar as datas com minutos, segundo e etc usar a classe LocalDateTime
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter farmatador2 = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
		System.out.println(agora.format(farmatador2));
		
	}

}
