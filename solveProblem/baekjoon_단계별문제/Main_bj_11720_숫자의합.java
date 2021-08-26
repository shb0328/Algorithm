import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_bj_11720_숫자의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        char[] numbers = br.readLine().toCharArray();
        int sum = 0;
        for(char n : numbers) sum += n - '0';
        System.out.println(sum);
        br.close();
    }
}