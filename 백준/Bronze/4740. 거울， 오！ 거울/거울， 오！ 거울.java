import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String s = br.readLine();
            if(s.equals("***")){
                break;
            }

            int len = s.length();
            for(int i = len-1; i >= 0; i--){
                bw.write(s.charAt(i)+"");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
