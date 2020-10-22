package com.step.matrix;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MatrixTest {

  @Test
  public void shouldGiveCloneOfTheInputArray() {
    int[][] numbers = { { 1, 1 }, { 2, 2 } };
    Matrix matrix = new Matrix(numbers);
    int[][] expected = { { 1, 1 }, { 2, 2 } };

    assertArrayEquals(expected, matrix.getMatrix());
  }

  @Test
  public void shouldAddTwoMatrices() {
    int[][] numbers1 = { { 1, 1 }, { 2, 2 } };
    Matrix matrix1 = new Matrix(numbers1);

    int[][] numbers2 = { { 1, 1 }, { 2, 2 } };
    Matrix matrix2 = new Matrix(numbers2);
    int[][] expectedNum = { { 2, 2 }, { 4, 4 } };
    Matrix expected = new Matrix(expectedNum);

    assertArrayEquals(expected.getMatrix(), matrix1.add(matrix2).getMatrix());
  }
}