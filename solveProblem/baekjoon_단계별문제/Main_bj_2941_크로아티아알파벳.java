import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_bj_2941_크로아티아알파벳 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(
            br.readLine().replaceAll("c=", "x")
            .replaceAll("c-", "x")
            .replaceAll("dz=", "x")
            .replaceAll("d-", "x")
            .replaceAll("lj", "x")
            .replaceAll("nj", "x")
            .replaceAll("s=", "x")
            .replaceAll("z=", "x")
            .length()
        );
        br.close();
    }
}
