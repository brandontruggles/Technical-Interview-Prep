/*

*/

public class Main {
	public static void main(String [] args) {
		int[][] matrix = { {1, 1, 1}, {1, 0, 1}, {1, 1, 1} };
		BestSolution.outputMatrix(matrix);
		BestSolution.zeroMatrix(matrix);
		BestSolution.outputMatrix(matrix);
		int[][] matrix2 = { {1, 1, 1, 1, 1}, {0, 0, 1, 1, 1}, {1, 1, 1, 1, 1} };
		BestSolution.outputMatrix(matrix2);
		BestSolution.zeroMatrix(matrix2);
		BestSolution.outputMatrix(matrix2);
		int[][] matrix3 = { {1}, {1}, {0} };
		BestSolution.outputMatrix(matrix3);
		BestSolution.zeroMatrix(matrix3);
		BestSolution.outputMatrix(matrix3);
		int[][] matrix4 = { {1} };
		BestSolution.outputMatrix(matrix4);
		BestSolution.zeroMatrix(matrix4);
		BestSolution.outputMatrix(matrix4);
	}
}

class BestSolution {
	public static void zeroMatrix(int[][] matrix) {
		if(matrix == null) {
			return;
		}

    boolean firstRowZero = false;
    boolean firstColZero = false;

    for(int i = 0; i < matrix.length; i++) {
      if(matrix[i][0] == 0) {
        firstColZero = true;
      }
    }

    for(int i = 0; i < matrix[0].length; i++) {
      if(matrix[0][i] == 0) {
        firstRowZero = true;
      }
    }

		for(int i = 1; i < matrix.length; i++) {
			for(int j = 1; j < matrix[i].length; j++) {
				if(matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

    for(int i = 1; i < matrix.length; i++) {
      if(matrix[i][0] == 0) {
        zeroRow(i, matrix);
      }
    }
    
    for(int i = 1; i < matrix[0].length; i++) {
      if(matrix[0][i] == 0) {
        zeroCol(i, matrix);
      }
    }

    if(firstColZero) {
      zeroCol(0, matrix);
    }

    if(firstRowZero) {
      zeroRow(0, matrix);
    }

	}

  public static void zeroRow(int row, int[][] matrix) {
    for(int i = 0; i < matrix[row].length; i++) {
      matrix[row][i] = 0;
    }
  }

  public static void zeroCol(int col, int[][] matrix) {
    for(int i = 0; i < matrix.length; i++) {
      matrix[i][col] = 0;
    }
  }

	public static void outputMatrix(int[][] matrix) {
		for(int[] arr : matrix) {
			for(int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
