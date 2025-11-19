import java.io.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if (s.equals("end")) {
                break;
            }

            if (s.equals("animal")) {
                bw.write("Panthera tigris\n");
            } else if (s.equals("flower")) {
                bw.write("Forsythia koreana\n");
            } else if (s.equals("tree")) {
                bw.write("Pinus densiflora\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
