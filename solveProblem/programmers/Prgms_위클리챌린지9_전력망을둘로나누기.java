public class Prgms_위클리챌린지9_전력망을둘로나누기 {
    public static void main(String[] args) {
        int result = new Solution().solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}});
        System.out.println(result);
    }
}

class Solution {
    public int solution(int n, int[][] wires) {
        p = new int[n+1];
        int min = 100;

        for (int except = 0; except < wires.length; ++except) {
            initP();
            splitTree(wires, except);
            min = Math.min(min, getDiff(n));
        }
        return min;
    }

    private void initP() {
        for(int i = 1; i < p.length; ++i) p[i] = i;
    }

    private void splitTree(int[][] wires, int except) {

        for(int i = 0; i < wires.length; ++i) {
            if(i == except) continue;
            union(wires[i][0], wires[i][1]);
        }
    }

    private int getDiff(int n){
        int cnt = 0;
        for(int i = 1; i < p.length; ++i) {
            if(find(i) == 1) cnt++;
        }
        return Math.abs((n-cnt)-cnt);
    }

    private int[] p;

    private void union(int v1, int v2) {
        int x1 = find(v1);
        int x2 = find(v2);

        if(x1 == x2) return;

        if(x1 < x2) p[x2] = x1;
        else p[x1] = x2;
    }

    private int find(int v) {
        if(p[v] == v) return v;
        return p[v] = find(p[v]);
    }
}