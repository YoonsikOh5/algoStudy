import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            int len = str.length();
            for(int j = 0; j < len; j++){
                char c = str.charAt(j);
                if(c == 'A'){
                    cnt += 4;
                } else if(c == 'K'){
                    cnt += 3;
                } else if(c == 'Q'){
                    cnt += 2;
                } else if(c == 'J'){
                    cnt += 1;
                }
            }
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
