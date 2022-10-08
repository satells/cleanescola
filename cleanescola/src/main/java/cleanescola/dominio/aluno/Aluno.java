package cleanescola.dominio.aluno;

import java.util.ArrayList;
import java.util.List;

//https://howtodoinjava.com/design-patterns/creational/builder-pattern-in-java/
public class Aluno {

	private CPF cpf;

	private String nome;

	private Email email;

	private List<Telefone> telefones = new ArrayList<Telefone>();

	private Aluno(AlunoBuilder builder) {

		this.cpf = builder.cpf;
		this.nome = builder.nome;
		this.email = builder.email;

	}

	public CPF getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public Email getEmail() {
		return email;
	}

	public void adicionarTelefone(String ddd, String numero) {
		this.telefones.add(new Telefone(ddd, numero));
	}

	public static class AlunoBuilder {
		private CPF cpf;

		private String nome;

		private Email email;

		public AlunoBuilder() {
		}

		public AlunoBuilder comCpf(CPF cpf) {
			this.cpf = cpf;
			return this;
		}

		public AlunoBuilder comNome(String nome) {
			this.nome = nome;
			return this;
		}

		public AlunoBuilder comEmail(Email email) {
			this.email = email;
			return this;
		}

		public Aluno build() {
			Aluno aluno = new Aluno(this);

			validateAluno(aluno);

			return aluno;
		}

		private void validateAluno(Aluno aluno) {
			if (aluno.getNome() == null) {
				throw new IllegalArgumentException("Nome é obrigatório.");
			} else if (aluno.getCpf() == null) {
				throw new IllegalArgumentException("CPF é obrigatório.");
			} else if (aluno.getEmail() == null) {
				throw new IllegalArgumentException("E-mail é obrigatório.");
			}

		}

	}

	public Telefone getTelefone(int index) {
		return this.telefones.get(index);
	}
}