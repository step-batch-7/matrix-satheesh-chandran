package com.step.matrix;

class Matrix {
  private int[][] matrix;
  private int rowCount;
  private int colCount;

  public Matrix(int[][] matrix) {
    this.rowCount = matrix.length;
    this.colCount = matrix[0].length;
    this.matrix = matrix;
  }

  public int[][] getMatrix() {
    int[][] parent = new int[this.rowCount][this.colCount];
    for (int index = 0; index < this.rowCount; index++) {
      parent[index] = this.matrix[index].clone();
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
}
