import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int scnt = 0;
        int mcnt = 0;
        int lcnt = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            char c = s.charAt(0);
            int cur = Integer.parseInt(st.nextToken());
            if(c == 'S'){
                scnt += cur;
            } else if(c == 'M'){
                mcnt += cur;
            } else if(c == 'L'){
                lcnt += cur;
            }
        }
        int res = 0;
        res += scnt / 6;
        res += mcnt / 8;
        res += lcnt / 12;
        if(scnt % 6 != 0){
            res+=1;
        }
        if(mcnt % 8 != 0){
            res+=1;
        }
        if(lcnt % 12 != 0){
            res+=1;
        }

        bw.write(res + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
