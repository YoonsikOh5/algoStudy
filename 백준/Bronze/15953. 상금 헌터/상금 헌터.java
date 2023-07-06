import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int T = Integer.parseInt(br.readLine());


        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int sum = 0;
            if(a == 1){
                sum += 500;
            } else if( a >= 2 && a <= 3){
                sum += 300;
            } else if( a >= 4 && a <= 6){
                sum += 200;
            } else if (a >= 7 && a <= 10) {
                sum += 50;
            } else if (a >= 11 && a <= 15) {
                sum += 30;
            } else if (a >= 16 && a <= 21) {
                sum += 10;
            }

            if(b == 1){
                sum += 512;
            } else if( b >= 2 && b <= 3){
                sum += 256;
            } else if( b >= 4 && b <= 7){
                sum += 128;
            } else if (b >= 8 && b <= 15) {
                sum += 64;
            } else if (b >= 16 && b <= 31) {
                sum += 32;
            }


            bw.write(sum*10000+"\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }


}