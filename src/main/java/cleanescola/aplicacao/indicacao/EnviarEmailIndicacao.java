package cleanescola.aplicacao.indicacao;

import cleanescola.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {
	void enviarPara(Aluno indicado);

}
