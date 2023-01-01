import java.io.*;

public class Main {

    public static int[] getPi(int L, String adv){
        int[] pi = new int[L];

        int j = 0;

        for(int i = 1; i < L; i++){
            while(j>0 && adv.charAt(i)!=adv.charAt(j)){
                j = pi[j-1];
            }
            if(adv.charAt(i)==adv.charAt(j)){
                pi[i] = ++j;
            }

        }

        return pi;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(br.readLine());
        String adv = br.readLine();

        int[] pi = getPi(L,adv);

        bw.write(L-pi[L-1]+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
