import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            int blank = n - i;
            int star = i;
            for (int b = 1; b <= blank; b++) {
                bw.write(" ");
            }
            for (int s = 1; s <= star; s++) {
                bw.write("*");
            }
            bw.write("\n");
        }

        for (int i = n - 1; i >= 1; i--) {
            int blank = n - i;
            int star = i;
            for (int b = 1; b <= blank; b++) {
                bw.write(" ");
            }
            for (int s = 1; s <= star; s++) {
                bw.write("*");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}