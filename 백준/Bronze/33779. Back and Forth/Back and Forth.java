import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int len = s.length();

        int hlf = len / 2;

        boolean isP = true;
        for(int i = 0; i < hlf; i++){
            if(s.charAt(i)!=s.charAt(len-1-i)){
                isP = false;
                break;
            }
        }

        if(isP){
            bw.write("beep");
        } else {
            bw.write("boop");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
