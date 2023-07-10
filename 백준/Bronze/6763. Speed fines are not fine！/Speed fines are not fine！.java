import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sl = Integer.parseInt(br.readLine());
        int dr = Integer.parseInt(br.readLine());

        if(sl >= dr){
            bw.write("Congratulations, you are within the speed limit!");
        } else {
            int fast = dr - sl;
            int fine = 500;
            if(fast <= 20){
                fine = 100;
            } else if (fast <= 30){
                fine = 270;
            }
            bw.write("You are speeding and your fine is $"+fine+".");
        }

        bw.flush();
        bw.close();
        br.close();
    }


}