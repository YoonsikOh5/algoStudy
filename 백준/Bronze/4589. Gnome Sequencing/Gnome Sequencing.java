import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        bw.write("Gnomes:\n");
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            boolean isOrdered = false;
            if(a <= b && b <= c){
                isOrdered = true;
            } else if(c <= b && b <= a){
                isOrdered = true;
            }
            if(isOrdered){
                bw.write("Ordered\n");
            } else {
                bw.write("Unordered\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }




}