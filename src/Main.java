import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int seatNum = sc.nextInt();
        sc.nextLine();
        String seatOrLeaveLine = sc.nextLine();
        String[] c = seatOrLeaveLine.substring(1, seatOrLeaveLine.length() - 1).split(", ");
        int[] seatOrLeave = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            seatOrLeave[i] = Integer.parseInt(c[i]);
        }

        Main socialDistance = new Main();
        int ans = socialDistance.conferenceSeatDistance(seatNum, seatOrLeave);
        System.out.println(ans);
    }

    /**
     * 计算最后进来的人，坐的位置
     *
     * @param seatNum     会议室座位总数
     * @param seatOrLeave 员工的进出顺序
     * @return 最后进来的人，坐的位置
     */
    public int conferenceSeatDistance(int seatNum, int[] seatOrLeave) {
        int[] dp = new int[seatOrLeave.length];
        List<Integer> list = new ArrayList<>(seatNum);
        for (int i = 0; i < seatNum; i++) {
            list.add(0);
        }
        if (seatOrLeave.length == 1) {
            return 0;
        } else if (seatOrLeave.length == 2 && seatOrLeave[1] == 1) {
            return 9;
        } else {
            for (int i = 1; i < seatOrLeave.length; i++) {
                if (seatOrLeave[i] == 1) {
                    list.set(i, 1);
                } else if (seatOrLeave[i] < 0) {
                    list.add(-seatOrLeave[i], 0);
                }

                dp[i] = (dp[i - 1] - dp[i - 2]) / 2;


            }
        }

        return dp[dp.length - 1];
    }

    public void test2(String[] args) {
//        a:3,b:5,c:2@a:3,b:2
        Scanner sc = new Scanner(System.in);
        StringBuffer buffer = new StringBuffer();
        while (sc.hasNextLine()) {
            String[] strIn = sc.nextLine().split("@");
            if (strIn.length <= 1) {
                System.out.println(buffer.append(strIn[0]));
                return;
            }
            String[] allArray = strIn[0].split(",");
            String[] usedArray = strIn[1].split(",");
            char strAll[][] = new char[allArray.length][3];
            char strUsed[][] = new char[usedArray.length][3];
            for (int i = 0; i < allArray.length; i++) {
                strAll[i] = allArray[i].toCharArray();
            }
            for (int i = 0; i < usedArray.length; i++) {
                strUsed[i] = usedArray[i].toCharArray();
            }
            for (int i = 0; i < strUsed.length; i++) {
                if (strAll[i][0] == strUsed[i][0]) {
                    strAll[i][2] = String.valueOf(strAll[i][2] - strUsed[i][2]).toCharArray()[0];
                }
            }
            for (int i = 0; i < strAll.length; i++) {
                if (!String.valueOf(strAll[i][2]).equals("0")) {
                    buffer.append(strAll[i][0]);
                    buffer.append(strAll[i][1]);
                    buffer.append(strAll[i][2]);
                    if (i != strAll.length - 1) {
                        buffer.append(",");
                    }
                }
            }

            System.out.println(buffer);
        }
    }


    public void test1() {
        Scanner sc = new Scanner(System.in);

        StringBuffer buffer = new StringBuffer();
        String[] strNum = sc.nextLine().split(",");
        for (int i = 0; i < strNum.length; i++) {
            for (int j = 0; j < strNum.length; j++) {
                if (!strNum[i].equals(strNum[j])) {

                    char[] char_i = strNum[i].toCharArray();
                    char[] char_j = strNum[j].toCharArray();
                    int length = char_i.length > char_j.length ? char_j.length : char_i.length;
                    String temp = "";
                    if (strNum[i].substring(0, length - 1).equals(strNum[j].substring(0, length - 1))) {
                        if (strNum[i].length() > strNum[j].length()) {
                            temp = strNum[i];
                            strNum[i] = strNum[j];
                            strNum[j] = temp;
                            break;
                        }
                    } else {
                        for (int k = 0; k < length; k++) {

                            if (char_i[k] < char_j[k]) {
                                temp = strNum[i];
                                strNum[i] = strNum[j];
                                strNum[j] = temp;
                                break;
                            }
                        }
                    }

                }
            }
        }
        for (int i = strNum.length - 1; i >= 0; i--) {
            buffer.append(strNum[i]);
        }
        System.out.println(buffer);
    }

}
