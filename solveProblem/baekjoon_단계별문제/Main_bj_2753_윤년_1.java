import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_bj_2753_윤년_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());
        if(year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) System.out.println(1);
        else System.out.println(0);
    }
}
