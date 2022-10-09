package cleanescola.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import cleanescola.dominio.aluno.Aluno;
import cleanescola.dominio.aluno.CPF;
import cleanescola.infra.aluno.RepositorioDeAlunosEmMemoria;

class MatricularAlunoTest {

	@Test
	void alunoDeveriaSerPersistido() {
		String nome = "Hroldo Raimundo";
		String cpf = "08454871080";
		String email = "email@email.com";

		RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
		MatricularAluno matricular = new MatricularAluno(repositorio);

		matricular.executar(new MatricularAlunoDTO(cpf, nome, email));

		Aluno alunoEncontrado = repositorio.buscarPorCPF(new CPF(cpf));

		assertEquals(alunoEncontrado.getCpf(), cpf);
		assertEquals(alunoEncontrado.getNome(), nome);
		assertEquals(alunoEncontrado.getEmail(), email);

	}
}