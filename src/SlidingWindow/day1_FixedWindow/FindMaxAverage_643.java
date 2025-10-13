package SlidingWindow.day1_FixedWindow;

import java.util.Arrays;
import java.util.Scanner;

public class FindMaxAverage_643 {
    /*
    public static double findMaxAverage(int[] arr,int k){
        int n = arr.length;
        int i=0 , j=k-1,sum=0;
        double maxSum = 0;
        for(int a=0;a<=k-1;a++){
            sum += arr[a];
        }
        maxSum = sum;
        i++;j++;
        while (j<n){
            sum = sum - arr[i-1] + arr[j];
            maxSum = Math.max(maxSum,sum);
            i++;j++;
        }
        return maxSum/k;
    }
    */

//     OR
    public static double findMaxAverage(int[] arr, int k){
        int n = arr.length, sum = 0;
        double maxSum = 0;
        for(int i=0;i<k-1;i++){
            sum += arr[i];
        }
        maxSum = sum;
        for (int i=k;i<n;i++){
            sum = sum - arr[i-k] + arr[i];
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum/k;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = sc.nextInt();

        System.out.println(findMaxAverage(arr, k));
    }
}
