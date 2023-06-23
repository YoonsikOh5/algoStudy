import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dpLis = new int[N + 1];
        int[] dp = new int[N];
        int size = 0;
        int mIdx = 0;
        for (int i = 0; i < N; i++) {
            int cur = arr[i];
            int index = Arrays.binarySearch(dpLis, 0, size, cur);
            if (index >= 0) {
                dp[i] = index;
                continue;
            }
            int inputIndex = Math.abs(index + 1);
            if (inputIndex == size) {
                dpLis[inputIndex] = cur;
                dp[i] = inputIndex;
                mIdx = i;
                size++;
            } else {
                dpLis[inputIndex] = cur;
                dp[i] = inputIndex;
            }
        }
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(arr[mIdx]);
        for (int i = mIdx-1; i >= 0; i--) {
            if (arr[i] < arr[mIdx] && dp[i] + 1 == dp[mIdx]) {
                mIdx = i;
                stack.push(arr[i]);
            }
        }
        bw.write(size + "\n");
        while (stack.size()>0){
            bw.write(stack.pop()+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}