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

        int sumOdd = 0;
        int minOdd = Integer.MAX_VALUE;

        for(int i = 0; i < 7; i++){
            int cur = Integer.parseInt(br.readLine());
            if(cur % 2 == 1){
                sumOdd += cur;
                minOdd = Math.min(cur,minOdd);
            }
        }

        if(minOdd==Integer.MAX_VALUE){
            bw.write(-1+"");
        } else {
            bw.write(sumOdd+"\n"+minOdd);
        }
        bw.flush();
        bw.close();
        br.close();
    }

}