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

        int cur = Integer.parseInt(s);

        boolean findT = false;
        for(int i = cur+1; i <= 9999; i++){
            int left = i / 100;
            int right = i % 100;
            int sum = left + right;
            if(i==(sum*sum)){
                findT = true;
                bw.write(i+"");
                break;
            }
        }

        if(!findT){
            bw.write("-1");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
