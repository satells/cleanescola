package cleanescola.aplicacao.aluno.matricular;

import cleanescola.dominio.aluno.Aluno;

public class MatricularAlunoDTO {
	private String cpf;

	private String nome;

	private String email;

	public MatricularAlunoDTO(String cpf, String nome, String email) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public Aluno criarAluno(MatricularAlunoDTO dados) {
		return new Aluno.AlunoBuilder().comCpf(dados.getCpf()).comEmail(dados.getEmail()).comNome(dados.getNome()).build();
	}

}
