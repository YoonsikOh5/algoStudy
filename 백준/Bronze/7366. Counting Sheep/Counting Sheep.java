import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){
            int C = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = 0;
            for(int j = 0; j < C; j++){
                String s = st.nextToken();
                if(s.equals("sheep")){
                    cnt++;
                }
            }
            bw.write("Case "+i+": This list contains "+cnt+" sheep.\n\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
