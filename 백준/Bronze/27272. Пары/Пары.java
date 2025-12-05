import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] arr = new int[4];

        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        arr[3] = d;

        Arrays.sort(arr);

        int res = arr[0] * arr[1] + arr[2] * arr[3];

        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
