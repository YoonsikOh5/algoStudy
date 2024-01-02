import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int c = b + 60;

        if(a <= c){
            bw.write(a*1500+"");
        } else {
            int d = a - c;
            bw.write(c*1500+d*3000+"");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}