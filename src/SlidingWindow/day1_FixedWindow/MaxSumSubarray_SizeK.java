package SlidingWindow.day1_FixedWindow;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSumSubarray_SizeK {
    public static int maxSubarraySum(int[] arr,int k){
        int n = arr.length;
        int i=0,j=k-1,sum = 0,maxSum=0;
        for(int a=0;a<=k-1;a++){
            sum += arr[a];
        }
        maxSum = sum;
        i++;j++;
        while (j<n){
            sum = sum - arr[i-1]+arr[j];
            maxSum = Math.max(maxSum,sum);
            i++;j++;
        }
        return maxSum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = sc.nextInt();

        System.out.println(maxSubarraySum(arr,k));
    }
}
