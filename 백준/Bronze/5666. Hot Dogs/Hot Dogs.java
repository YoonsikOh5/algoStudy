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

        String input = "";
        while ((input = br.readLine()) != null && !(input.isEmpty())){
            StringTokenizer st = new StringTokenizer(input);
            double H = Double.parseDouble(st.nextToken());
            double P = Double.parseDouble(st.nextToken());
            double res = H / P;

            bw.write(String.format("%.2f",res)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
