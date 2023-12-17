import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int length = s.length();

        int acnt = 0;
        int bcnt = 0;
        for(int i = 0; i < length; i++){
            if(s.charAt(i)=='A'){
                acnt++;
            } else if (s.charAt(i)=='B') {
                bcnt++;
            }
        }

        bw.write(acnt+" : "+bcnt);
        bw.flush();
        bw.close();
        br.close();
    }

}