import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){
            bw.write(i+" ");
            if(i%6==0 || i==N){
                bw.write("Go! ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }


}