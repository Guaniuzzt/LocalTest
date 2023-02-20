package TestForAlgorithm;

import java.util.*;

public class Sept19 {

    public static void main(String[] args) {

        int[] input = new int[]{1,1,2,2,2,3};
        System.out.println(Arrays.toString(frequencySort(input)));
    }

    public static int[] frequencySort(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i, map.getOrDefault(i,0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>(){

            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b){

                int count1 = a.getValue();
                int count2 = b.getValue();
                int num1 = a.getKey();
                int num2 = b.getKey();

                return count1 < count2 ? -1 : (count1 == count1 ? (num1 < num2 ? 1 : -1 ) : 1);
            }
        });


        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(entry);
        }
        int index = 0;
        while(pq.size() != 0){
            Map.Entry<Integer, Integer> entry = pq.poll();
            int count = entry.getValue();
            int num = entry.getKey();

            for(int i=0; i<count; i++){
                nums[index++] = num;
            }
        }

        return nums;

    }
}
