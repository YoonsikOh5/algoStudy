import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0){
                break;
            }

            if((a+b) == 13){
               bw.write("Never speak again.\n");
            } else if(a > b){
                bw.write("To the convention.\n");
            } else if(a < b){
                bw.write("Left beehind.\n");
            } else if(a == b){
                bw.write("Undecided.\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
