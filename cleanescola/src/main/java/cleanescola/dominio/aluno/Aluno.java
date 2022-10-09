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

	public String getCpf() {
		return cpf.getNumero();
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email.getEndereco();
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

		public AlunoBuilder comCpf(String cpf) {
			this.cpf = new CPF(cpf);
			return this;
		}

		public AlunoBuilder comNome(String nome) {
			this.nome = nome;
			return this;
		}

		public AlunoBuilder comEmail(String email) {
			this.email = new Email(email);
			return this;
		}

		public Aluno build() {
			Aluno aluno = new Aluno(this);

			validateAluno(aluno);

			return aluno;
		}

		private void validateAluno(Aluno aluno) {
			if (aluno.getNome() == null) {
				throw new IllegalArgumentException("Nome � obrigat�rio.");
			} else if (aluno.getCpf() == null) {
				throw new IllegalArgumentException("CPF � obrigat�rio.");
			} else if (aluno.getEmail() == null) {
				throw new IllegalArgumentException("E-mail � obrigat�rio.");
			}

		}

	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public Telefone getTelefone(int index) {
		return this.telefones.get(index);
	}
}