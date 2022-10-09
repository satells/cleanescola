package cleanescola.aplicacao.aluno.matricular;

import cleanescola.dominio.aluno.Aluno;
import cleanescola.dominio.aluno.RepositorioDeAlunos;

public class MatricularAluno {

	private final RepositorioDeAlunos repositorio;

	public MatricularAluno(RepositorioDeAlunos repositorio) {
		this.repositorio = repositorio;
	}

	public void executar(MatricularAlunoDTO dados) {

		Aluno aluno = dados.criarAluno(dados);

		repositorio.matricular(aluno);
	}
}
