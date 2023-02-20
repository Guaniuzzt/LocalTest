package TestForAlgorithm;

import java.util.HashSet;
import java.util.Set;

public class Oct12 {

    public static void main(String[] args) {


        System.out.println(getLargestNumber("0082663"));

    }

    public static String getLargestNumber(String input){

        Set<Character> oddset = new HashSet<>();
        Set<Character> evenset = new HashSet<>();

        for(int i=0; i<10; i=i+2){
            oddset.add((char)('1' + i));
            evenset.add((char)('0' + i));
        }

        char[] array = input.toCharArray();
        int index = 0;

        while(index != array.length){
            if(oddset.contains(array[index])){
                int end = index;
                while(end != array.length && oddset.contains(array[end])){
                    end++;
                }
                sort(array, index, end-1);
                index = end;
            }else{
                int end = index;
                while(end != array.length && evenset.contains(array[end])){
                    end++;
                }
                sort(array, index, end-1);
                index = end;
            }
        }
        return new String(array);
    }


    public static void sort(char[] array, int start, int end){
        for(int i=start; i <= end; i++){
            for(int j=i+1; j<=end; j++){
                if(array[j] > array[i]){
                    char temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

    }
}
