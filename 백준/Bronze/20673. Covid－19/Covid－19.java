import java.io.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int p = Integer.parseInt(br.readLine());
        int q = Integer.parseInt(br.readLine());

        if(p <= 50 && q <= 10){
            bw.write("White");
        } else if (q > 30){
            bw.write("Red");
        } else {
            bw.write("Yellow");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}