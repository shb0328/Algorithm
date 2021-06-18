import java.util.Arrays;

public class Prgms_lv2_행렬테두리회전하기_1 {
    public static void main(String[] args) {
        int[] answer = {};
        answer = solution(6,6, new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}});
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        // board init
        int[][] board = new int[rows+1][columns+1];
        int num = 1;
        for (int r = 1; r < board.length; r++) {
            for (int c = 1; c < board[r].length; c++) {
                board[r][c] = num++;
            }
//            System.out.println(Arrays.toString(board[r])); //test
        }

        for (int i = 0; i < queries.length; i++) {
            /**
             * rotation :
             * 1. (x1,y1) ~ (x1,y2)
             * 2. (x1,y2) ~ (x2,y2)
             * 3. (x2,y2) ~ (x2,y1)
             * 4. (x2,y1) ~ (x1,y1)
             **/

            // (x1,y1), (x2,y2)
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];

            // board 에서 rotation 범위의 값을 1차원 배열로 복사
            int[] rotation = new int[2*(x2-x1) + 2*(y2-y1)];

            int idx = 0;
            int x = x1, y = y1;
            for (; y < y2; y++) rotation[idx++] = board[x][y];
            for (; x < x2; x++) rotation[idx++] = board[x][y];
            for (; y1 < y; y--) rotation[idx++] = board[x][y];
            for (; x1 < x; x--) rotation[idx++] = board[x][y];
//            System.out.println(Arrays.toString(rotation)); //test

            // rotation
            idx = 0;
            int backup = -1;
            int next = rotation[idx];
            int len = rotation.length;
            while (idx++ < len) {
                int nextIdx = (idx) % len;
                backup = rotation[nextIdx];
                rotation[nextIdx] = next;
                next = backup;
            }
//            System.out.println(Arrays.toString(rotation)); //test

            // board 에 rotation 적용
            idx = 0;
            x = x1; y = y1;
            for (; y < y2; y++) board[x][y] = rotation[idx++];
            for (; x < x2; x++) board[x][y] = rotation[idx++];
            for (; y1 < y; y--) board[x][y] = rotation[idx++];
            for (; x1 < x; x--) board[x][y] = rotation[idx++];
//            for (int r = 1; r < board.length; r++) System.out.println(Arrays.toString(board[r])); //test

            // rotation 범위 내 최소값 찾기
            Arrays.sort(rotation);
            answer[i] = rotation[0];
        }

        return answer;
    }
}
