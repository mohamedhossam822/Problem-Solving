class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for(String token : tokens){
            if(token.equals("+")){
                stack.push(stack.pop()+stack.pop());
            }
            else if(token.equals("-")){
                stack.push(-(stack.pop()-stack.pop()));
            }
            else if(token.equals("/")){
                int divisor=stack.pop();
                int dividend=stack.pop();
                stack.push(dividend/divisor);
            }
            else if(token.equals("*")){
                stack.push(stack.pop()*stack.pop());
            } else stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }
}