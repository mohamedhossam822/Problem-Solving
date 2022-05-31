public class WordDictionary {

    // Initialize Trie Data structure
    HashMap<Character,WordDictionary> children;
    boolean isWord;

    public WordDictionary() {
        children=new HashMap<>();
        isWord=false;
    }

    // Add a word to Trie
    public void addWord(String word) {
        
        WordDictionary current = this;
        for(char c: word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new WordDictionary());
            }
            current = current.children.get(c);
        }
        // Set end of word
        current.isWord = true;
    }

    private boolean searchInRoot(String word, WordDictionary node) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                // character might be .
                if (ch == '.') {
                    for(WordDictionary child: node.children.values()) {
                        if (searchInRoot(word.substring(i+1), child)) {
                            return true;
                        }
                    }
                }
                // if character doesn't exist
                return false;
            }
            else {
                node = node.children.get(ch);
            }
        }
        return node.isWord;
    }

    // Search word in Trie data structure
    public boolean search(String word) {
        return searchInRoot(word,this);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */