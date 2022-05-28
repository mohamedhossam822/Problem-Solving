class Solution {
    public boolean isValid(String s) {
        Stack stack1 = new Stack();
        char element;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                stack1.push(s.charAt(i));
            }
            else if(stack1.empty()) return false;
            else if(s.charAt(i)==')'){
                if((char)stack1.pop()!='(') return false;
            }
            else if(s.charAt(i)=='}'){
                if((char)stack1.pop()!='{') return false;
            }
            else if(s.charAt(i)==']'){
                if((char)stack1.pop()!='[') return false;
            }
        }
        if(!stack1.empty()) return false;
        
        return true;
    }
}