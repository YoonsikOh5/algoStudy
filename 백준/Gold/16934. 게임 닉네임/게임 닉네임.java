import java.io.*;
import java.util.*;


public class Main {

    static int N;

    static class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        int endCount;

        public TrieNode() {
            this.children = new TrieNode[26];
            isEnd = false;
            endCount = 0;
        }


        public void setChild(char c, TrieNode child) {
            children[c - 'a'] = child;
        }

        public TrieNode getChild(char c) {
            return children[c - 'a'];
        }

        public void setEnd() {
            isEnd = true;
            endCount++;
        }

        public boolean isEnd() {
            return this.isEnd;
        }

        public int getEndCount() {
            return endCount;
        }
    }

    static class Trie {

        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public String insert(String str) {
            int len = str.length();
            TrieNode current = root;
            StringBuilder sb = new StringBuilder();
            boolean nicknameConfirmed = false;
            for (int i = 0; i < len; i++) {
                char curchar = str.charAt(i);
                TrieNode curChild = current.getChild(curchar);
                if (!nicknameConfirmed) {
                    sb.append(curchar);
                }
                if (curChild == null) {
                    curChild = new TrieNode();
                    current.setChild(curchar, curChild);
                    nicknameConfirmed = true;
                }
                current = curChild;
            }
            current.setEnd();
            if (!nicknameConfirmed) {
                if (current.getEndCount() > 1) {
                    sb.append(current.getEndCount());
                }
            }

            return sb.toString();
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        Trie trie = new Trie();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String nickname = trie.insert(str);
            bw.write(nickname + "\n");
        }


        bw.flush();
        bw.close();
        br.close();

    }

}
