import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int t1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int h2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());
        int t2 = Integer.parseInt(st.nextToken());

        int hd1 = h2 / d1;
        int hd2 = h1 / d2;

        if(h2 % d1 != 0){
            hd1++;
        }
        if(h1 % d2 != 0){
            hd2++;
        }

        int r1 = (hd1 - 1) * t1;
        int r2 = (hd2 - 1) * t2;

        if(r1 < r2){
            bw.write("player one");
        } else if(r2 < r1){
            bw.write("player two");
        } else {
            bw.write("draw");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
