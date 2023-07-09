import java.io.*;
import java.util.*;

public class Main {

    static class TrieNode {
        TrieNode[] children;
        int num;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.num = 1;
        }

        public void setChildren(char c, TrieNode child) {
            children[c - 'a'] = child;
        }

        public TrieNode getChildren(char c) {
            return children[c - 'a'];
        }

    }

    static class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String str) {
            TrieNode current = root;
            int len = str.length();
            for (int i = 0; i < len; i++) {
                TrieNode children = current.getChildren(str.charAt(i));
                if (children == null) {
                    TrieNode child = new TrieNode();
                    current.setChildren(str.charAt(i), child);
                    current = child;
                } else {
                    children.num++;
                    current = children;
                }
            }
        }

        public void delete(String str) {
            TrieNode current = root;
            int len = str.length();
            for (int i = 0; i < len; i++) {
                TrieNode children = current.getChildren(str.charAt(i));
                children.num--;
                current = children;
            }
        }

        public List<Integer> getNums(String str) {
            List<Integer> numList = new LinkedList<>();
            TrieNode current = root;
            int len = str.length();
            for (int i = 0; i < len; i++) {
                TrieNode children = current.getChildren(str.charAt(i));
                if (children == null || children.num == 0) {
                    break;
                } else {
                    numList.add(children.num);
                    current = children;
                }
            }
            return numList;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int Q = Integer.parseInt(br.readLine());

        Trie trieA = new Trie();
        Trie trieB = new Trie();

        for (int i = 1; i <= Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("add")) {
                String team = st.nextToken();
                String word = st.nextToken();
                if (team.equals("A")) {
                    trieA.insert(word);
                } else if (team.equals("B")) {
                    StringBuilder sb = new StringBuilder(word);
                    String rWord = sb.reverse().toString();
                    trieB.insert(rWord);
                }
            } else if (cmd.equals("delete")) {
                String team = st.nextToken();
                String word = st.nextToken();
                if (team.equals("A")) {
                    trieA.delete(word);
                } else if (team.equals("B")) {
                    StringBuilder sb = new StringBuilder(word);
                    String rWord = sb.reverse().toString();
                    trieB.delete(rWord);
                }
            } else if (cmd.equals("find")) {
                String target = st.nextToken();
                StringBuilder sba = new StringBuilder(target);
                sba.deleteCharAt(target.length()-1);
                String trimedTarget = sba.toString();
                List<Integer> numsA = trieA.getNums(trimedTarget);
                StringBuilder sb = new StringBuilder(target);
                String trimedRTarget = sb.reverse().deleteCharAt(target.length()-1).toString();
                List<Integer> numsB = trieB.getNums(trimedRTarget);

                long result = 0;
                int sizeA = numsA.size();
                int sizeB = numsB.size();

                int tlen = target.length();
                int tsize = tlen - 1;

                for (int a = 0; a < sizeA; a++) {
                    if ((tsize - a) > sizeB) {
                        continue;
                    }
                    Integer ia = numsA.get(a);
                    Integer ib = numsB.get(tsize - a - 1);
                    result += ia * ib;
                }

                bw.write(result+"\n");
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }


}