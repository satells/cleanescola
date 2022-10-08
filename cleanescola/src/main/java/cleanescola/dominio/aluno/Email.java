package cleanescola.dominio.aluno;

public class Email {

	// VALUE OBJECT
	public Email(String endereco) {

		if (endereco == null || !endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
			throw new IllegalArgumentException("Endereço de E-mail está errado.");
		}
		this.endereco = endereco;
	}

	private String endereco;

	public String getEndereco() {
		return endereco;
	}

}
