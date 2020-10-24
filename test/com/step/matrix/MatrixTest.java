package com.step.matrix;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MatrixTest {

  @Test
  public void shouldGiveCloneOfTheInputArray() {
    Matrix matrix = new Matrix(new int[][] { { 1, 1 }, { 2, 2 } });
    int[][] expected = { { 1, 1 }, { 2, 2 } };
    assertArrayEquals(expected, matrix.getMatrix());
  }

  @Test
  public void shouldGiveStringRepresentation() {
    Matrix matrix = new Matrix(new int[][] { { 1, 1 }, { 2, 2 } });
    assertEquals("1  1  \n2  2  \n", matrix.toString());
  }

  @Test
  public void shouldAddTwoMatrices() {
    Matrix matrix1 = new Matrix(new int[][] { { 1, 1 }, { 2, 2 } });
    Matrix matrix2 = new Matrix(new int[][] { { 1, 1 }, { 2, 2 } });
    Matrix expected = new Matrix(new int[][] { { 2, 2 }, { 4, 4 } });
    assertArrayEquals(expected.getMatrix(), matrix1.add(matrix2).getMatrix());
    assertEquals(expected, matrix1.add(matrix2));
  }

  @Test
  public void shouldSubtractTwoMatrices() {
    Matrix matrix1 = new Matrix(new int[][] { { 1, 1 }, { 2, 2 } });
    Matrix matrix2 = new Matrix(new int[][] { { 1, 1 }, { 2, 2 } });
    Matrix expected = new Matrix(new int[][] { { 0, 0 }, { 0, 0 } });
    assertArrayEquals(
      expected.getMatrix(),
      matrix1.subtract(matrix2).getMatrix()
    );
    assertEquals(expected, matrix1.subtract(matrix2));
  }

  @Test
  public void shouldMultiplyMatrices() {
    Matrix matrix1 = new Matrix(new int[][] { { 1, 1 }, { 2, 2 } });
    Matrix matrix2 = new Matrix(new int[][] { { 1, 1 }, { 2, 2 } });
    Matrix expected = new Matrix(new int[][] { { 3, 3 }, { 6, 6 } });
    assertArrayEquals(
      expected.getMatrix(),
      matrix1.multiply(matrix2).getMatrix()
    );
    assertEquals(expected, matrix1.multiply(matrix2));
  }

  @Test
  public void shouldGiveNullIfMultiplicationIsNotPossible() {
    Matrix matrix1 = new Matrix(new int[][] { { 1, 1 }, { 2, 2 } });
    Matrix matrix2 = new Matrix(new int[][] { { 1 } });
    assertNull(matrix1.multiply(matrix2));
  }

  @Test
  public void shouldGiveTheDeterminant() {
    int[][] numbers = { { 2, -3, 1 }, { 2, 0, -1 }, { 1, 4, 5 } };
    Matrix matrix = new Matrix(numbers);
    assertEquals(matrix.determinant(), 49, 0.0);
  }

  @Test
  public void shouldGiveTrueForSameInstances() {
    int[][] numbers = { { 2, -3, 1 }, { 2, 0, -1 }, { 1, 4, 5 } };
    Matrix matrix = new Matrix(numbers);
    assertTrue(matrix.equals(matrix));
  }

  @Test
  public void shouldGiveFalseForDifferentInstances() {
    int[][] numbers = { { 2, -3, 1 }, { 2, 0, -1 }, { 1, 4, 5 } };
    Matrix matrix = new Matrix(numbers);
    assertFalse(matrix.equals(new Object()));
  }

  @Test
  public void shouldGiveFalseForNull() {
    int[][] numbers = { { 2, -3, 1 }, { 2, 0, -1 }, { 1, 4, 5 } };
    Matrix matrix = new Matrix(numbers);
    assertFalse(matrix.equals(null));
  }

  @Test
  public void shouldGiveTrueForSameMatrices() {
    int[][] numbers1 = { { 2, -3, 1 }, { 2, 0, -1 } };
    int[][] numbers2 = { { 2, -3, 1 }, { 2, 0, -1 } };
    Matrix matrix1 = new Matrix(numbers1);
    Matrix matrix2 = new Matrix(numbers2);
    assertTrue(matrix1.equals(matrix2));
  }

  @Test
  public void shouldGiveFalseForDifferentMatrices() {
    int[][] numbers1 = { { 2, -3, 1 }, { 2, 0, -1 } };
    int[][] numbers2 = { { 2, -3, 1 }, { 2, 0, 1 } };
    Matrix matrix1 = new Matrix(numbers1);
    Matrix matrix2 = new Matrix(numbers2);
    assertFalse(matrix1.equals(matrix2));
  }

  @Test
  public void shouldGiveFalseForDifferentDimensionsMatrices() {
    int[][] numbers1 = { { 2, -3, 1 }, { 2, 0, -1 } };
    int[][] numbers2 = { { 2, -3 } };
    Matrix matrix1 = new Matrix(numbers1);
    Matrix matrix2 = new Matrix(numbers2);
    assertFalse(matrix1.equals(matrix2));
  }
}
