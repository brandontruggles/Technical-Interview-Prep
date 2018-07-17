/*

*/

public class Main {
	public static void main(String [] args) {
		int[][] matrix = { {0, 0, 0}, {1, 0, 1}, {0, 0, 0} };
		BestSolution.outputMatrix(matrix);
		BestSolution.rotateMatrix(matrix);
		BestSolution.outputMatrix(matrix);
	}
}

class BestSolution {
	public static void rotateMatrix(int[][] matrix) {
		if(matrix == null) {
			return;
		}
		int n = matrix.length;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				swap(matrix, i, j);
			}
		}
	}

	public static void swap(int[][] matrix, int row, int col) {
		int n = matrix.length;
		int tmp = matrix[row][col];
		matrix[row][col] = matrix[n - col - 1][n - row - 1];
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
