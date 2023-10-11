import java.io.*;
import java.util.*;

public class Main {


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        if(A >= 1000){
            if(B>=8000 || C >= 260){
                bw.write("Very Good");
            } else {
                bw.write("Good");
            }
        } else {
            bw.write("Bad");
        }
        bw.flush();
        bw.close();
        br.close();

    }


}