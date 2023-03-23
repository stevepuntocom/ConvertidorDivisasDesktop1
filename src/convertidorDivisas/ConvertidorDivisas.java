package convertidorDivisas;

public class ConvertidorDivisas {
	
	public ConvertidorDivisas() {
		double tasaDopCad = 0.025218f;
		double tasaDopUsd = 0.018312f;
		double tasaDopHtg = 2.819773f;
		double tasaCadDop = 0.025218f;
		double tasaCadUsd = 0.726137f;
		double tasaCadHtg = 111.816056f;
		double tasaUsdCad = 1.377150593f;
		double tasaUsdDop = 54f;
		double tasaUsdHtg = 153.987479f;
		double tasaHtgCad = 0.008943259f;
		double tasaHtgUsd = 0.006494034f;
		double tasaHtgDop = 0.354638476f;
		
		
	}

	public String procesar(double cantidad1, String divisa1, double cantidad2, String divisa2) {
		
//		Peso dominicano - DOP
//		Gourde haitiano - HTG
//		Dolar canadiense - CAD
//		Dolar americano - USD
		

		
		if (divisa1 == divisa2) {
			return String.valueOf(cantidad1);
		}
		else {
			return "0.00";
		}
		
	}
}
