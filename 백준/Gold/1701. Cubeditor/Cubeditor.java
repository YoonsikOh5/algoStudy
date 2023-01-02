import java.io.*;

public class Main {

    static int resultMax = 0;

    public static int[] getPi(int L, String comp){
        int[] pi = new int[L];

        int j = 0;

        for(int i = 1; i < L; i++){
            while(j>0 && comp.charAt(i)!=comp.charAt(j)){
                j = pi[j-1];
            }
            if(comp.charAt(i)==comp.charAt(j)){
                pi[i] = ++j;
                resultMax = Math.max(resultMax,pi[i]);
            }

        }

        return pi;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String adv = br.readLine();
        int L = adv.length();

        for(int i = 0; i < L ; i++){
            String comp = adv.substring(i);
            int[] pi = getPi(comp.length(),comp);
        }

        bw.write(resultMax+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
