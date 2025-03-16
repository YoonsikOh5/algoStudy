import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int length = s.length();

        int cnt = 0;
        for(int i = 0; i < length; i++){
            char c = s.charAt(i);

            if(c == 'A'||c == 'a'||c == 'b'||c == 'D'||c == 'd'||c == 'e'||c == 'g'||c == 'O'||c == 'o'||c == 'P'||c == 'p'||c == 'Q'||c == 'q'||c == 'R'||c == '@'){
                cnt++;
            } else if(c == 'B'){
                cnt+=2;
            }
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
