class Trie {
    HashMap<Character,Trie> trie;
    boolean isWord;
    public Trie() {
        trie=new HashMap<>();
        isWord=false;
    }
    
    public void insert(String word) {
        Trie root=this;
        for(char ch: word.toCharArray()){
            if(!root.trie.containsKey(ch))root.trie.put(ch,new Trie());
             root=root.trie.get(ch);
        }
        root.isWord=true;
    }
    
    public boolean search(String word) {
        Trie root=this;
        for(char ch: word.toCharArray()){
            if(!root.trie.containsKey(ch)) return false;
             root=root.trie.get(ch);
        }
        if(root.isWord) return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        Trie root=this;
        for(char ch: prefix.toCharArray()){
            if(!root.trie.containsKey(ch)) return false;
             root=root.trie.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */