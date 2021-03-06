package wdsr.exercise1;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import wdsr.exercise1.logic.Calculator;

public class CalculatorUtilSubtractionTest {
	private Calculator calculator;
	private CalculatorUtil calcUtil;

	@Before
	public void init() {
		calculator = Mockito.mock(Calculator.class);
		calcUtil = new CalculatorUtil(calculator);
	}

	@Test
	public void test3minus1() {
		// given
		doReturn(2).when(calculator).subtract(anyInt(), anyInt());

		// when
		String result = calcUtil.getSubstractionText(3, 1);

		// then
		assertThat("3 - 1 = 2", is(equalTo(result)));
		verify(calculator).subtract(anyInt(), anyInt());
	}
	@Test
	public void test10minus10() {
		// given
		doReturn(0).when(calculator).subtract(anyInt(), anyInt());

		// when
		String result = calcUtil.getSubstractionText(10, 10);

		// then
		assertThat("10 - 10 = 0", is(equalTo(result)));
		verify(calculator).subtract(anyInt(), anyInt());
	}

	@Test
	public void test10minus20() {
		// given
		doReturn(-10).when(calculator).subtract(anyInt(), anyInt());

		// when
		String result = calcUtil.getSubstractionText(10, 20);

		// then
		assertThat("10 - 20 = -10", is(equalTo(result)));
		verify(calculator).subtract(anyInt(), anyInt());
	}
}
