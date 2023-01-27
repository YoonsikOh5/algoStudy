import java.io.*;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(br.readLine());

        int result = L / 5;

        if(L%5 > 0){
            result++;
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();

    }

}
