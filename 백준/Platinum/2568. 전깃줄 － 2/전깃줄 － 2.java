import java.io.*;
import java.util.*;

public class Main {

    static class Line implements Comparable<Line> {
        int left;
        int right;

        public Line(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Line o) {
            return this.left - o.left;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Line> pq = new PriorityQueue<>();
        int maxLeft = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            Line line = new Line(left, right);
            if (left > maxLeft) {
                maxLeft = left;
            }
            pq.offer(line);
        }
        int[] arr = new int[maxLeft + 1];
        while (pq.size() > 0) {
            Line poll = pq.poll();
            arr[poll.left] = poll.right;
        }

        int[] dpLis = new int[maxLeft + 1];
        int[] dp = new int[maxLeft + 1];
        int size = 0;
        int mIdx = 0;
        for (int i = 1; i <= maxLeft; i++) {
            int cur = arr[i];
            if (cur == 0) {
                continue;
            }
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
        HashSet<Integer> hs = new HashSet<>();
        hs.add(mIdx);
        for (int i = mIdx - 1; i >= 0; i--) {
            if (arr[i] != 0 && arr[i] < arr[mIdx] && dp[i] + 1 == dp[mIdx]) {
                mIdx = i;
                hs.add(i);
            }
        }
        bw.write((N - size) + "\n");

        for(int i = 0; i <= maxLeft; i++){
            if(arr[i]==0 || hs.contains(i)){
                continue;
            }
            bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}