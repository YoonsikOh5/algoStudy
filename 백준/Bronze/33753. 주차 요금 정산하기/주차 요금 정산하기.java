import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int T = Integer.parseInt(br.readLine());
        int res = 0;
        if(T <= 30){
            res += A;
        } else {
            res += A;
            res += ((T-30)/B)*C;
            if((T-30)%B != 0){
                res += C;
            }
        }
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
