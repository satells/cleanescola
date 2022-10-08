package cleanescola;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TelefoneTest {

	@Test
	void testa_se_numero_esta_errado() {

		assertThrows(IllegalArgumentException.class, () -> new Telefone(null, null));
		assertThrows(IllegalArgumentException.class, () -> new Telefone("1", null));

		assertThrows(IllegalArgumentException.class, () -> new Telefone("11", null));
		assertThrows(IllegalArgumentException.class, () -> new Telefone("11", "1"));

	}

	@Test
	void test_numero_correto() {
		String ddd_1 = "11";
		String numero_1 = "123456789";
		Telefone telefone1 = new Telefone(ddd_1, numero_1);

		Assertions.assertEquals(telefone1.getDdd(), ddd_1);
		Assertions.assertEquals(telefone1.getNumero(), numero_1);

	}

}
