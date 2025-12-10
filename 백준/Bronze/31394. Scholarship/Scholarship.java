import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean isN = false;
        boolean isP = true;
        boolean isH = false;

        int sum = 0;
        for(int i = 0; i < N; i++){
            int cur = Integer.parseInt(br.readLine());
            if(cur == 3){
                isN = true;
                break;
            }
            if(cur == 4){
                isP = false;
            }
            sum += cur;
        }

        if(isN){
            bw.write("None");
        } else if(isP){
            bw.write("Named");
        } else {
            double v = (double) sum / N;
            if (v >= 4.5) {
                isH = true;
            }
            if (isH) {
                bw.write("High");
            } else {
                bw.write("Common");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
