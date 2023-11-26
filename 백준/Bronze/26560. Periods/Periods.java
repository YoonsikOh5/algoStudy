import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            String cur = br.readLine();
            boolean isEnd = cur.endsWith(".");
            if(isEnd){
                bw.write(cur+"\n");
            } else {
                bw.write(cur+".\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }


}