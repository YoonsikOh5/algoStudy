import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cur = a;
            cur %= 10;
            for(int j = 1; j < b; j++){
                cur *= a;
                cur %= 10;
            }
            if(cur == 0){
                cur = 10;
            }
            bw.write(cur+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
