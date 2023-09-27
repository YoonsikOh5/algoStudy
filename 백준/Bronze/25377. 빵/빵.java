import java.io.*;
import java.util.*;

public class Main {


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if(A <= B){
                min = Math.min(min, B);
            }
        }
        if(min == Integer.MAX_VALUE){
            bw.write("-1");
        } else {
            bw.write(min+"");
        }
        bw.flush();
        bw.close();
        br.close();

    }


}