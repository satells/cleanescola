package cleanescola.aplicacao.aluno.matricular;

import cleanescola.dominio.PublicadorDeEventos;
import cleanescola.dominio.aluno.Aluno;
import cleanescola.dominio.aluno.CPF;
import cleanescola.dominio.aluno.RepositorioDeAlunos;
import cleanescola.dominio.aluno.evento.disparador.AlunoMatriculado;

public class MatricularAluno {

	private final RepositorioDeAlunos repositorio;

	private final PublicadorDeEventos publicador;

	public MatricularAluno(RepositorioDeAlunos repositorio, PublicadorDeEventos publicador) {
		this.repositorio = repositorio;
		this.publicador = publicador;
	}

	public void executa(MatricularAlunoDTO dados) {

		Aluno aluno = dados.criarAluno(dados);

		repositorio.matricular(aluno);

		AlunoMatriculado evento = new AlunoMatriculado(new CPF(aluno.getCpf()));
		publicador.publicar(evento);
	}
}
