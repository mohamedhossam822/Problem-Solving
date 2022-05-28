class Solution {
    public boolean isPalindrome(String s) {
        int start=0;
        int end=s.length()-1;
        int flag=0;
        while(start<end){
            while(!Character.isLetter(s.charAt(start)) && !Character.isDigit(s.charAt(start))){
                start++;
                if(start>s.length()-1){
                    flag=1;
                    break; 
                } 
            }
            if(flag==1) break;
            
            while(!Character.isLetter(s.charAt(end)) && !Character.isDigit(s.charAt(end))){
                end--;
                if(end<0){
                    flag=1;
                    break; 
                }
            }
            if(flag==1) break;  
            
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)))
                return false;
            start++;
            end--;
        }
        return true;
    }
}