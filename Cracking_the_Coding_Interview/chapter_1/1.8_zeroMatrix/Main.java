/*

*/

public class Main {
	public static void main(String [] args) {
		int[][] matrix = { {1, 1, 1}, {1, 0, 1}, {1, 1, 1} };
		BestSolution.outputMatrix(matrix);
		BestSolution.zeroMatrix(matrix);
		BestSolution.outputMatrix(matrix);
	}
}

class BestSolution {
	public static void zeroMatrix(int[][] matrix) {
		if(matrix == null) {
			return;
		}
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
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
