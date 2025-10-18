package HighCTCQuestions.Arrays_Part_01;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSubarray_53 {
    public static int maxSubArray(int[] arr){
        int n = arr[0];
        int sum = 0;
        for(int i:arr){
            if(sum<0) sum = 0;
            sum += i;
            n = Math.max(n,sum);
        }
        return n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(maxSubArray(arr));
    }
}
