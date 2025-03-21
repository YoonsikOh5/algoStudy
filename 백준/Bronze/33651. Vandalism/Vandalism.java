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

        int len = s.length();

        int[] arr = new int[4];

        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if(c == 'U'){
                arr[0] = 1;
            } else if(c == 'A'){
                arr[1] = 1;
            } else if(c == 'P'){
                arr[2] = 1;
            } else if(c=='C'){
                arr[3] = 1;
            }
        }

        if(arr[0] == 0){
            bw.write("U");
        }
        if(arr[1] == 0){
            bw.write("A");
        }
        if(arr[2] == 0){
            bw.write("P");
        }
        if(arr[3] == 0){
            bw.write("C");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
