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
        int cnt = 5000;
        while (st.hasMoreTokens()){
            int cur = Integer.parseInt(st.nextToken());
            if(cur == 1){
                cnt -= 500;
            } else if(cur == 2){
                cnt -= 800;
            } else if(cur == 3){
                cnt -= 1000;
            }
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
