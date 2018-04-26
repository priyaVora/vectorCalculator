package control;

import model.Vector;
import model.VectorOrientation;

public class VectorCalculator {

	private String[][] showWorkAddition;
	private String[][] showWorkSubtraction;

	private String[][] answerAddition;
	private String[][] answerSubtraction;

	private String originalWorkMagnitude;
	private String squaredWorkMagnitude;
	private String currentSquareRootValue = "";

	private String dotProductShowWork;
	private String dotProductAnswer;
	private String dotProduct;

	public Vector addVectors(Vector firstVector, Vector secondVector) {
		if (areSameDimensions(firstVector, secondVector)) {

			double[][] newData = new double[firstVector.getRow()][firstVector.getColumn()];
			String[][] showWork = new String[firstVector.getRow()][firstVector.getColumn()];
			String[][] answer = new String[firstVector.getRow()][firstVector.getColumn()];

			Vector addedVector = new Vector("" + firstVector.getName() + "+" + secondVector.getName(),
					firstVector.getRow(), firstVector.getColumn(), firstVector.getVectorOrientation());
			for (int row = 0; row < firstVector.getCurrentVector().length; row++) {
				for (int col = 0; col < firstVector.getCurrentVector()[row].length; col++) {
					showWork[row][col] = "(" + firstVector.getCurrentVector()[row][col] + ")" + " + " + "("
							+ secondVector.getCurrentVector()[row][col] + ")";
					double add = firstVector.getCurrentVector()[row][col] + secondVector.getCurrentVector()[row][col];
					answer[row][col] = "(" + add + ")";
					newData[row][col] = add;
				}
			}

			showWorkAddition = showWork;
			answerAddition = answer;
			addedVector.setCurrentVector(newData);
			return addedVector;
		} else {
			System.out.println("Dimensions are not same...");
		}
		return null;
	}

	public Vector subtractVectors(Vector firstVector, Vector secondVector) {
		if (areSameDimensions(firstVector, secondVector)) {

			double[][] newData = new double[firstVector.getRow()][firstVector.getColumn()];
			String[][] showWork = new String[firstVector.getRow()][firstVector.getColumn()];
			String[][] answer = new String[firstVector.getRow()][firstVector.getColumn()];

			Vector subtractVector = new Vector("" + firstVector.getName() + "-" + secondVector.getName(),
					firstVector.getRow(), firstVector.getColumn(), firstVector.getVectorOrientation());
			for (int row = 0; row < firstVector.getCurrentVector().length; row++) {
				for (int col = 0; col < firstVector.getCurrentVector()[row].length; col++) {
					showWork[row][col] = "(" + firstVector.getCurrentVector()[row][col] + ")" + " + " + "("
							+ secondVector.getCurrentVector()[row][col] + ")";
					double sub = firstVector.getCurrentVector()[row][col] - secondVector.getCurrentVector()[row][col];
					answer[row][col] = "(" + sub + ")";
					newData[row][col] = sub;

				}
			}

			showWorkSubtraction = showWork;
			answerSubtraction = answer;
			subtractVector.setCurrentVector(newData);
			return subtractVector;
		} else {
			System.out.println("Dimensions are not same...");
		}
		return null;
	}

	public double dotProduct(double[] a, double[] b) {
		double sum = 0;
		dotProductShowWork = "";
		dotProductAnswer = "";
		dotProduct = "";
		for (int i = 0; i < a.length; i++) {
			System.out.print("(" + a[i] + ")" + "(" + b[i] + ")");
			dotProductShowWork += "(" + a[i] + ")" + "(" + b[i] + ")";
			sum += a[i] * b[i];
			dotProductAnswer += sum;
			if (i != a.length - 1) {
				System.out.print("+");
				dotProductShowWork += "+";
				dotProductAnswer += "+";
			}

		}
		System.out.println(" ");
		dotProduct += "\n= " + sum;
		return sum;

	}

	public double magnitude(Vector currentVector) {
		double valueUnderSquareRoot = 0;
		String originalValue = "-\\|";
		String squaredValue = "-\\|";

		for (int i = 0; i < currentVector.getCurrentVector().length; i++) {
			for (int j = 0; j < currentVector.getCurrentVector()[i].length; j++) {
				double squared = currentVector.getCurrentVector()[i][j] * currentVector.getCurrentVector()[i][j];
				originalValue += "(" + currentVector.getCurrentVector()[i][j] + ")" + "^2";

				originalValue += "+";

				squaredValue += "(" + squared + ")";
				squaredValue += "+";

				valueUnderSquareRoot += squared;
			}
		}

		originalValue = originalValue.substring(0, originalValue.length() - 1);
		squaredValue = squaredValue.substring(0, squaredValue.length() - 1);
		setOriginalWorkMagnitude(originalValue);
		setSquaredWorkMagnitude(squaredValue);

		System.out.println("Final Original Value " + this.getOriginalWorkMagnitude());
		System.out.println("Final Squared Value: " + this.getSquaredWorkMagnitude());

		System.out.println("Value under root: -\\|" + valueUnderSquareRoot);
		System.out.println(Math.sqrt(valueUnderSquareRoot));
		setCurrentSquareRootValue("-\\|" + valueUnderSquareRoot);
		return Math.sqrt(valueUnderSquareRoot);
	}

