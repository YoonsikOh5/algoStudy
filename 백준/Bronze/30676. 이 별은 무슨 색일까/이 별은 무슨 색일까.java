import java.io.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());

        if (a >= 620 && a <= 780) {
            bw.write( "Red");
        } else if (a >= 590 && a < 620) {
            bw.write( "Orange");
        } else if (a >= 570 && a < 590) {
            bw.write( "Yellow");
        } else if (a >= 495 && a < 590) {
            bw.write( "Green");
        } else if (a >= 450 && a < 495) {
            bw.write( "Blue");
        } else if (a >= 425 && a < 450) {
            bw.write( "Indigo");
        } else if (a >= 380 && a < 425) {
            bw.write( "Violet");
        }
        bw.flush();
        bw.close();
        br.close();
    }


}