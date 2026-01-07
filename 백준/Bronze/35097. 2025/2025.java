import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0){
                break;
            }
            int sum = 0;
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    sum += i*j;
                }
            }
            bw.write(sum+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
