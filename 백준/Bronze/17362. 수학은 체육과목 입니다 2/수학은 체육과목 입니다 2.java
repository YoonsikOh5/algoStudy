import java.io.*;
import java.util.*;

public class Main {


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        
        int div = (n-1) / 4;
        int rem = (n-1) % 4;
        int result = -1;
        if(div % 2 == 0){
            switch (rem){
                case 0 : result = 1;
                break;
                case 1 : result = 2;
                break;
                case 2 : result = 3;
                break;
                case 3 : result = 4;
                break;
            }
        } else if(div % 2 == 1){
            switch (rem){
                case 0 : result = 5;
                    break;
                case 1 : result = 4;
                    break;
                case 2 : result = 3;
                    break;
                case 3 : result = 2;
                    break;
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }

}