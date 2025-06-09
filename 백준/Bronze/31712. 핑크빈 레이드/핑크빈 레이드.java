import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int cu = Integer.parseInt(st.nextToken());
        int du = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int cd = Integer.parseInt(st.nextToken());
        int dd = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int cp = Integer.parseInt(st.nextToken());
        int dp = Integer.parseInt(st.nextToken());

        int H = Integer.parseInt(br.readLine());

        int time = 0;

        while (true){

            if(time % cu == 0){
                H -= du;
            }
            if(time % cd == 0){
                H -= dd;
            }
            if(time % cp == 0){
                H -= dp;
            }

            if(H <= 0){
                bw.write(time+"");
                break;
            }

            time++;
        }


        bw.flush();
        bw.close();
        br.close();
    }

}
