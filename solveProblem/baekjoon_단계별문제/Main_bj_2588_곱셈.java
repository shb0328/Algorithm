import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_bj_2588_곱셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(br.readLine());
        String num2_str = br.readLine();
        int num2 = Integer.parseInt(num2_str);
        char[] num2_charArray = num2_str.toCharArray();

        for (int i = num2_charArray.length - 1; i >= 0; --i) System.out.println(num1 * (num2_charArray[i]-'0'));
        System.out.println(num1 * num2);

        /**
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int a = Integer.parseInt(br.readLine());
         int b = Integer.parseInt(br.readLine());
         System.out.println(a*(b%10));
         System.out.println(a*(b%100/10));
         System.out.println(a*(b/100));
         System.out.println(a*b);
         */
    }
}
