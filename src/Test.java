/**
 * TODO
 *
 * @author Administrator
 * @version 1.0
 * @date 2022/6/8 17:00
 */
public class Test {

    public static void main(String[] strs) {
        int[] arrays = {1, 9, 0, 3, 5, 6, 7};
        System.out.println(longestZxl(arrays));
    }

    private static int longestZxl(int[] arrays) {
        if (arrays.length == 0) {
            return 0;
        }
        int[] temp = new int[arrays.length];
        temp[0] = 1;
        int max = 1;
        for (int i = 1; i < arrays.length; i++) {
            temp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arrays[i] > arrays[j]) {
                    temp[i] = Math.max(temp[i], temp[j] + 1);
                }
            }
            max = Math.max(max, temp[i]);
        }
        return max;
    }
}
