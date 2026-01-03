import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a > 1989){
                bw.write("No\n");
            } else if(a < 1989) {
                bw.write("Yes\n");
            } else {
                if(b > 2){
                    bw.write("No\n");
                } else if(b < 2){
                    bw.write("Yes\n");
                } else {
                    if(c > 27){
                        bw.write("No\n");
                    } else {
                        bw.write("Yes\n");
                    }
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
