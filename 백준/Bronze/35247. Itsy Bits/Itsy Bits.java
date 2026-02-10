import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long l = Long.parseLong(br.readLine());
        int cnt = 0;
        while (l > 0){
            cnt++;
            l /= 2;
        }
        int res = 1;
        int rescnt = 0;
        while (true){
            if(cnt <= res){
                break;
            }
            rescnt++;
            res*=2;
        }
        if(res==1){
            bw.write(res+" bit");
        } else {
            bw.write(res+" bits");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
