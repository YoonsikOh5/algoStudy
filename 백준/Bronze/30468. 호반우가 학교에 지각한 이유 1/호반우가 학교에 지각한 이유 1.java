import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;

        for(int i = 1; i <= 4; i++){
            sum += Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(st.nextToken());

        int result = (4*n)-sum;
        if(result<0){
            result = 0;
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }


}