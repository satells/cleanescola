package cleanescola.dominio.aluno;

public class Telefone {

	private String ddd;
	private String numero;

	public Telefone(String ddd, String numero) {
		if (ddd == null || !ddd.matches("\\d{2}")) {
			throw new IllegalArgumentException("DDD est� errado");
		}

		if (numero == null || !numero.matches("\\d{9}|\\d{8}")) {
			throw new IllegalArgumentException("N�mero do telefone est� errado.");
		}
		this.ddd = ddd;
		this.numero = numero;
	}

	public String getDdd() {
		return ddd;
	}

	public String getNumero() {
		return numero;
	}

}
