import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int idx = 0;
        for(int i = 1; i <= N; i++){
            int cur = Integer.parseInt(br.readLine());
            if(idx == 0){
                idx = cur;
            } else{
                if(cur % idx == 0){
                    bw.write(cur+"\n");
                    idx = 0;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
