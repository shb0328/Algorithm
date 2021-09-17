import java.util.Arrays;

public class Prgms_위클리챌린지7_입실퇴실 {
    public static void main(String[] args) {
//        int[] result = new Solution().solution(new int[]{1,3,2},new int[]{1,2,3});
//        System.out.println(Arrays.toString(result)); // 0,1,1

        int[] result = new Solution().solution(new int[]{1,4,2,3},new int[]{2,1,3,4});
        System.out.println(Arrays.toString(result)); // 2,2,1,3

    }
}

class Solution {
    public int[] solution(int[] enter, int[] leave) {
        int n = enter.length;
        int[] answer = new int[n];
        final int ENTER = 0;
        final int LEAVE = 1;

        int[][] info = new int[n+1][2];
        for(int i = 0; i < n; ++i) info[enter[i]][ENTER] = i;
        for(int i = 0; i < n; ++i) info[leave[i]][LEAVE] = i;

        int m = info.length;
        boolean[][] meet = new boolean[m][m];
        for(int idxOfOne = 1 ; idxOfOne < m; ++idxOfOne) {
            int[] one = info[idxOfOne];
            for(int idxOfAnother = 1; idxOfAnother < m; ++idxOfAnother) {
                int[] another = info[idxOfAnother];
                if(one[ENTER] < another[ENTER] && another[LEAVE] < one[LEAVE]) {
                    meet[idxOfOne][idxOfAnother] = meet[idxOfAnother][idxOfOne] = true;
                    for(int idxOfBetween = one[ENTER]+1; idxOfBetween < another[ENTER]; ++idxOfBetween) {
                        int between = enter[idxOfBetween];
                        if(one[LEAVE] < info[between][LEAVE]) meet[idxOfOne][between] = meet[between][idxOfOne] = true;
                    }
                }
            }
        }

        for(int i = 1; i < m; ++i) {
            for(int j = 1; j < m; ++j) {
                if(meet[i][j]) answer[i-1]++;
            }
        }
        return answer;
    }
}