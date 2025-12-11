import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long AA = Long.parseLong(st.nextToken());
        long BB = Long.parseLong(st.nextToken());
        long CC = Long.parseLong(st.nextToken());

        long[] arr1 = new long[3];
        arr1[0] = A;
        arr1[1] = B;
        arr1[2] = C;
        long[] arr2 = new long[3];
        arr2[0] = AA;
        arr2[1] = BB;
        arr2[2] = CC;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        long sum = 0;
        for(int i = 0; i < 3; i++){
            long cur = arr1[i] * arr2[i];
            sum += cur;
        }

        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
