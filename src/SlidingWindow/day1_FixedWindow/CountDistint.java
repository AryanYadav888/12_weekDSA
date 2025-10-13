package SlidingWindow.day1_FixedWindow;

import java.util.*;

public class CountDistint {
    public static ArrayList<Integer> countDistinct(int[] arr,int k){
        ArrayList<Integer> lst = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int n = arr.length;

//        first window
        for(int i=0;i<k;i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        lst.add(map.size());

//        Slide window
        for(int i=k;i<n;i++){
            int out = arr[i-k];
            map.put(out,map.get(out)-1);
            if(map.get(out) == 0){
                map.remove(out);
            }
            int in = arr[i];
            map.put(in, map.getOrDefault(in,0)+1);


            lst.add(map.size());
        }

        return lst;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = sc.nextInt();

        ArrayList<Integer> res = countDistinct(arr,k);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i)+" ");
        }
    }
}
/*
arr = [1, 2, 1, 3, 4, 2, 3]
k = 4
*/