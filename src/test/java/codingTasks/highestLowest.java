package codingTasks;

public class highestLowest {
    public static void main(String[] args) {
        //"8 3 -5 42 -1 0 0 -9 4 7 4 -4"
        System.out.println(highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }

    public static String highAndLow(String numbers) {
        // Code here
        int len = numbers.length();
        int max_val = 0;
        int min_val = 0;
        for (int i =0; i< len; i++){
            char ch = numbers.charAt(i);
            if (ch != ' ') {
                int value = 0;
                int sign = 1;
                if (ch == '-') {
                    i++;
                    sign = -1;
                    ch = numbers.charAt(i);
                }
                value = Integer.parseInt(String.valueOf(ch));
                while ((i+1 < len) && (numbers.charAt(i+1) != ' ') ) {
                    i++;
                    ch = numbers.charAt(i);
                    value = value * 10 + Integer.parseInt(String.valueOf(ch));
                }
                value = value * sign;
                if (min_val == 0) {
                    min_val = value;
                }
                else {
                    if (min_val > value) {
                        min_val = value;
                    }
                }
                if (max_val == 0) {
                    max_val = value;
                }
                else {
                    if (max_val < value) {
                        max_val = value;
                    }
                }
            }
        }

        return max_val +" " + min_val;
    }
}
