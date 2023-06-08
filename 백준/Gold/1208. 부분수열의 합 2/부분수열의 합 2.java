import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int N, S;
    static int sum;
    static int[] arr;
    static List<Long> leftLs, rightLs;
    static long count;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            arr[i] = cur;
        }
        leftLs = new ArrayList<Long>();
        rightLs = new ArrayList<Long>();
        // 왼쪽 리스트랑 오른쪽 리스트 나눠서 넣기
        setLeftArr(0, N / 2, 0);
        setRightArr(N / 2, N, 0);

        leftLs.sort(null);
        rightLs.sort(null);

        count = getCnt();

        // S가 0인 경우 두개 다 안고르는 경우가 하나 들어가버려서 1 빼줘야됨
        if(S==0){
            count--;
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static long getCnt() {
        int left = 0;
        int right = rightLs.size() - 1;
        long cnt = 0;

        while (left < leftLs.size() && right >= 0) {
            long l = leftLs.get(left);
            long r = rightLs.get(right);
            long cur = l + r;

            if (cur == S) {
                long lcnt = 0;
                while (left < leftLs.size() && leftLs.get(left) == l) {
                    left++;
                    lcnt++;
                }
                long rcnt = 0;
                while (right >= 0 && rightLs.get(right) == r) {
                    right--;
                    rcnt++;
                }
                cnt += lcnt * rcnt;
            } else if (cur < S) {
                left++;
            } else if (cur > S) {
                right--;
            }
        }

        return cnt;
    }

    private static void setLeftArr(int idx, int end, long sum) {
        if (idx == end) {
            leftLs.add(sum);
            return;
        }
        setLeftArr(idx + 1, end, sum + arr[idx]);
        setLeftArr(idx + 1, end, sum);
    }

    private static void setRightArr(int idx, int end, long sum) {
        if (idx == end) {
            rightLs.add(sum);
            return;
        }
        setRightArr(idx + 1, end, sum + arr[idx]);
        setRightArr(idx + 1, end, sum);
    }


}