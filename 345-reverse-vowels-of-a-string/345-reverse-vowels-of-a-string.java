class Solution {
    public String reverseVowels(String s) {
        int l=0,r=s.length()-1;
        HashSet<Character> vowelNumbers=new HashSet<>();
        vowelNumbers.add('a');
        vowelNumbers.add('i');
        vowelNumbers.add('e');
        vowelNumbers.add('o');
        vowelNumbers.add('u');
        vowelNumbers.add('A');
        vowelNumbers.add('I');
        vowelNumbers.add('E');
        vowelNumbers.add('O');
        vowelNumbers.add('U');
        char[] charS=s.toCharArray();
        while(l<r){
            char ch=charS[l];
            while(!vowelNumbers.contains(ch)){
                l++;
                if(l==s.length()) break;
                ch=charS[l];
            } 
            if(r<=l) break;
            ch=charS[r];
            while(!vowelNumbers.contains(ch)){
                r--;
                if(r==-1) break;
                ch=charS[r];
            }
            char temp=charS[r];
            charS[r]=charS[l];
            charS[l]=temp;
            r--;
            l++;
        }
        
        return String.valueOf(charS);
    }
}