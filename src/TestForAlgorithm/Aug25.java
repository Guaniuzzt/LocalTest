package TestForAlgorithm;

import java.util.*;

public class Aug25 {


    public static void main(String[] args) {
        int[] array = new int[]{0,0,1,2,3,3,4,7,7,8};
        List<Integer> res = findClosestElements(array, 3, 5);
        System.out.println(res);
        List<Integer> temp = new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        };
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {


        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){

            @Override
            public int compare(Integer a, Integer b){
                if(Math.abs(a-x) == Math.abs(b-x)){
                    return a > b ? -1 : 1;
                }

                return Math.abs(a-x) > Math.abs(b-x) ? -1 : 1;
            }
        });

        for(int n : arr){
            if(pq.size() < k){
                pq.offer(n);
            }else{
                int dist = Math.abs(pq.peek() - x);
                if( (Math.abs(n-x) < dist) ||
                        (Math.abs(n-x) == dist && n < pq.peek()) ){
                    pq.poll();
                    pq.offer(n);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<k; i++){
            list.add(pq.poll());
        }

        Collections.sort(list);
        return list;
    }
}
