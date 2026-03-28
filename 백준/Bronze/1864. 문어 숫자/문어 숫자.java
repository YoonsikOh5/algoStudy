import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder out = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            if (line.equals("#")) {
                break;
            }

            long value = 0;
            for (int i = 0; i < line.length(); i++) {
                value = value * 8 + toDigit(line.charAt(i));
            }

            out.append(value).append('\n');
        }

        bw.write(out.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int toDigit(char c) {
        switch (c) {
            case '-':
                return 0;
            case '\\':
                return 1;
            case '(':
                return 2;
            case '@':
                return 3;
            case '?':
                return 4;
            case '>':
                return 5;
            case '&':
                return 6;
            case '%':
                return 7;
            case '/':
                return -1;
            default:
                throw new IllegalArgumentException("Invalid octopus digit: " + c);
        }
    }
}
