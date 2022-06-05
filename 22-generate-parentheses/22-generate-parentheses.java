class Solution {
    char[] Parenthesis=new char[]{'(',')'};
    List<String> res=new ArrayList<>();
    HashMap<Character,Integer> chars;
    public List<String> generateParenthesis(int n) {
        chars=new HashMap<>();
        chars.put('(',n);
        chars.put(')',n);
         FindParenthesis(2*n,0,new StringBuilder());
        return res;
    }
    
    public void FindParenthesis(int n,int openBractNum,StringBuilder str){
        if(str.length()==n) {
            res.add(str.toString());
            return;
        }
        for(char ch: Parenthesis){
            if(ch==')' && openBractNum==0) continue;
            if(chars.get(ch)<=0) continue;
            chars.put(ch,chars.get(ch)-1);
            if(ch=='(') openBractNum++;
            else openBractNum--;
            str.append(ch);
            FindParenthesis(n,openBractNum,str);
            chars.put(ch,chars.get(ch)+1);
            if(ch=='(') openBractNum--;
            else openBractNum++;
            str.setLength(str.length() - 1);
        }
    }
}