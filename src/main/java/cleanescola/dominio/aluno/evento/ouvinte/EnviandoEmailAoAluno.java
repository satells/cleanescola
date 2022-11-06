package cleanescola.dominio.aluno.evento.ouvinte;

import cleanescola.dominio.Evento;
import cleanescola.dominio.Ouvinte;
import cleanescola.dominio.aluno.evento.disparador.AlunoMatriculado;

public class EnviandoEmailAoAluno extends Ouvinte {

	@Override
	protected void reageAo(Evento evento) {
		System.out.println("Enviando e-mail a com CPF " + ((AlunoMatriculado) evento).getCpfAluno() + " foi matriculado em " + evento.momento());
	}

	@Override
	protected boolean deveProcessar(Evento evento) {
		return evento instanceof AlunoMatriculado;
	}

}
