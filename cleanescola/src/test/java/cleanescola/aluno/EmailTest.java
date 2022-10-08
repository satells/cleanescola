package cleanescola.aluno;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import cleanescola.aluno.Email;

class EmailTest {

	@Test
	void testa_se_email_esta_invalido() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> new Email(null));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Email(""));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Email("email@email_.com"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Email("email@"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Email("@email.com"));

	}

	@Test
	void testa_se_esta_valido() {
		String endereco = "email@email.com.br";
		Email email = new Email(endereco);

		Assertions.assertEquals(email.getEndereco(), endereco);
	}

}
