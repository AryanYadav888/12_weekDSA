package HighCTCQuestions.Arrays_Part_01;

import java.util.Arrays;
import java.util.Scanner;

public class Buy_SellStock121 {
    public static int maxProfit(int[] price){
        int buy = price[0];
        int profit = 0;
        for(int i=1;i<price.length;i++){
            if(buy>price[i]) buy = price[i];
            profit = Math.max(profit,price[i]-buy);
        }
        return profit;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(maxProfit(arr));
    }
}
