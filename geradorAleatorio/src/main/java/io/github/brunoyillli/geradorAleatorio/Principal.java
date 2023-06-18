package io.github.brunoyillli.geradorAleatorio;

public class Principal {

	public static void main(String[] args) {
		MyRandomNumber randomNumber = new MyRandomNumber();
		try {
			int nextRandomNumber = randomNumber.nextRandomNumber(0, 10);
			System.out.println(nextRandomNumber);
		} catch (IntervaloInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
