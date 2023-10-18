import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        long sum = 0;
        long xor = 0;
        for(int i = 1; i <= M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if(cmd==1){
                int num = Integer.parseInt(st.nextToken());
                sum += num;
                xor ^= num;
            } else if(cmd==2){
                int num = Integer.parseInt(st.nextToken());
                sum -= num;
                xor ^= num;
            } else if(cmd==3){
                bw.write(sum+"\n");
            } else if(cmd==4){
                bw.write(xor+"\n");
            }
         }

        bw.flush();
        bw.close();
        br.close();

    }

}