import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int b = 0;
        int c = 0;
        int length = s.length();
        for(int i = 0; i < length; i++){
            if(s.charAt(i)=='B'){
                b++;
            } else if (s.charAt(i)=='C') {
                c++;
            }
        }

        bw.write(b/2+c/2+"");
        bw.flush();
        bw.close();
        br.close();
    }

}