package cleanescola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AlunoTest {

	@Test
	void testar_criacao_aluno() {

		CPF cpf = new CPF("08454871080");
		Email email = new Email("email@email.com");
		String nome = "Ricardo Mendes";
		Aluno aluno = new Aluno.AlunoBuilder().comCpf(cpf).comEmail(email).comNome(nome).build();

		String ddd = "12";
		String numero = "123456789";
		aluno.adicionarTelefone(ddd, numero);

		assertEquals(aluno.getNome(), nome);
		assertEquals(aluno.getCpf(), cpf.getNumero());
		assertEquals(aluno.getEmail(), email.getEndereco());

		Telefone telefone = aluno.getTelefone(0);
		assertEquals(telefone.getDdd(), ddd);
		assertEquals(telefone.getNumero(), numero);

	}

	@Test
	void testar_criacao_de_aluno_com_erro() {
		CPF cpf = new CPF("08454871080");
		Email email = new Email("email@email.com");
		String nome = "Ricardo Mendes";

		Assertions.assertThrows(IllegalArgumentException.class, () -> new Aluno.AlunoBuilder().comCpf(null).comEmail(email).comNome(nome).build());
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Aluno.AlunoBuilder().comCpf(cpf).comEmail(null).comNome(nome).build());
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Aluno.AlunoBuilder().comCpf(cpf).comEmail(email).comNome(null).build());

	}

}
