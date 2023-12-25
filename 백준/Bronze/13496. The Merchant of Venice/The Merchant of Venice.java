import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int sd = s*d;
            int sum = 0;
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int di = Integer.parseInt(st.nextToken());
                int vi = Integer.parseInt(st.nextToken());
                if(sd >= di){
                    sum += vi;
                }
            }

            bw.write("Data Set "+t+":\n");
            bw.write(sum+"\n");
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}