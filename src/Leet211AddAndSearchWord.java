import java.util.LinkedList;

/**
 * Created by Liuxz on 2017/6/13.
 */
public class Leet211AddAndSearchWord {

    private class Trie{
        boolean isEnd = false;
        Trie[] v = new Trie[26];
        Trie get(int i){
            return v[i];
        }
        void set(Trie in, int i){
            v[i] =in;
        }
    }

    Trie root = new Trie();
    /** Initialize your data structure here. */
    public Leet211AddAndSearchWord() {
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] char_list = word.toCharArray();
        Trie current_layer = root;
        for (char x: char_list){
            if(current_layer.get(x-'a')== null){
                current_layer.set(new Trie(),x-'a');
            }
            current_layer = current_layer.get(x-'a');
        }
        current_layer.isEnd = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        char[] char_list = word.toCharArray();
        Trie current_node;
        LinkedList<Trie> queue = new LinkedList<>();
        LinkedList<Trie> temp = new LinkedList<>();
        int layer = 0;
        queue.offer(root);
        while (true){
            while(!queue.isEmpty()){
                current_node = queue.poll();
                if (char_list[layer] == '.'){
                    for (int i=0; i < 26; i ++){
                        if(current_node.get(i) != null){
                            temp.offer(current_node.get(i));
                        }
                    }
                }else{
                    if (current_node.get(char_list[layer] - 'a') != null){
                        temp.offer(current_node.get(char_list[layer] - 'a'));
                    }
                }
            }
            if (char_list.length -1== layer){
                for (Trie x : temp){
                    if (x.isEnd == true){
                        return true;
                    }
                }
                return false;
            }
            queue = new LinkedList<>(temp);
            temp.clear();
            layer++;
        }
    }

    public static void main(String[] args){
        Leet211AddAndSearchWord xx = new Leet211AddAndSearchWord();
        xx.addWord("bad");
        xx.addWord("dad");
        xx.addWord("mad");
        xx.addWord("babd");
//        System.out.println(xx.search("pad"));
//        System.out.println(xx.search("bad"));
//        System.out.println(xx.search(".ad"));
//        System.out.println(xx.search("b.d"));
        System.out.println(xx.search("b..d"));
    }
}
