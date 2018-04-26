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
	public void unitVectorTest() {
		VectorCalculator cal = new VectorCalculator();
		Vector a = new Vector("A", 2, 1, VectorOrientation.VERTICAL);
		Vector expected = new Vector("A", 2, 1, VectorOrientation.VERTICAL);

		double[][] a_data = new double[2][1];
		double[][] expectedData = new double[2][1];

		a_data[0][0] = 4;
		a_data[1][0] = -6;

		expectedData[0][0] = 0.5547001962252291;
		expectedData[1][0] = -0.8320502943378437;

		a.setCurrentVector(a_data);
		expected.setCurrentVector(expectedData);

		int sizeA = a_data.length * a_data[0].length;

		double[] dataA = new double[sizeA];

		int count = 0;
		for (int i = 0; i < a_data.length; i++) {
			for (int j = 0; j < a_data[i].length; j++) {
				dataA[count] = a_data[i][j];
				count++;
			}
		}

		Vector resultDotProduct = a;

		resultDotProduct.setCurrentVector(cal.unitVector(a).getCurrentVector());

		resultDotProduct.printVector();
		if (cal.areSameMatrices(resultDotProduct, expected)) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

	@Test
	public void unitVectorTest2() {
		VectorCalculator cal = new VectorCalculator();
		Vector a = new Vector("A", 2, 1, VectorOrientation.VERTICAL);
		Vector expected = new Vector("A", 2, 1, VectorOrientation.VERTICAL);

		double[][] a_data = new double[2][1];
		double[][] expectedData = new double[2][1];

		a_data[0][0] = 0;
		a_data[1][0] = -3;

		expectedData[0][0] = 0;
		expectedData[1][0] = -1;

		a.setCurrentVector(a_data);
		expected.setCurrentVector(expectedData);

		int sizeA = a_data.length * a_data[0].length;

		double[] dataA = new double[sizeA];

		int count = 0;
		for (int i = 0; i < a_data.length; i++) {
			for (int j = 0; j < a_data[i].length; j++) {
				dataA[count] = a_data[i][j];
				count++;
			}
		}

		Vector resultDotProduct = a;

		resultDotProduct.setCurrentVector(cal.unitVector(a).getCurrentVector());

		resultDotProduct.printVector();
		if (cal.areSameMatrices(resultDotProduct, expected)) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

	@Test
	public void vectorMagnitude() {
		VectorCalculator cal = new VectorCalculator();
		Vector a = new Vector("A", 3, 1, VectorOrientation.VERTICAL);

		double[][] a_data = new double[3][1];
		double[][] b_data = new double[3][1];
		double expectedDotProduct = 8.558621384311845;

		a_data[0][0] = 8;
		a_data[1][0] = -3;
		a_data[2][0] = 0.5;

		a.setCurrentVector(a_data);

		int sizeA = a_data.length * a_data[0].length;

		double[] dataA = new double[sizeA];

		int count = 0;
		for (int i = 0; i < a_data.length; i++) {
			for (int j = 0; j < a_data[i].length; j++) {
				dataA[count] = a_data[i][j];
				count++;
			}
		}

		double resultDotProduct = cal.magnitude(a);

		if (expectedDotProduct == resultDotProduct) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}

	}

	public void vectorMagnitude2() {
		VectorCalculator cal = new VectorCalculator();
		Vector a = new Vector("A", 2, 1, VectorOrientation.VERTICAL);

		double[][] a_data = new double[2][1];
		double[][] b_data = new double[2][1];
		double expectedDotProduct = 3.1622776601683795;

		a_data[0][0] = 3;
		a_data[1][0] = 1;

		a.setCurrentVector(a_data);

		int sizeA = a_data.length * a_data[0].length;

		double[] dataA = new double[sizeA];

		int count = 0;
		for (int i = 0; i < a_data.length; i++) {
			for (int j = 0; j < a_data[i].length; j++) {
				dataA[count] = a_data[i][j];
				count++;
			}
		}

		double resultDotProduct = cal.magnitude(a);

		if (expectedDotProduct == resultDotProduct) {
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

		expectedData[0][0] = 4;
		expectedData[1][0] = -1;

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
		VectorCalculator cal = new VectorCalculator();
		Vector a = new Vector("A", 2, 1, VectorOrientation.VERTICAL);
		Vector b = new Vector("B", 2, 1, VectorOrientation.VERTICAL);

		double[][] a_data = new double[2][1];
		double[][] b_data = new double[2][1];
		double expectedDotProduct = 20.0;

		a_data[0][0] = 3;
		a_data[1][0] = 1;

		b_data[0][0] = 9;
		b_data[1][0] = -7;

		a.setCurrentVector(a_data);
		b.setCurrentVector(b_data);

		int sizeA = a_data.length * a_data[0].length;
		int sizeB = a_data.length * b_data[0].length;

		double[] dataA = new double[sizeA];
		double[] dataB = new double[sizeB];

		dataA = cal.grabDataArray(sizeA, a_data);
		dataB = cal.grabDataArray(sizeB, b_data);
		double resultDotProduct = cal.dotProduct(dataA, dataB);

		System.out.println("///////////////////////////////////////////");
		String showWork = cal.getDotProductShowWork();
		System.out.println("Show Work: " + showWork);
		System.out.println("Show Work 2: " + cal.getDotProductAnswer());
		if (resultDotProduct == expectedDotProduct) {
			assertTrue(true);
			System.out.println("Expected: " + expectedDotProduct);
			System.out.println("Result: " + resultDotProduct);
		} else {
			assertTrue(false);
		}

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