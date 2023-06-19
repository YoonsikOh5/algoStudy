import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;

    public static int[] getPi(int N) {

        int[] pi = new int[N];

        int j = 0;

        for (int i = 1; i < N; i++) {
            while (j > 0 && arr[i] != arr[j]) {
                j = pi[j - 1];
            }
            if (arr[i] == arr[j]) {
                pi[i] = ++j;
            }
        }

        return pi;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];

        // 일반적인 kmp는 앞에서부터 1, 12, 123, 1234 이렇게 비교해가는거면
        // 여기서는 뒤에서부터 4, 34, 234, 1234 이렇게 비교해가면서 pi 배열을 만듬
        // 그러면 앞에서부터 자르면서 앞뒤계수를 계산하게 되는 것과 같아짐
        // pi 배열 돌면서 최댓값 찾고 최댓값의 갯수 찾으면 끝
        for (int i = N - 1; i >= 0; i--) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] pi = getPi(N);

        int maxcnt = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (pi[i] > max) {
                max = pi[i];
                maxcnt = 1;
            } else if (pi[i] == max) {
                maxcnt++;
            }
        }

        if (max == 0) {
            bw.write("-1");
        } else {
            bw.write(max + " " + maxcnt);
        }
        bw.flush();
        bw.close();
        br.close();
    }


}