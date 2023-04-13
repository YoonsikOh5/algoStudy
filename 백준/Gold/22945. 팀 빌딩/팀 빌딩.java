import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;

        int maxVal = 0;
        while (left < right) {
            int min = Math.min(arr[left], arr[right]);
            int result = (right - left - 1) * min;
            maxVal = Math.max(maxVal, result);

            if (min == arr[left]) {
                left = left + 1;
            } else if (min == arr[right]) {
                right = right - 1;
            }
        }

        bw.write(maxVal + "");
        bw.flush();
        bw.close();
        br.close();
    }


}