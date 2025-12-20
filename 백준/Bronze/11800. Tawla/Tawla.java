import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = {"", "Yakk", "Doh", "Seh", "Ghar", "Bang", "Sheesh"};
        String[] sarr = {"", "Habb Yakk", "Dobara", "Dousa", "Dorgy", "Dabash", "Dosh"};

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write("Case " + i + ": ");
            if (a == b) {
                bw.write(sarr[a] + "\n");
            } else {
                if (a > b) {
                    if (a == 6 && b == 5) {
                        bw.write("Sheesh Beesh\n");
                    } else {
                        bw.write(arr[a] + " " + arr[b] + "\n");
                    }
                } else {
                    if (a == 5 && b == 6) {
                        bw.write("Sheesh Beesh\n");
                    } else {
                        bw.write(arr[b] + " " + arr[a] + "\n");
                    }
                }
            }

        }


        bw.flush();
        bw.close();
        br.close();
    }

}
