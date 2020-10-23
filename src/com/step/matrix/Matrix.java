package com.step.matrix;

class Matrix {
  private int[][] matrix;
  private int rowCount;
  private int colCount;
  private double det;

  public Matrix(int[][] matrix) {
    this.rowCount = matrix.length;
    this.colCount = matrix[0].length;
    this.det = 0;
    this.matrix = matrix.clone();
    for (int index = 0; index < this.matrix.length; index++) {
      this.matrix[index] = this.matrix[index].clone();
    }
  }

  public int[][] getMatrix() {
    int[][] parent = this.matrix.clone();
    for (int index = 0; index < parent.length; index++) {
      parent[index] = parent[index].clone();
    }
    return parent;
  }

  public Matrix add(Matrix other) {
    boolean isDimensionsMatch =
      this.rowCount == other.rowCount && this.colCount == other.colCount;
    if (!isDimensionsMatch) {
      return null;
    }
    int result[][] = new int[this.rowCount][this.colCount];
    for (int row = 0; row < this.rowCount; row++) {
      for (int column = 0; column < this.colCount; column++) {
        result[row][column] =
          this.matrix[row][column] + other.matrix[row][column];
      }
    }
    return new Matrix(result);
  }

  public Matrix subtract(Matrix other) {
    boolean isDimensionsMatch =
      this.rowCount == other.rowCount && this.colCount == other.colCount;
    if (!isDimensionsMatch) {
      return null;
    }
    int result[][] = new int[this.rowCount][this.colCount];
    for (int row = 0; row < this.rowCount; row++) {
      for (int column = 0; column < this.colCount; column++) {
        result[row][column] =
          this.matrix[row][column] - other.matrix[row][column];
      }
    }
    return new Matrix(result);
  }

  public Matrix multiply(Matrix other) {
    if (this.colCount != other.rowCount) {
      return null;
    }
    int result[][] = new int[this.rowCount][other.colCount];
    for (int i = 0; i < this.rowCount; i++) {
      for (int j = 0; j < other.colCount; j++) {
        for (int k = 0; k < other.rowCount; k++) {
          result[i][j] += this.matrix[i][k] * other.matrix[k][j];
        }
      }
    }
    return new Matrix(result);
  }

  public StringBuilder display() {
    StringBuilder builder = new StringBuilder();
    for (int row = 0; row < this.rowCount; row++) {
      for (int column = 0; column < this.colCount; column++) {
        builder.append(this.matrix[row][column]).append("  ");
      }
      builder.append("\n");
    }
    return builder;
  }

  private Matrix createMatrix(int rowCount) {
    int[][] newMatrix = new int[this.rowCount - 1][this.rowCount - 1];
    for (int rowPos = 1; rowPos < this.rowCount; rowPos++) {
      for (int colPos = 0; colPos < this.rowCount; colPos++) {
        int number = this.matrix[rowPos][colPos];
        int[] row = newMatrix[rowPos - 1];
        if (colPos < rowCount) row[colPos] = number;
        if (colPos > rowCount) row[colPos - 1] = number;
      }
    }
    return new Matrix(newMatrix);
  }

  public double determinant() {
    if (this.rowCount == 1) return this.matrix[0][0];
    for (int rowCount = 0; rowCount < this.rowCount; rowCount++) {
      int sign = rowCount % 2 == 0 ? 1 : -1;
      Matrix newMatrix = this.createMatrix(rowCount);
      this.det += sign * this.matrix[0][rowCount] * newMatrix.determinant();
    }
    return this.det;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof Matrix)) return false;

    Matrix matrix = (Matrix) other;

    boolean dimensionsEqual =
      this.colCount == matrix.colCount && this.rowCount == matrix.rowCount;
    if (!dimensionsEqual) return false;
    
    boolean isEqual = true;
    for (int rowCount = 0; rowCount < this.rowCount; rowCount++) {
      for (int colCount = 0; colCount < this.colCount; colCount++) {
        boolean isElementEqual =
          this.matrix[rowCount][colCount] == matrix.matrix[rowCount][colCount];
        isEqual = isEqual && isElementEqual;
      }
    }
    return isEqual;
  }
}
