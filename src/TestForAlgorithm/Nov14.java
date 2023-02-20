package TestForAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Nov14 {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstringKDistinct("aba", 1));


    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {

        if(k == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int head = 0;
        for(int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            if(map.size() < k || (map.containsKey(cur) && map.size() == k)){
                map.put(cur, map.getOrDefault(cur, 0)+1);
                res = Math.max(res, i - head + 1);
            }else{
                while(map.size() == k){
                    char prev = s.charAt(head);
                    int count = map.get(prev);
                    if(count > 1){
                        map.put(prev, count-1);
                        head++;
                    }else if(count == 1){
                        map.remove(prev);
                        map.put(cur, map.getOrDefault(cur, 0)+1);
                        head++;
                        break;
                    }

                }
            }
        }
        return res;

    }
}
