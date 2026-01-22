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
            boolean isT = true;
            for(int j = 1; j <= 10; j++){
                int cur = Integer.parseInt(st.nextToken());
                int tmp = ((j - 1) % 5) + 1;
                if(cur != tmp){
                    isT = false;
                }
            }
            if (isT){
                bw.write(i+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
