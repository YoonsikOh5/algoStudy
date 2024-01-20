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

        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){
            int a = Integer.parseInt(br.readLine());
            int b = a + 1;
            int c = a % 100;
            if(b%c==0){
                bw.write("Good\n");
            } else {
                bw.write("Bye\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}