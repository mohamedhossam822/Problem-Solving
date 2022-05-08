class Solution {
    public String addStrings(String num1, String num2) {
        int curIndex=0;
        int curNumber=0;
        StringBuilder result
			= new StringBuilder();
        long ten=1;
        int reminder=0;
        int fN,lN;
        int num1N=num1.length()-1;
        int num2N=num2.length()-1;
        while(num1N>-1 || num2N>-1 || reminder==1){
            fN= num1N>-1 ? Character.getNumericValue(num1.charAt(num1N)):0;
            lN= num2N>-1 ? Character.getNumericValue(num2.charAt(num2N)):0;
            curNumber=fN+lN+reminder;
            reminder=curNumber/10;
            curNumber=curNumber%10;
            result.append((char) ('0' + curNumber));
            num1N--;
            num2N--;
        }
        return result.reverse().toString();
    }
}