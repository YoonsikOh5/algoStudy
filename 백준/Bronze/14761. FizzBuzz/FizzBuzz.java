import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++){
            if(i % X == 0 && i % Y == 0){
                bw.write("FizzBuzz\n");
            } else if(i % X == 0){
                bw.write("Fizz\n");
            } else if(i % Y == 0){
                bw.write("Buzz\n");
            } else {
                bw.write(i+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
