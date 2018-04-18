import static org.junit.Assert.*;

import org.junit.Test;

import control.VectorCalculator;
import model.Vector;
import model.VectorOrientation;

public class VectorCalculatorTest {

	@Test
	public void vectorAddition() {
		VectorCalculator cal = new VectorCalculator();
		Vector a = new Vector("A", 2, 1, VectorOrientation.VERTICAL);
		Vector b = new Vector("B", 2, 1, VectorOrientation.VERTICAL);

		Vector expected = new Vector("A+B", 2, 1, VectorOrientation.VERTICAL);

		double[][] a_data = new double[2][1];
		double[][] b_data = new double[2][1];
		double[][] expectedData = new double[2][1];

		a_data[0][0] = 0;
		a_data[1][0] = 2;

		b_data[0][0] = -4;
		b_data[1][0] = 3;

		expectedData[0][0] = -4;
		expectedData[1][0] = 5;

		a.setCurrentVector(a_data);
		b.setCurrentVector(b_data);
		expected.setCurrentVector(expectedData);

		Vector resultMatrix = cal.addVectors(a, b);

		if (cal.areSameMatrices(expected, resultMatrix)) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

	@Test
	public void vectorSubtraction() {

		VectorCalculator cal = new VectorCalculator();
		Vector a = new Vector("A", 2, 1, VectorOrientation.VERTICAL);
		Vector b = new Vector("B", 2, 1, VectorOrientation.VERTICAL);

		Vector expected = new Vector("A-B", 2, 1, VectorOrientation.VERTICAL);

		double[][] a_data = new double[2][1];
		double[][] b_data = new double[2][1];
		double[][] expectedData = new double[2][1];

		a_data[0][0] = 0;
		a_data[1][0] = 2;

		b_data[0][0] = -4;
		b_data[1][0] = 3;

		expectedData[0][0] = -4;
		expectedData[1][0] = 5;

		a.setCurrentVector(a_data);
		b.setCurrentVector(b_data);
		expected.setCurrentVector(expectedData);

		Vector resultMatrix = cal.subtractVectors(a, b);
		resultMatrix.printVector();

		if (cal.areSameMatrices(expected, resultMatrix)) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

	@Test
	public void dotProduct1() {
		VectorCalculatorTest cal = new VectorCalculatorTest();
		// Vector a = new Vector("A", );
		// Vector b = new Vector();

		assertFalse(true);
	}

	@Test
	public void dotProduct2() {
		VectorCalculatorTest cal = new VectorCalculatorTest();
		assertFalse(true);
	}

	@Test
	public void dotProduct3() {
		VectorCalculatorTest cal = new VectorCalculatorTest();
		assertFalse(true);
	}

	@Test
	public void crossProduct() {
		VectorCalculatorTest cal = new VectorCalculatorTest();
		assertFalse(true);
	}

}
