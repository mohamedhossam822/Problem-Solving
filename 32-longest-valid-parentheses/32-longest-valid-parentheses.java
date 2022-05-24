import java.util.*;
class Solution {
    public int longestValidParentheses(String s) {
        int start=0,max=0,len=0;
        Stack<Integer> st=new Stack<>();
        Stack<Integer> preLen=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(st.empty()){
                    preLen.push(0);
                }
                else {
                    len=i-st.pop()+1;
                    while(preLen.pop()!=0){
                    }
                    if(!preLen.empty() && preLen.peek()!=0){
                        len+=preLen.pop();
                        preLen.push(len);
                    } else preLen.push(len);
                    if(len>max) max=len;
                }
            }
            else {
                preLen.push(0);
                st.push(i);
            }
        }
        if(st.empty() && len>max) max=len;
        return max;
    }
}