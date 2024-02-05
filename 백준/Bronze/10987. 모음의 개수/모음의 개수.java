import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int len = s.length();
        int cnt = 0;
        for(int i = 0; i < len; i++){
            char cur = s.charAt(i);
            if(cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u'){
                cnt++;
            }
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }

}