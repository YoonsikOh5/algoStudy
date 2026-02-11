import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int i = x % 3600;
        int i1 = 3600 - i;
        int i2 = i1 / 60;
        if(i1 % 60 != 0){
            i2 += 1;
        }
        bw.write(i2+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
