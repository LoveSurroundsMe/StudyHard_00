import java.util.Arrays;

/**
 * TODO
 *
 * @author Administrator
 * @version 1.0
 * @date 2022/6/18 11:01
 */
public class Test1 {

    public static void main(String[] strs) {
        int[] a = {13, 15, 18, 12, 19, 20};
        int[] b = hightTemp(a);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]+",");
        }
    }


    private static int[] hightTemp(int[] array) {
        int[] max = new int[array.length];
        max[0] = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    max[i] = j - i;
                    break;
                } else {
                    max[i] = 1;
                }
            }
        }
        return max;
    }
}
