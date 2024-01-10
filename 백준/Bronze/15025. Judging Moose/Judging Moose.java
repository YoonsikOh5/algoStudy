import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        if(l==r && l == 0){
             bw.write("Not a moose");
        } else if (l == r) {
            bw.write("Even " + (l * 2));
        } else {
            if (l > r) {
                bw.write("Odd " + (l * 2));
            } else {
                bw.write("Odd " + (r * 2));
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }


}