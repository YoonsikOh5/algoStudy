import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N % 2 == 1){
            bw.write("No");
        } else {
            String cur = br.readLine();
            int n2 = N / 2;
            boolean isT = true;
            for(int i = 0; i < n2; i++){
                boolean b = cur.charAt(i) == cur.charAt(n2 + i);
                if(!b){
                    isT = false;
                    break;
                }
            }
            if(isT){
                bw.write("Yes");
            } else {
                bw.write("No");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
