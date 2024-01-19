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

        int i = Integer.parseInt(br.readLine());

        String str = br.readLine();

        char c = str.charAt(i - 1);

        String substring = str.substring(0, i - 1);

        if(c=='G'){
            bw.write(substring);
        } else {
            bw.write(str+"G");
        }


        bw.flush();
        bw.close();
        br.close();
    }

}