import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cur = Integer.parseInt(br.readLine());
        int result = 0;
        while (cur!=-1){
            result+=cur;
            cur = Integer.parseInt(br.readLine());
        }
        
        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }

}