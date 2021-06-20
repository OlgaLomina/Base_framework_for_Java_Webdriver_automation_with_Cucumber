package codingTasks;

public class IsEven {
    public static void main(String[] args) {
//        assertEquals(true, num.isEven(0));
//        assertEquals(false, num.isEven(0.5));
//        assertEquals(false, num.isEven(1));
//        assertEquals(true, num.isEven(2));
//        assertEquals(true, num.isEven(-4));
        System.out.println(isEven(0.5));
    }

    public static boolean isEven(double n) {
        // Your awesome code here!
        n = Math.round(n);
        int rem = (int)n % 2;
        if (rem == 0) {
            return true;
        }

        return false;
    }
}
