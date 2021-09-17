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

        int[][] info = new int[n+1][2];
        for(int i = 0; i < n; ++i) info[enter[i]][0] = i;
        for(int i = 0; i < n; ++i) info[leave[i]][1] = i;

        int m = info.length;
        boolean[][] meet = new boolean[m][m];
        for(int idxOfOne = 1 ; idxOfOne < m; ++idxOfOne) {
            int[] one = info[idxOfOne];
//            for(int idxOfAnother = idxOfOne+1; idxOfAnother < m; ++idxOfAnother) {
            for(int idxOfAnother = 1; idxOfAnother < m; ++idxOfAnother) {
                int[] another = info[idxOfAnother];
                if(one[0] < another[0] && another[1] < one[1]) {
                    meet[idxOfOne][idxOfAnother] = meet[idxOfAnother][idxOfOne] = true;
                    for(int idxOfBetween = one[0]+1; idxOfBetween < another[0]; ++idxOfBetween) {
                        int between = enter[idxOfBetween];
                        if(one[1] < info[between][1]) meet[idxOfOne][between] = meet[between][idxOfOne] = true;
                    }
                }
            }
        }

        int[] answer = new int[n];
        for(int i = 1; i < m; ++i) {
            for(int j = 1; j < m; ++j) {
                if(meet[i][j]) answer[i-1]++;
            }
        }
        return answer;
    }
}