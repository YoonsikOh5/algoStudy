import java.io.*;
import java.util.*;

public class Main {


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int length = str.length();
        int cnt = 0;

        for(int i = 0; i < length-3; i++){
            StringBuilder sb = new StringBuilder();
            for(int d = i; d < i+4; d++){
                sb.append(str.charAt(d));
            }
            String string = sb.toString();
            if(string.equals("DKSH")) cnt++;
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }


}