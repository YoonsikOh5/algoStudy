import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] arr = new char[10][20];

        for(int r = 0; r < 10; r++){
            for(int c = 0; c < 20; c++){
                arr[r][c] = '.';
            }
        }

        for(int i = 1; i <= N; i++){
            String s = br.readLine();
            char cr = s.charAt(0);
            int cri = cr - 'A';

            int cci = Integer.parseInt(s.substring(1));
            cci--;

            arr[cri][cci] = 'o';
        }

        for(int r = 0; r < 10; r++){
            for(int c = 0; c < 20; c++){
                bw.write(arr[r][c]+"");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
