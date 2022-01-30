import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class ExerciciosComDatas {

	public static void main(String[] args) {
		 LocalDate dataAtual = LocalDate.now();
		 System.out.println(dataAtual);
		 
		 //LocalDate diaMesAnoFuturo = LocalDate.of(2099, 01, 25);
		 LocalDate diaMesAnoFuturo = LocalDate.of(2099, Month.JANUARY, 25);
		 DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 System.out.println(diaMesAnoFuturo.format(formatador));
		 Period periodo = Period.between(dataAtual, diaMesAnoFuturo);
		 System.out.println(periodo.getYears());
		 
	}

}
