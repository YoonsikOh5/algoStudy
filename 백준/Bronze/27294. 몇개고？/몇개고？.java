import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int sushirice = 280;

        if(T >= 12 && T <= 16 && S == 0){
            sushirice = 320;
        }

        bw.write(sushirice+"");
        bw.flush();
        bw.close();
        br.close();

    }




}
