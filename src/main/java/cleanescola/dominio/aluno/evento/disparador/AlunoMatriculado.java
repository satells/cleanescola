package cleanescola.dominio.aluno.evento.disparador;

import java.time.LocalDateTime;

import cleanescola.dominio.Evento;
import cleanescola.dominio.aluno.CPF;

public class AlunoMatriculado implements Evento {

	private final CPF cpfAluno;

	public AlunoMatriculado(CPF cpfAluno) {
		this.cpfAluno = cpfAluno;
	}

	@Override
	public LocalDateTime momento() {
		return LocalDateTime.now();
	}

	public CPF getCpfAluno() {
		return cpfAluno;
	}
}
