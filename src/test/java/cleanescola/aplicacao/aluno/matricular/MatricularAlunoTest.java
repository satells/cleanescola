package cleanescola.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import cleanescola.dominio.PublicadorDeEventos;
import cleanescola.dominio.aluno.Aluno;
import cleanescola.dominio.aluno.CPF;
import cleanescola.dominio.aluno.evento.ouvinte.EnviandoEmailAoAluno;
import cleanescola.dominio.aluno.evento.ouvinte.LogDeAlunoMatriculado;
import cleanescola.infra.aluno.RepositorioDeAlunosEmMemoria;

class MatricularAlunoTest {

	@Test
	void alunoDeveriaSerPersistido() {
		String nome = "Hroldo Raimundo";
		String cpf = "08454871080";
		String email = "email@email.com";

		RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
		PublicadorDeEventos publicador = new PublicadorDeEventos();
		publicador.adicionar(new LogDeAlunoMatriculado());
		publicador.adicionar(new EnviandoEmailAoAluno());

		MatricularAluno matricular = new MatricularAluno(repositorio, publicador);

		matricular.executa(new MatricularAlunoDTO(cpf, nome, email));

		Aluno alunoEncontrado = repositorio.buscarPorCPF(new CPF(cpf));

		assertEquals(alunoEncontrado.getCpf(), cpf);
		assertEquals(alunoEncontrado.getNome(), nome);
		assertEquals(alunoEncontrado.getEmail(), email);

	}
}