import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        for(int i = 0; i < 5; i++){
            int cur = Integer.parseInt(st.nextToken());
            if(cur%10==N) result++;
        }
        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();

    }


}