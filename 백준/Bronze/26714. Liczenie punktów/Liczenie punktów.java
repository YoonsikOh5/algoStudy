import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int c = N / 10;

        String s = br.readLine();
        int len = s.length();
        int res = 0;
        for(int i = 0; i < 10; i++){
            boolean isT = true;
            for(int j = 0; j < c; j++){
                int cur = i*(c)+j;
                char c1 = s.charAt(cur);
                if(c1 == 'N'){
                    isT = false;
                    break;
                }
            }
            if(isT) res++;
        }

        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
