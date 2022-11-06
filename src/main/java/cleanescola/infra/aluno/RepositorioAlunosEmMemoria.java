package cleanescola.infra.aluno;

import java.util.List;

import cleanescola.dominio.aluno.Aluno;
import cleanescola.dominio.aluno.CPF;
import cleanescola.dominio.aluno.RepositorioDeAlunos;

public class RepositorioAlunosEmMemoria implements RepositorioDeAlunos {

	@Override
	public void matricular(Aluno aluno) {

	}

	@Override
	public Aluno buscarPorCPF(CPF cpf) {
		return null;
	}

	@Override
	public List<Aluno> listarTodosAlunosMatriculados() {
		return null;
	}

}
