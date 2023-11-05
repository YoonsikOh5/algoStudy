import java.io.*;
import java.util.*;

public class Main {

    static int M;
    static Trie[] tries;

    static class Trie {
        int curBinary;
        int childCnt;

        Trie[] childs = new Trie[2];

        Trie() {
        }

        Trie(int curBinary) {
            this.curBinary = curBinary;
            this.childCnt = 0;
        }
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        M = Integer.parseInt(br.readLine());

        // 1~30까지의 길이의 원소가 들어갈 각각 Trie를 만듬
        tries = new Trie[31];
        for (int i = 0; i <= 30; i++) {
            tries[i] = new Trie();
        }
        Trie t1Head = tries[1];
        Trie trie0 = new Trie(0);
        trie0.childCnt++;
        t1Head.childs[0] = trie0;

        for (int m = 1; m <= M; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            String cur = Integer.toBinaryString(x);
            int curlen = cur.length();
            if (cmd == 1) {
                // x 추가
                Trie indexTrie = tries[curlen];
                for (int i = 0; i < curlen; i++) {
                    char c = cur.charAt(i);
                    int cbinary = c - '0';
                    if (indexTrie.childs[cbinary] == null) {
                        Trie childTrie = new Trie(cbinary);
                        indexTrie.childs[cbinary] = childTrie;
                    }
                    indexTrie = indexTrie.childs[cbinary];
                    indexTrie.childCnt++;
                }
            } else if (cmd == 2) {
                // x 제거
                Trie indexTrie = tries[curlen];
                for (int i = 0; i < curlen; i++) {
                    char c = cur.charAt(i);
                    int cbinary = c - '0';
                    Trie childTrie = indexTrie.childs[cbinary];
                    childTrie.childCnt--;
                    if (childTrie.childCnt == 0) {
                        indexTrie.childs[cbinary] = null;
                        break;
                    } else {
                        indexTrie = childTrie;
                    }
                }
            } else if (cmd == 3) {
                int maxLen = 0;
                for (int i = 30; i >= 1; i--) {
                    Trie aTry = tries[i];
                    if (aTry.childs[1] != null) {
                        Trie trie = aTry.childs[1];
                        if (trie.childCnt > 0) {
                            maxLen = i;
                            break;
                        }
                    }
                }
                int result = x;
                boolean findAnswer = false;
                if (maxLen <= curlen) {
                    // x와 모든 원소 XOR 가장 큰 값 출력
                    // x에 0이 있는 가장 높은 자리를 찾아보기
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < curlen; i++) {
                        int curnum = cur.charAt(i) - '0';
                        if (curnum == 0) {
                            Trie aTry = tries[curlen - i];
                            // 이거 값 있으면 무조건 이게 답임
                            if (aTry.childs[1] != null) {
                                Trie trie = aTry.childs[1];
                                if (trie.childCnt > 0) {
                                    findAnswer = true;
                                }
                            }
                            if (!findAnswer) {
                                sb.append(0);
                            }
                        } else {
                            sb.append(1);
                        }

                        if (findAnswer) {
                            // 이제 답을 찾아보자
                            Trie indexTrie = tries[curlen - i];
                            for (int j = i; j < curlen; j++) {
                                int curIdxNum = cur.charAt(j) - '0';
                                int targetNum = (curIdxNum + 1) % 2;
                                if (indexTrie.childs[targetNum] != null && indexTrie.childs[targetNum].childCnt > 0) {
                                    Trie trie = indexTrie.childs[targetNum];
                                    sb.append(1);
                                    indexTrie = trie;
                                } else if (indexTrie.childs[curIdxNum] != null && indexTrie.childs[curIdxNum].childCnt > 0) {
                                    Trie trie = indexTrie.childs[curIdxNum];
                                    sb.append(0);
                                    indexTrie = trie;
                                }
                            }

                            String resultStr = sb.toString();
                            int resultCur = Integer.parseInt(resultStr, 2);
                            result = Math.max(result, resultCur);
                            break;
                        }
                    }
                } else {
                    Trie indexTrie = tries[maxLen];
                    StringBuilder sb = new StringBuilder();
                    int mlen = maxLen - cur.length();
                    for (int j = 0; j < mlen; j++) {
                        if(indexTrie.childs[1]!=null && indexTrie.childs[1].childCnt>0){
                            Trie trie = indexTrie.childs[1];
                            sb.append(1);
                            indexTrie = trie;
                        } else if(indexTrie.childs[0]!=null && indexTrie.childs[0].childCnt>0){
                            Trie trie = indexTrie.childs[0];
                            sb.append(0);
                            indexTrie = trie;
                        }
                    }
                    int mmlen = maxLen - cur.length();
                    for (int j = mmlen; j < maxLen; j++) {
                        int curIdxNum = cur.charAt(j - (mmlen)) - '0';
                        int targetNum = (curIdxNum + 1) % 2;
                        if(indexTrie.childs[targetNum]!=null && indexTrie.childs[targetNum].childCnt>0){
                            Trie trie = indexTrie.childs[targetNum];
                            sb.append(1);
                            indexTrie = trie;
                        } else if(indexTrie.childs[curIdxNum]!=null && indexTrie.childs[curIdxNum].childCnt>0){
                            Trie trie = indexTrie.childs[curIdxNum];
                            sb.append(0);
                            indexTrie = trie;
                        }
                    }

                    String resultStr = sb.toString();
                    int resultCur = Integer.parseInt(resultStr, 2);
                    result = Math.max(result, resultCur);
                }
                bw.write(result + "\n");

            }
        }

        bw.flush();
        bw.close();
        br.close();
    }


}