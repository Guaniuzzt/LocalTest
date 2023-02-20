package TestListDeleteIndex;

import java.util.ArrayList;
import java.util.List;

public class ListDeleteIndex {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        //list.remove(0);
        list.remove((Integer)0);
        System.out.println(list.size());


    }



}
