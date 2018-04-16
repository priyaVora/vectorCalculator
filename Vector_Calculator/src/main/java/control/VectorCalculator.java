package control;

import model.Vector;

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
					firstVector.getRow(), firstVector.getColumn());
			for (int row = 0; row < firstVector.getCurrentMatrix().length; row++) {
				for (int col = 0; col < firstVector.getCurrentMatrix()[row].length; col++) {
					showWork[row][col] = "(" + firstVector.getCurrentMatrix()[row][col] + ")" + " + " + "("
							+ secondVector.getCurrentMatrix()[row][col] + ")";
					double add = firstVector.getCurrentMatrix()[row][col] + secondVector.getCurrentMatrix()[row][col];
					answer[row][col] = "(" + add + ")";
					newData[row][col] = add;
				}
			}

			showWorkAddition = showWork;
			answerAddition = answer;
			addedVector.setCurrentMatrix(newData);
			return addedVector;
		} else {
			System.out.println("Dimensions are not same...");
		}
		return null;
	}

	public Vector subtractMatrices(Vector firstVector, Vector secondVector) {
		if (areSameDimensions(firstVector, secondVector)) {

			double[][] newData = new double[firstVector.getRow()][firstVector.getColumn()];
			String[][] showWork = new String[firstVector.getRow()][firstVector.getColumn()];
			String[][] answer = new String[firstVector.getRow()][firstVector.getColumn()];

			Vector subtractVector = new Vector("" + firstVector.getName() + "-" + secondVector.getName(),
					firstVector.getRow(), firstVector.getColumn());
			for (int row = 0; row < firstVector.getCurrentMatrix().length; row++) {
				for (int col = 0; col < firstVector.getCurrentMatrix()[row].length; col++) {
					showWork[row][col] = "(" + firstVector.getCurrentMatrix()[row][col] + ")" + " + " + "("
							+ secondVector.getCurrentMatrix()[row][col] + ")";
					double sub = firstVector.getCurrentMatrix()[row][col] - secondVector.getCurrentMatrix()[row][col];
					answer[row][col] = "(" + sub + ")";
					newData[row][col] = sub;

				}
			}

			showWorkSubtraction = showWork;
			answerSubtraction = answer;
			subtractVector.setCurrentMatrix(newData);
			return subtractVector;
		} else {
			System.out.println("Dimensions are not same...");
		}
		return null;
	}

	public boolean areSameMatrices(Vector firstVector, Vector secondVector) {
		if (firstVector == null || secondVector == null) {
			return false;
		}
		for (int row = 0; row < firstVector.getCurrentMatrix().length; row++) {
			for (int col = 0; col < firstVector.getCurrentMatrix()[row].length; col++) {
				if (firstVector.getCurrentMatrix()[row][col] == secondVector.getCurrentMatrix()[row][col]) {

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
