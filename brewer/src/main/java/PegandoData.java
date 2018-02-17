import java.time.LocalDate;
import java.time.Month;

public class PegandoData {
		public static void main(String[] args) {
			LocalDate date = LocalDate.of(2017, Month.DECEMBER, 1);
			System.out.println(date.toEpochDay() * 24 * 60 * 60);
		}
}
