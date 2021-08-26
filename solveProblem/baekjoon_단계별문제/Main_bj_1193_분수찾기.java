import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_bj_1193_분수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int acc = 0,line = 1;
        if(num == 1) System.out.println("1/1");
        else {
            while(num > acc+line) acc += line++;
            if(line%2 == 0) System.out.println((num-acc)+"/"+(acc+line+1-num));
            else System.out.println((acc+line+1-num)+"/"+(num-acc));
        }
        br.close();
    }
}
