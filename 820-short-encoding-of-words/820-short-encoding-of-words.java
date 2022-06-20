class Solution {

    public int minimumLengthEncoding(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a,b) -> Integer.compare(b.length(), a.length()));
        
        StringBuilder str = new StringBuilder();
        str.append(words[0] + "#");
        
        for (int i = 1; i<n; i++) {
            String temp = words[i] + "#";
            if (str.indexOf(temp) == -1) str.append(temp);
        }
        
        return str.length();
    }
}
