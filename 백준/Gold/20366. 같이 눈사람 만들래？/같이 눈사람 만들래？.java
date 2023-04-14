import java.io.*;
import java.util.*;

public class Main {

    static long elsaTop;
    static long elsaBottom;
    static long annaTop;
    static long annaBottom;


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long mindifference = Long.MAX_VALUE;

        outfor:
        for (int i = 0; i < N; i++) {
            int start = i + 3;
            for (int j = start; j < N; j++) {
                elsaTop = arr[i];
                elsaBottom = arr[j];
                long elsaTotal = elsaTop + elsaBottom;
                int aleft = i + 1;
                int aright = j - 1;
                while (aleft < aright) {
                    annaTop = arr[aleft];
                    annaBottom = arr[aright];
                    long difference = elsaTotal - (annaTop + annaBottom);
                    long difAbs = Math.abs(difference);
                    mindifference = Math.min(mindifference, difAbs);
                    if (difference < 0) {
                        aright -= 1;
                    } else if (difference > 0) {
                        aleft += 1;
                    } else if (difference == 0) {
                        break outfor;
                    }
                }
            }
        }

        bw.write(mindifference + "");
        bw.flush();
        bw.close();
        br.close();
    }


}