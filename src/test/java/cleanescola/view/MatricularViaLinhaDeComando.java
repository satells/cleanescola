package cleanescola.view;

import cleanescola.aplicacao.aluno.matricular.MatricularAluno;
import cleanescola.aplicacao.aluno.matricular.MatricularAlunoDTO;
import cleanescola.dominio.PublicadorDeEventos;
import cleanescola.dominio.aluno.evento.ouvinte.LogDeAlunoMatriculado;
import cleanescola.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularViaLinhaDeComando {

	public static void main(String[] args) {

		String nome = "Hroldo Raimundo";
		String cpf = "08454871080";
		String email = "email@email.com";

		PublicadorDeEventos publicador = new PublicadorDeEventos();
		publicador.adicionar(new LogDeAlunoMatriculado());

		MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunosEmMemoria(), publicador);

		matricular.executa(new MatricularAlunoDTO(cpf, nome, email));

	}
}