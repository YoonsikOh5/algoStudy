import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        while(!(M==0 && W==0)){

            bw.write(M+W+"\n");

            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
        }



        bw.flush();
        bw.close();
        br.close();
    }

}
