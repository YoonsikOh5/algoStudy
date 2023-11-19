import java.io.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        if(s.equals("fdsajkl;") || s.equals("jkl;fdsa")){
            bw.write("in-out");
        } else if(s.equals("asdf;lkj") || s.equals(";lkjasdf")){
            bw.write("out-in");
        } else if(s.equals("asdfjkl;")) {
            bw.write("stairs");
        } else if(s.equals(";lkjfdsa")){
            bw.write("reverse");
        } else {
            bw.write("molu");
        }

        bw.flush();
        bw.close();
        br.close();
    }


}