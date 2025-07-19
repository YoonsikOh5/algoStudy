import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Double> hm = new HashMap<>();

        hm.put("Paper",57.99);
        hm.put("Printer",120.50);
        hm.put("Planners",31.25);
        hm.put("Binders",22.50);
        hm.put("Calendar",10.95);
        hm.put("Notebooks",11.20);
        hm.put("Ink",66.95);

        String cur = br.readLine();
        double res = 0;
        while (!cur.equals("EOI")){
            res += hm.get(cur);
            cur = br.readLine();
        }

        bw.write("$"+String.format("%.2f",res)+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
