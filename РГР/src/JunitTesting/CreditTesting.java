package JunitTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CreditTesting {

	@Test
	void test() {
		Credit_calc test = new Credit_calc();
		double output=test.result(10000, 12, 20);
		assertEquals(11116.16, output);
	}

}
