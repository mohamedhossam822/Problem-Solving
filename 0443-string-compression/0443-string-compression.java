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
                    for(char c : Integer.toString(number).toCharArray()){
                        len++;
                        chars[index++]=c;
                    }
                }
                chars[index++]=ch;
                pre=ch;
                number=1;
            }
        }
        if(number!=1){
            for(char c : Integer.toString(number).toCharArray()){
                len++;
                chars[index++]=c;
            }
        }
        
        return len;
    }
}