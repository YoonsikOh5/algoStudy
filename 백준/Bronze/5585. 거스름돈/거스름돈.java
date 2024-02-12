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

        int remain = 1000 - n;

        int cnt = 0;

        int[] arr = {500, 100, 50, 10, 5, 1};

        for (int i = 0; i < 6; i++) {
            cnt += remain / arr[i];
            remain = remain % arr[i];
        }

        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }

}