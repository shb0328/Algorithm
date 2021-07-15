import java.util.*;

public class Prgms_lv2_거리두기확인하기 {
    class Solution {
        private ArrayList<int[]> pList;
        private char[][] room;

        public int[] solution(String[][] places) {
            int n = places.length;
            int[] answer = new int[n];
            Arrays.fill(answer,1);

            for(int i = 0; i < n; i++) {
                int m = places[i].length;
                room = new char[m][];
                for(int j = 0; j < m; j++) room[j] = places[i][j].toCharArray();
                pList = new ArrayList<>();
                findP();
                if(pList.isEmpty()) continue;
                answer[i] = check();
            }

            return answer;
        }

        private void findP() {
            for(int i = 0; i < room.length; i++) {
                for(int j = 0; j < room[i].length; j++) {
                    if('P' != room[i][j]) continue;
                    pList.add(new int[]{i,j});
                }
            }
        }

        private int check() {
            int res = 1;
            for(int i = 0; i < pList.size(); i++) {
                int[] p1 = pList.get(i);
                for(int j = i+1; j < pList.size(); j++) {
                    int[] p2 = pList.get(j);
                    if(2 < getDistance(p1, p2)) continue;
                    if(hasX(p1, p2)) continue;
                    res = 0;
                    break;
                }

            }
            return res;
        }

        private int getDistance(int[] p1, int[] p2) {
            return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
        }

        private boolean hasX(int[] p1, int[] p2) {
            int x1 = p1[1];
            int x2 = p2[1];
            int y1 = p1[0];
            int y2 = p2[0];

            if(y1 == y2) {
                if('X' == room[y1][(x1 + x2)/2]) return true;
                return false;
            }
            else if(x1 == x2) {
                if('X' == room[(y1 + y2)/2][x1]) return true;
                return false;
            } else {
                if(('X' == room[y1][x2])&&('X' == room[y2][x1])) return true;
                return false;
            }
        }
    }
}
