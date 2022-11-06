package cleanescola.dominio.aluno.evento.ouvinte;

import cleanescola.dominio.Evento;
import cleanescola.dominio.Ouvinte;
import cleanescola.dominio.aluno.evento.disparador.AlunoMatriculado;

public class LogDeAlunoMatriculado extends Ouvinte {

	@Override
	protected void reageAo(Evento evento) {
		System.out.println("Aluno com CPF " + ((AlunoMatriculado) evento).getCpfAluno() + " foi matriculado em " + evento.momento());
	}

	@Override
	protected boolean deveProcessar(Evento evento) {
		return evento instanceof AlunoMatriculado;
	}
}
