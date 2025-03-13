import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int cnt = 0;
        ArrayList ls = new ArrayList();
        for(int i = 1; i <= N; i++){
            if((i%10 != K%10) && (i%10 != (2*K)%10)){
                cnt++;
                ls.add(i);
            }
        }

        bw.write(cnt+"\n");

        for(int i = 0; i < ls.size(); i++){
            bw.write(ls.get(i)+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
