import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            char cha = st.nextToken().charAt(0);
            int idx = cha - 'A';
            for(int j = 0; j < cur; j++){
                int cc = idx + j;
                cc = cc % 26;
                char res = (char) (cc + 'A');
                for(int k = 0; k < j+1; k++){
                    bw.write(res+"");
                }
                bw.write("\n");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
