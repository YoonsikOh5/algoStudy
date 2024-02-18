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

        int arr[] = {12, 11, 11, 10, 9, 9, 9, 8, 7, 6, 6};
        int arr2[] = {1600, 894, 1327, 1311, 1004, 1178, 1357, 837, 1055, 556, 773};
        bw.write(arr[n - 1] + " " + arr2[n - 1]);
        bw.flush();
        bw.close();
        br.close();
    }

}