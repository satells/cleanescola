package cleanescola.infra.aluno;

import java.util.ArrayList;
import java.util.List;

import cleanescola.dominio.aluno.Aluno;
import cleanescola.dominio.aluno.AlunoNaoEncontrado;
import cleanescola.dominio.aluno.CPF;
import cleanescola.dominio.aluno.RepositorioDeAlunos;

public class RepositorioDeAlunosEmMemoria implements RepositorioDeAlunos {

	private List<Aluno> matriculados = new ArrayList<>();

	@Override
	public void matricular(Aluno aluno) {
		this.matriculados.add(aluno);
	}

	@Override
	public Aluno buscarPorCPF(CPF cpf) {
		return this.matriculados.stream().filter(a -> a.getCpf().equals(cpf.getNumero())).findFirst().orElseThrow(() -> new AlunoNaoEncontrado(cpf));
	}

	@Override
	public List<Aluno> listarTodosAlunosMatriculados() {
		return this.matriculados;
	}

}
