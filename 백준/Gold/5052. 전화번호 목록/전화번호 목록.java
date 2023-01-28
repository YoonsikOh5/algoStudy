import java.io.*;
import java.util.*;


public class Main {


    static class TrieNode {
        private TrieNode[] children;
        private boolean isEnd;

        public TrieNode() {
            children = new TrieNode[11];
            isEnd = false;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setChild(int num, TrieNode child) {
            children[num] = child;
        }

        public TrieNode getChild(int num) {
            return children[num];
        }
    }

    static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public boolean insert(String nums) {
            TrieNode current = root;

            int len = nums.length();

            for (int i = 0; i < len; i++) {
                if (current.isEnd()) {
                    return false;
                }
                int num = nums.charAt(i) - '0';
                TrieNode child = current.getChild(num);
                if (child == null) {
                    child = new TrieNode();
                    current.setChild(num, child);
                }
                current = child;
            }
            // 이번 입력 뒤에 만약에 번호가 더 있으면 이 번호가 다른 번호의 접두어인 경우
            for (int i = 0; i < 11; i++) {
                if (current.children[i] != null) {
                    return false;
                }
            }
            current.setEnd();
            return true;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            Trie trie = new Trie();
            boolean isConsistence = true;
            for (int j = 0; j < n; j++) {
                String str = br.readLine();
                if(isConsistence){
                    if (!trie.insert(str)) {
                        isConsistence = false;
                    }
                }
            }
            if (isConsistence) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

}
