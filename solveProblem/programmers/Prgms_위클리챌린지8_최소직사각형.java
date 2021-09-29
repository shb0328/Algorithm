public class Prgms_위클리챌린지8_최소직사각형 {
    public static void main(String[] args) {
        int result = new Solution().solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}});
        System.out.println(result); //4000
    }
}

class Solution {
    public int solution(int[][] sizes) {
        int width = 0;
        int height = 0;

        for (int i = 0; i < sizes.length; ++i) {
            int w = sizes[i][0];
            int h = sizes[i][1];
            if( w > h) {
                width = Math.max(width, w);
                height = Math.max(height, h);
            } else {
                width = Math.max(width, h);
                height = Math.max(height, w);
            }
        }
        return width * height;
    }
}