package cleanescola.dominio.aluno;

public class CPF {
	private String numero;

	public CPF(String numero) {
		if (numero == null || !isValid(numero)) {
			throw new IllegalArgumentException("CPF errado.");
		}

		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public static boolean isValid(String numero) {

		if (!numero.matches("\\d{11}")) {
			return false;
		}
		if (numero.equals("00000000000") || numero.equals("11111111111") || numero.equals("22222222222") || numero.equals("33333333333") || numero.equals("44444444444") || numero.equals("55555555555") || numero.equals("66666666666")
				|| numero.equals("77777777777") || numero.equals("88888888888") || numero.equals("99999999999"))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		sm = 0;
		peso = 10;
		for (i = 0; i < 9; i++) {
			num = (int) (numero.charAt(i) - 48);
			sm = sm + (num * peso);
			peso = peso - 1;
		}

		r = 11 - (sm % 11);
		if ((r == 10) || (r == 11)) {
			dig10 = '0';
		} else {
			dig10 = (char) (r + 48);
		}
		sm = 0;
		peso = 11;
		for (i = 0; i < 10; i++) {
			num = (int) (numero.charAt(i) - 48);
			sm = sm + (num * peso);
			peso = peso - 1;
		}

		r = 11 - (sm % 11);
		if ((r == 10) || (r == 11)) {
			dig11 = '0';
		} else {
			dig11 = (char) (r + 48);
		}

		if ((dig10 == numero.charAt(9)) && (dig11 == numero.charAt(10))) {
			return (true);
		} else {
			return (false);
		}

	}

	public static String imprimeCPF(String CPF) {
		return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
	}

}
