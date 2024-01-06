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

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(br.readLine());
            if(a%2==0){
                bw.write(a+" is even\n");
            } else {
                bw.write(a+" is odd\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}