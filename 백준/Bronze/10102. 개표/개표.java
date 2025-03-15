import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int A = 0;
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur == 'A'){
                A++;
            } else if(cur == 'B'){
                A--;
            }
        }
        if(A > 0){
            bw.write("A");
        } else if(A == 0){
            bw.write("Tie");
        } else if(A < 0){
            bw.write("B");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
