package cleanescola;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CPFTest {

	@Test
	void valida_se_numero_esta_errado() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF(null));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF(""));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF("00000000000"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF("11111111111"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF("22222222222"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF("33333333333"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF("44444444444"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF("55555555555"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF("66666666666"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF("77777777770"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF("88888888888"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF("99999999999"));
	}

	@Test
	void valida_se_numero_esta_correto() {

		Assertions.assertEquals(new CPF("08454871080").getNumero(), "08454871080");
		Assertions.assertEquals(new CPF("14806442003").getNumero(), "14806442003");

	}

}