	public double[] crossProduct() {
		return null;

	}

	private void decomposeVectorToV1(Vector v, Vector w) {
		Vector v1;
		int sizeA = v.getCurrentVector().length * v.getCurrentVector()[0].length;
		int sizeB = w.getCurrentVector().length * w.getCurrentVector()[0].length;
		double V_W_DotProduct = dotProduct(grabDataArray(sizeA, v.getCurrentVector()),
				grabDataArray(sizeB, w.getCurrentVector()));
		double W_W_DotProduct = dotProduct(grabDataArray(sizeB, w.getCurrentVector()),
				grabDataArray(sizeB, w.getCurrentVector()));

	}

	private void decomposeVectorToV2(Vector currenVector) {

	}

	private boolean checkVectorDecompose() {
		return false;
	}

	public double[] grabDataArray(int sizeA, double[][] a_data) {
		int count = 0;
		double[] dataA = new double[sizeA];
		for (int i = 0; i < a_data.length; i++) {
			for (int j = 0; j < a_data[i].length; j++) {
				dataA[count] = a_data[i][j];
				count++;
			}
		}
		return dataA;
	}

	public Vector unitVector(Vector currentVector) {
		double magnitudeOfVector = magnitude(currentVector);
		System.out.println("Magntitude: " + magnitudeOfVector);
		double oneDivideByVector = 1 / magnitudeOfVector;
		System.out.println("One divide by magnitude: " + oneDivideByVector);

		Vector newVector = multiplyValueToVector(oneDivideByVector, currentVector);

		return newVector;
	}

	public Vector multiplyValueToVector(double coefficient, Vector currentVector) {
		System.out.println("Value: " + coefficient);
		Vector temp = new Vector();
		double[][] updatedData = new double[currentVector
				.getCurrentVector().length][currentVector.getCurrentVector()[0].length];
		for (int i = 0; i < currentVector.getCurrentVector().length; i++) {
			for (int j = 0; j < currentVector.getCurrentVector()[i].length; j++) {
				double product = coefficient * currentVector.getCurrentVector()[i][j];
				updatedData[i][j] = product;
			}
		}

		temp.setCurrentVector(updatedData);
		return temp;
	}

	public boolean areSameMatrices(Vector firstVector, Vector secondVector) {
		if (firstVector == null || secondVector == null) {
			return false;
		}
		for (int row = 0; row < firstVector.getCurrentVector().length; row++) {
			for (int col = 0; col < firstVector.getCurrentVector()[row].length; col++) {
				if (firstVector.getCurrentVector()[row][col] == secondVector.getCurrentVector()[row][col]) {

				} else {
					return false;
				}
			}
		}
		return true;
	}

	public boolean areSameDimensions(Vector firstVector, Vector secondVector) {
		int row1 = firstVector.getRow();
		int column1 = firstVector.getColumn();

		int row2 = secondVector.getRow();
		int column2 = secondVector.getColumn();

		if (row1 == row2 && column1 == column2) {
			return true;
		}

		return false;
	}

	public String getDotProductShowWork() {
		return dotProductShowWork;
	}

	public void setDotProductShowWork(String dotProductShowWork) {
		this.dotProductShowWork = dotProductShowWork;
	}

	public String getDotProductAnswer() {
		return dotProductAnswer;
	}

	public void setDotProductAnswer(String dotProductAnswer) {
		this.dotProductAnswer = dotProductAnswer;
	}

	public String getDotProduct() {
		return dotProduct;
	}

	public void setDotProduct(String dotProduct) {
		this.dotProduct = dotProduct;
	}

	public String getOriginalWorkMagnitude() {
		return originalWorkMagnitude;
	}

	public void setOriginalWorkMagnitude(String originalWorkMagnitude) {
		this.originalWorkMagnitude = originalWorkMagnitude;
	}

	public String getSquaredWorkMagnitude() {
		return squaredWorkMagnitude;
	}

	public void setSquaredWorkMagnitude(String squaredWorkMagnitude) {
		this.squaredWorkMagnitude = squaredWorkMagnitude;
	}

	public String getCurrentSquareRootValue() {
		return currentSquareRootValue;
	}

	public void setCurrentSquareRootValue(String currentSquareRootValue) {
		this.currentSquareRootValue = currentSquareRootValue;
	}

}
