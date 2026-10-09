package HW7;

public class Matrix {
    public static void main(String[] args) {
        int[][] A = {
            {2, 3, 4},
            {3, 4, 5}
        };
        
        int[][] B = {
            {1,2},
            {3,4},
            {5,6}
        };

        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;

        if (colsA != rowsB) {
            System.out.println("Matrix A and B cannot be multiplied");
            return;
        }

        int[][] product = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    product[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        System.out.println("A * B ="); 
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                System.out.print(product[i][j] + " ");
            }
            System.out.println();
        }





    }
}
