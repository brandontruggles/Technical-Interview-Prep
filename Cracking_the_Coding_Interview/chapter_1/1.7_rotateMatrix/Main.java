/*

*/

public class Main {
	public static void main(String [] args) {
		int[][] matrix = { {0, 0, 0}, {1, 0, 1}, {0, 0, 0} };
		BestSolution.outputMatrix(matrix);
		BestSolution.rotateMatrix(matrix);
		BestSolution.outputMatrix(matrix);
		int[][] matrix2 = { {1, 1, 0}, {1, 0, 1}, {0, 1, 0} };
		BestSolution.outputMatrix(matrix2);
		BestSolution.rotateMatrix(matrix2);
		BestSolution.outputMatrix(matrix2);
		int[][] matrix3 = { {0, 0, 0, 1, 1}, {1, 0, 1, 1, 1}, {0, 0, 0, 0, 1} , {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0} };
		BestSolution.outputMatrix(matrix3);
		BestSolution.rotateMatrix(matrix3);
		BestSolution.outputMatrix(matrix3);
	}
}

//Example matrix:
// 0 1 0 1 0
// 1 1 0 1 1
// 0 0 0 0 0
// 0 0 0 0 0
// 0 0 0 0 0

// 0 1 0 0 0
// 1 1 0 0 0
// 0 0 0 0 0
// 1 1 0 0 0
// 0 1 0 0 0

//Things to note: this is a transpose of the matrix with its rows reversed, since we're rotating counter-clockwise. This means we can simply swap the coordinates for each point.

class BestSolution {
  public static void rotateMatrix(int[][] matrix) {
    if(matrix == null) {
      return;
    }
    //Diagonal of matrix remains the same when finding the transpose. We're swapping everything above the diagonal to avoid double swaps.
    for(int i = 0; i < matrix.length; i++) {
      for(int j = i + 1; j < matrix[i].length; j++) {
        swap(matrix, i, j);
      }
    }

    //Lastly, reverse the rows.
    for(int i = 0; i < matrix.length/2; i++) {
      for(int j = 0; j < matrix[i].length; j++) {
        int tmp = matrix[matrix.length - 1 - i][j];
        matrix[matrix.length - 1 - i][j] = matrix[i][j];
        matrix[i][j] = tmp;
      }
    }

  }

  public static void swap(int[][] matrix, int row, int col) {
    int tmp = matrix[row][col];
    matrix[row][col] = matrix[col][row];
    matrix[col][row] = tmp;
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

