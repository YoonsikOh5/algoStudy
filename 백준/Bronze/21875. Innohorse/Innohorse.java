import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        char r1 = s1.charAt(0);
        char r2 = s2.charAt(0);
        char c1 = s1.charAt(1);
        char c2 = s2.charAt(1);

        int r11 = r1 - '0';
        int r22 = r2 - '0';
        int x = Math.abs(r11 - r22);
        int y = Math.abs(c1 - c2);
        if(x > y){
            bw.write(y+" "+x);
        } else {
            bw.write(x+" "+y);
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
