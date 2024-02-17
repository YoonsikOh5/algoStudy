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
            int div = a / 5;
            int rem = a % 5;
            for(int j = 1; j <= div; j++){
                bw.write("++++ ");
            }
            for(int k = 1; k <= rem; k++){
                bw.write("|");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}