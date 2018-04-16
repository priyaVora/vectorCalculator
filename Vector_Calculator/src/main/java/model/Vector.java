
package model;

public class Vector {
	private String name = null;
	private Integer row = 0;
	private Integer column = 0;

	double[][] currentVector = new double[0][0];

	public Vector(String name, Integer row, Integer column) {
		this.name = name;
		this.row = row;
		this.column = column;
		createDefaultMatrix();
	}

	private void createDefaultMatrix() {
		if (!(row == 0 || column == 0)) {
			currentVector = new double[row][column];
			for (int row = 0; row < currentVector.length; row++) {
				for (int col = 0; col < currentVector[row].length; col++) {
					currentVector[row][col] = 0;
				}
			}
		}
	}

	public Vector() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Integer getColumn() {
		return column;
	}

	public void setColumn(Integer column) {
		this.column = column;
	}

	public double[][] getCurrentMatrix() {
		return currentVector;
	}

	public void setCurrentMatrix(double[][] currentMatrix) {
		this.currentVector = currentMatrix;
	}

	@Override
	public String toString() {
		return "Matrix: [" + name + "]: " + row + "X" + column + " " + currentVector;
	}

	public void printMatrix() {
		System.out.println("\nPrint: [" + name + "] " + row + "X" + column + "\n");
		for (int row = 0; row < this.currentVector.length; row++) {
			for (int col = 0; col < this.currentVector[row].length; col++) {
				System.out.print(currentVector[row][col]);
				System.out.print(" ");
			}
			System.out.println(" ");
		}
	}

}
