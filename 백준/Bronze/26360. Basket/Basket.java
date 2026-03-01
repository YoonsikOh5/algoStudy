import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        int res = 0;
        if(B == 1){
            if(A == 1){
                res += X;
                int ex = Integer.parseInt(br.readLine());
                if(ex == 1){
                    res += 1;
                }
            } else {
                for(int i = 1; i <= X; i++){
                    int cur = Integer.parseInt(br.readLine());
                    if(cur == 1){
                        res += 1;
                    }
                }
            }
        } else {
            if(A == 1){
                res += X;
            }
        }

        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
