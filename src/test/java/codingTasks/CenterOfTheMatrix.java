package codingTasks;

public class CenterOfTheMatrix {


    public static void main(String[] args) {
        System.out.println(center(new int[][]{ {5,1,3}, {6,2,6}, {7,4,5}, {10,12,12}, {14,0,0} }));
    }


    public static Integer center(int[][] m) {
        int x, y;
        return ((y = m.length) % 2 > 0) && ((x = m[0].length) % 2 > 0) ? m[y/2][x/2] : null;
    }
}
