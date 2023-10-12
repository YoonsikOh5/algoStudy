import java.io.*;
import java.util.*;

public class Main {


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] levels = new int[N];

        for (int i = 0; i < N; i++) {
            levels[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
           if(levels[i]==300){
               bw.write("1 ");
           } else if(levels[i]>=275){
               bw.write("2 ");
           } else if(levels[i]>=250){
               bw.write("3 ");
           } else {
               bw.write("4 ");
           }
        }

        bw.flush();
        bw.close();
        br.close();

    }


}