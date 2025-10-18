package HighCTCQuestions.Arrays_Part_01;

import java.util.Scanner;

public class SetZeroes_73 {
    public static void markRow(int[][] matrix,int i,int n){
        for(int j=0;j<n;j++){
            if(matrix[i][j]!=0) matrix[i][j] = -1;
        }
    }
    public static void markCol(int[][] matrix,int j,int m){
        for (int i = 0; i < m; i++) {
            if(matrix[i][j]!=0) matrix[i][j] = -1;
        }
    }
    public static void bruteForce(int[][] matrix){
        int m = matrix.length ,n = matrix[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                markRow(matrix,i,n);
                markCol(matrix,j,m);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == -1) matrix[i][j] = 0;
            }
        }
    }

    public static void betterOne(int[][] matrix){
        int m = matrix.length , n = matrix[0].length;
        int[] row = new int[m] ; int[] col = new int[n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(row[i] == 1 || col[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void optimized(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int col0 = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;

                    if (j != 0) arr[0][j] = 0;
                    else col0 = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][j] != 0) {
                    if (arr[0][j] == 0 || arr[i][0] == 0) arr[i][j] = 0;
                }
            }
        }
        if (arr[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                arr[0][j] = 0;
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                arr[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        bruteForce(matrix);
        betterOne(matrix);

        optimized(matrix);
    }
}
