import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        for(int i = 1; i <= K; i++){
            int H = Integer.parseInt(br.readLine());
            String str = br.readLine();
            int len = str.length();
            for(int j = 0; j < len; j++){
                char cur = str.charAt(j);
                if(cur == 'c'){
                    H++;
                } else if(cur == 'b'){
                    H--;
                }
            }

            bw.write("Data Set "+i+":\n"+H+"\n\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
