import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i = 0; i <= 99; i++){
            for(int j = 0; j <= 99; j++){
                int cur = N - i - j;
                if(cur==0){
                    cnt++;
                }
            }
        }

        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
