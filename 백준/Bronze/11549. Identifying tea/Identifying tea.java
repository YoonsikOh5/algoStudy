import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;
        for(int i = 1; i <= 5; i++){
            int i1 = Integer.parseInt(st.nextToken());
            if(i1==T) cnt++;
        }

        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }

}