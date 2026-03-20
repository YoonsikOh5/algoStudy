import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(br.readLine().trim());

        int[] nums = new int[] {
            100 * a + 10 * b + c,
            100 * a + 10 * c + b,
            100 * b + 10 * a + c,
            100 * b + 10 * c + a,
            100 * c + 10 * a + b,
            100 * c + 10 * b + a
        };

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                bw.write(String.valueOf(i + 1));
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
