package TestForAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class July07 {

    //test list add(int index, int element
    public static void main(String[] args) {
        /*List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0,1);
        for(int num : list){
            System.out.println(num);
        }*/

        MyCalendarTwo test = new MyCalendarTwo();
        System.out.println(test.book(1,10));
        System.out.println(test.book(4,6));
        System.out.println(test.book(1,4));

    }

    static class MyCalendarTwo {

        List<int[]> booked;
        List<int[]> overlaps;

        public MyCalendarTwo() {
            booked = new ArrayList<int[]>();
            overlaps = new ArrayList<int[]>();
        }

        public boolean book(int start, int end) {
            for (int[] arr : overlaps) {
                int l = arr[0], r = arr[1];
                if (l < end && start < r) {
                    return false;
                }
            }
            for (int[] arr : booked) {
                int l = arr[0], r = arr[1];
                if (l < end && start < r) {
                    overlaps.add(new int[]{Math.max(l, start), Math.min(r, end)});
                }
            }
            booked.add(new int[]{start, end});
            return true;
        }
    }
}
