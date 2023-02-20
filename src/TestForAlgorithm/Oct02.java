package TestForAlgorithm;

public class Oct02 {

    public static void main(String[] args) {
        /*
        "XXXXXLXXXX"
        "LXXXXXXXXX"
         */
        String start = "RXXLRXRXL";
        String end = "XRLXXRRLX";

        System.out.println(canTransform(start, end));


    }

    public static boolean canTransform(String start, String end) {

        if(start.length() != end.length()){
            return false;
        }


        for(int i=0; i<start.length(); i++){

            if(start.charAt(i) == end.charAt(i)){
                continue;
            }else if(i+1 < start.length() && start.charAt(i+1) == 'X'
                    && end.charAt(i) == 'X' && start.charAt(i) == end.charAt(i+1) && start.charAt(i) == 'R'){
                i = i+1;
            }else if(i+1 < start.length() && start.charAt(i) == 'X'
                    && end.charAt(i+1) == 'X' && start.charAt(i+1) == end.charAt(i) && end.charAt(i) == 'L' ){
                i = i+1;
            }else{
                return false;
            }

        }

        return true;

    }
}
