package control;

import model.Vector;
import model.VectorOrientation;

public class VectorCalculator {

	private String[][] showWorkAddition;
	private String[][] showWorkSubtraction;

	private String[][] answerAddition;
	private String[][] answerSubtraction;

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
		for (int i = 0; i < a.length; i++) {
			sum += a[i] * b[i];
		}
		return sum;

	}

	public double magnitude(Vector currentVector) {
		double valueUnderSquareRoot = 0;

		for (int i = 0; i < currentVector.getCurrentVector().length; i++) {
			for (int j = 0; j < currentVector.getCurrentVector()[i].length; j++) {
				double squaredValue = currentVector.getCurrentVector()[i][j] * currentVector.getCurrentVector()[i][j];
				// System.out.println("Original Value: " +
				// currentVector.getCurrentVector()[i][j]);
				// System.out.println("Squared Value: " + squaredValue);
				valueUnderSquareRoot += squaredValue;
			}
		}
		// System.out.println("Value under root: -\\|" + valueUnderSquareRoot);
		// System.out.println(Math.sqrt(valueUnderSquareRoot));
		return Math.sqrt(valueUnderSquareRoot);
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

}
