/**
 * Created by Liuxz on 2017/6/13.
 */
public class Leet208ImplementTrie {
    /** Initialize your data structure here. */
    storage root = new storage('/');
    public Leet208ImplementTrie() {
    }
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] char_list = word.toCharArray();
        storage current_level = root;
        for(char x : char_list){
            if(current_level.get(x-'a') == null){
                current_level.set(x-'a', new storage(x));
            }
            current_level = current_level.get(x-'a');
        }
        current_level.wordEnds=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] char_list = word.toCharArray();
        storage current_level = root;
        for (char x:char_list){
            if (current_level.get(x-'a') == null){
                return false;
            }else{
                current_level = current_level.get(x-'a');
            }
        }
        if (current_level.wordEnds){
            return true;
        }else{
            return false;
        }
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] char_list = prefix.toCharArray();
        storage current_level = root;
        for (char x:char_list){
            if (current_level.get(x-'a') == null){
                return false;
            }else{
                current_level = current_level.get(x-'a');
            }
        }
        return true;
    }
    public static void main(String[] args){
        Leet208ImplementTrie xx = new Leet208ImplementTrie();
        xx.insert("trie");
        xx.insert("trieee");
        xx.insert("int");
        System.out.println(xx.search("trie"));
        System.out.println(xx.search("t"));
        System.out.println(xx.search("int"));
        System.out.println(xx.startsWith("tr"));
        System.out.println(xx.startsWith("abcc"));
    }

    private class storage{
        boolean wordEnds = false;
        char x;
        storage[] s = new storage[26];
        storage(char in){
            this.x = in;
        }
        storage get(int i){
            return s[i];
        }
        void set(int i, storage in){
            s[i] = in;
        }
    }

}

