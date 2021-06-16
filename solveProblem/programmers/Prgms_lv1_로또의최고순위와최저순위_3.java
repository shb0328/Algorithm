import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Prgms_lv1_로또의최고순위와최저순위_3 {
    public static void main(String[] args) {
        int[] answer = {};
//        answer = solution(new int[]{44, 1, 0, 0, 31, 25},new int[]{31, 10, 45, 1, 6, 19});
//        answer = solution(new int[]{0, 0, 0, 0, 0, 0},new int[]{31, 10, 45, 1, 6, 19});
//        answer = solution(new int[]{2, 11, 15, 16, 17, 18},new int[]{31, 10, 45, 1, 6, 19});
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        /**
         1. lottos 에서 0 개수를 알아낸다. (int zeroCnt)
         2. lottos 에서 0을 제외하고 win_nums 와 곂치는 숫자의 개수를 알아낸다. (int winCnt)
         3. zeroCnt와 winCnt를 이용하여 등수를 알아낸다.
         **/

        int zeroCnt = 0;
        Set<Integer> set = new HashSet<>();
        for(int n : lottos) {
            set.add(n);
            if(0 == n)  zeroCnt++;
        }

        int winCnt = 0;
        for(int n : win_nums) {
            if(set.contains(n)) winCnt++;
        }

        int[] rank = new int[]{6,6,5,4,3,2,1};

        answer[0] = rank[zeroCnt + winCnt];
        answer[1] = rank[winCnt];

        return answer;
    }
}
