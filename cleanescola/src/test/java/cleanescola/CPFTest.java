package cleanescola;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CPFTest {

	@Test
	void valida_se_numero_esta_errado() {
		assertThrows(IllegalArgumentException.class, () -> new CPF(null));
		assertThrows(IllegalArgumentException.class, () -> new CPF(""));
		assertThrows(IllegalArgumentException.class, () -> new CPF("00000000000"));
		assertThrows(IllegalArgumentException.class, () -> new CPF("11111111111"));
		assertThrows(IllegalArgumentException.class, () -> new CPF("22222222222"));
		assertThrows(IllegalArgumentException.class, () -> new CPF("33333333333"));
		assertThrows(IllegalArgumentException.class, () -> new CPF("44444444444"));
		assertThrows(IllegalArgumentException.class, () -> new CPF("55555555555"));
		assertThrows(IllegalArgumentException.class, () -> new CPF("66666666666"));
		assertThrows(IllegalArgumentException.class, () -> new CPF("77777777770"));
		assertThrows(IllegalArgumentException.class, () -> new CPF("88888888888"));
		assertThrows(IllegalArgumentException.class, () -> new CPF("99999999999"));
	}

	@Test
	void valida_se_numero_esta_correto() {

		assertEquals(new CPF("08454871080").getNumero(), "08454871080");
		assertEquals(new CPF("14806442003").getNumero(), "14806442003");

	}

}
