package SlidingWindow.day1_FixedWindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MaximumSubarraySum_2461 {
    public static long maximumSubarraySum(int[] arr,int k){
        int n = arr.length;
        long maxSum = 0,sum = 0;
        Set<Integer> set = new HashSet<>();
        int left=0;
        for(int right=0;right<n;right++){
            while (set.contains(arr[right])){
                set.remove(arr[left]);
                sum -= arr[left];
                left++;
            }
            set.add(arr[right]);
            sum += arr[right];

            if(right-left+1>k){
                set.remove(arr[left]);
                sum -= arr[left];
                left++;
            }
            if(right-left+1==k) maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = sc.nextInt();

        System.out.println(maximumSubarraySum(arr,k));
    }
}
