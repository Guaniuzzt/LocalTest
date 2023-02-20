package TestCommonMethods;

import java.util.HashMap;
import java.util.Map;

public class PrintMap {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(1, 0);
        map.put(2, 0);

        System.out.println(map.toString());
    }
}
