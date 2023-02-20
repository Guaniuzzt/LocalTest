package TestCommonMethods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapListPrint {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        List<Integer> list = new ArrayList<>();
        list.add(1);

        System.out.println(map);
        System.out.println(list);
    }
}
