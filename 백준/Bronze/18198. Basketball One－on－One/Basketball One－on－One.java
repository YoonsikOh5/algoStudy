import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int length = s.length();
        int idx = 0;
        int[] arr = new int[2];
        boolean isD = false;
        for (int i = 0; i < length; i++) {
            char cur = s.charAt(i);
            if (i % 2 == 0) {
                if (cur == 'A') {
                    idx = 0;
                } else if (cur == 'B') {
                    idx = 1;
                }
            } else if (i % 2 == 1) {
                arr[idx] += (cur - '0');
                if (!isD) {
                    if (arr[0] == 10 && arr[1] == 10) {
                        isD = true;
                    } else {
                        if (arr[0] >= 11) {
                            bw.write("A");
                            break;
                        } else if (arr[1] >= 11) {
                            bw.write("B");
                            break;
                        }
                    }
                } else if (isD) {
                    if (arr[0] >= arr[1] + 2) {
                        bw.write("A");
                        break;
                    } else if (arr[0] + 2 <= arr[1]) {
                        bw.write("B");
                        break;
                    }
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}