import java.io.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String cur = br.readLine();
        while (!cur.equals("#")) {
            int count = 0;

            for (int i = 0; i < cur.length(); i++) {
                if (cur.charAt(i) == 'a' ||
                        cur.charAt(i) == 'e' ||
                        cur.charAt(i) == 'i' ||
                        cur.charAt(i) == 'o' ||
                        cur.charAt(i) == 'u' ||
                        cur.charAt(i) == 'A' ||
                        cur.charAt(i) == 'E' ||
                        cur.charAt(i) == 'I' ||
                        cur.charAt(i) == 'O' ||
                        cur.charAt(i) == 'U') {
                    count++;
                }
            }
            bw.write(count+"\n");

            cur = br.readLine();
        }


        bw.flush();
        bw.close();
        br.close();
    }

}