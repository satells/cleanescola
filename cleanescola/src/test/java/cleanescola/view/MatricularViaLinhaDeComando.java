package cleanescola.view;

import cleanescola.aplicacao.aluno.matricular.MatricularAluno;
import cleanescola.aplicacao.aluno.matricular.MatricularAlunoDTO;
import cleanescola.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularViaLinhaDeComando {

	public static void main(String[] args) {

		String nome = "Hroldo Raimundo";
		String cpf = "08454871080";
		String email = "email@email.com";

		MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunosEmMemoria());

		matricular.executar(new MatricularAlunoDTO(cpf, nome, email));

	}
}