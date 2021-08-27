import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_bj_1157_단어공부 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word = br.readLine().toUpperCase().toCharArray(); // 1000000
        int[] count = new int['Z'-'A'+1];
        for(char c : word) count[c-'A']++;

        char answer = 0;
        int max = -1;
        for(int i = 0; i < count.length; ++i) {
            if(count[i] > max) {
                answer = (char)('A'+i);
                max = count[i];
            }
            else if(count[i] == max) answer = '?';
        }
        System.out.println(answer);

        br.close();
    }
}
