class Solution {
    public int compress(char[] chars) {
        int number=1;
        char pre=' ';
        int len=0;
        int index=0;
        for(char ch : chars){
            if(pre==ch){
                number++;
            }
            else{
                len++;
                if(number!=1){
                    String s=String.valueOf(number);
                    len+=s.length();
                    for(char c : s.toCharArray()){
                        chars[index]=c;
                        index++;
                    }
                }
                chars[index]=ch;
                index++;
                pre=ch;
                number=1;
            }
        }
        if(number!=1){
            String s=String.valueOf(number);
            len+=s.length();
            for(char c : s.toCharArray()){
                chars[index]=c;
                index++;
            }
        }
        
        return len;
    }
}