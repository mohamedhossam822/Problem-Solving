class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> leftBrackets=new Stack<>();
        StringBuilder str=new StringBuilder();
        int counter=0,i=0,index;
        char c;
        for(i=0;i<s.length();i++){
            c=s.charAt(i);
            if(c==')' &&  leftBrackets.empty()) continue;
            if(c=='('){
                leftBrackets.push(counter);
            }
            else if(c==')'){
                leftBrackets.pop();
            }
            str.append(c);
            counter++;
        }
        while(!leftBrackets.empty()){
            index=leftBrackets.pop();
            str.replace(index,index+1,"");
        }
        return str.toString();
    }
}