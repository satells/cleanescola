package cleanescola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlunoTest {
	private Aluno aluno;
	private CPF cpf = new CPF("08454871080");
	private Email email = new Email("email@email.com");
	private String nome = "Ricardo Mendes";

	@BeforeEach
	void beforeEach() {
		aluno = new Aluno.AlunoBuilder().comCpf(cpf.getNumero()).comEmail(email.getEndereco()).comNome(nome).build();

	}

	@Test
	void testar_criacao_aluno() {

		String ddd1 = "13";
		String numero1 = "33554455";

		String ddd2 = "14";
		String numero2 = "11223344";

		assertEquals(aluno.getNome(), nome);
		assertEquals(aluno.getCpf(), cpf.getNumero());
		assertEquals(aluno.getEmail(), email.getEndereco());

		assertEquals(0, aluno.getTelefones().size());

		aluno.adicionarTelefone(ddd1, numero1);
		Telefone telefone = aluno.getTelefone(0);
		assertEquals(telefone.getDdd(), ddd1);
		assertEquals(telefone.getNumero(), numero1);

		assertEquals(1, aluno.getTelefones().size());
		aluno.adicionarTelefone(ddd2, numero2);

		assertEquals(telefone.getNumero(), numero1);
		assertEquals(2, aluno.getTelefones().size());

		assertThrows(IllegalArgumentException.class, () -> aluno.adicionarTelefone("12", "14546"));

	}

	@Test
	void testar_criacao_de_aluno_com_erro() {

		assertThrows(IllegalArgumentException.class, () -> new Aluno.AlunoBuilder().comCpf(null).comEmail(null).comNome(null).build());
		assertThrows(IllegalArgumentException.class, () -> new Aluno.AlunoBuilder().comCpf(null).comEmail(email.getEndereco()).comNome(nome).build());
		assertThrows(IllegalArgumentException.class, () -> new Aluno.AlunoBuilder().comCpf(cpf.getNumero()).comEmail(null).comNome(nome).build());
		assertThrows(IllegalArgumentException.class, () -> new Aluno.AlunoBuilder().comCpf(cpf.getNumero()).comEmail(email.getEndereco()).comNome(null).build());
	}

}
