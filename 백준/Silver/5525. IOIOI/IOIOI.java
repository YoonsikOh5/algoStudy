import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int length = str.length();
        int targetl = N*2+1;
        boolean start = false;
        char nextshouldbe = 'O';
        int curcount = 0;
        int resultcount = 0;
        for(int i = 0; i < length; i++){
            if(!start && str.charAt(i)=='I'){
                nextshouldbe = 'O';
                curcount++;
                start = true;
            } else if(start && str.charAt(i)==nextshouldbe){
                if(nextshouldbe=='I'){
                    nextshouldbe='O';
                    curcount++;
                } else if(nextshouldbe=='O'){
                    nextshouldbe='I';
                    curcount++;
                }
                if(curcount==targetl){
                    resultcount++;
                    curcount-=2;
                }
            } else if(start && str.charAt(i)!=nextshouldbe){
                if(str.charAt(i)=='O'){
                    start=false;
                    curcount=0;
                } else if(str.charAt(i)=='I'){
                    start=true;
                    curcount=1;
                    nextshouldbe='O';
                }
            }
        }
        bw.write(resultcount+"");
        bw.flush();
        bw.close();
        br.close();

    }


}
