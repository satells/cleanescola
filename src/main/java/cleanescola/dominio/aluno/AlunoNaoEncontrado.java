package cleanescola.dominio.aluno;

public class AlunoNaoEncontrado extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AlunoNaoEncontrado(String cpf) {
		super("Erro ao cadastrar Aluno " + cpf);
	}

	public AlunoNaoEncontrado(CPF cpf) {
		super("Erro ao cadastrar Aluno " + cpf);
	}

}
