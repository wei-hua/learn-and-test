package algrithm;

import java.util.Arrays;

/**
 * Created by Alina on 2019/10/11.
 */
public class rotateArray {
  public static void rotate(int[][] matrix) {
    int n = matrix.length;

    // transpose matrix
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int tmp = matrix[j][i];
        matrix[j][i] = matrix[i][j];
        matrix[i][j] = tmp;
      }
    }
    System.out.println(Arrays.deepToString(matrix));
    // reverse each row
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n / 2; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[i][n - j - 1];
        matrix[i][n - j - 1] = tmp;
      }
    }
    System.out.println(Arrays.deepToString(matrix));
  }

  public static void main(String[] args) {
    int[][] a = {{00,01,02}, {10,11,12}, {20,21,22}};
    rotate(a);
  }

}
