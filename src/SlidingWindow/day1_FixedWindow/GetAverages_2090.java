package SlidingWindow.day1_FixedWindow;

import java.util.Arrays;
import java.util.Scanner;

public class GetAverages_2090 {
    public static int[] getAverages(int[] arr,int k){
        int[] res = new int[arr.length];
        int n = arr.length;
        Arrays.fill(res,-1);
        if(2*k+1>n) return res;

        long[] prefix = new long[n+1];
        for(int i=0;i<n;i++){
            prefix[i+1] = prefix[i]+arr[i];
        }
        for(int i=k;i<n-k;i++){
            long sum = prefix[i+k+1] - prefix[i-k];
            res[i] = (int)(sum/(2*k+1));
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = sc.nextInt();

        int[] res = getAverages(arr,k);

        for(int ele : res){
            System.out.print(ele+" ");
        }
    }
}
