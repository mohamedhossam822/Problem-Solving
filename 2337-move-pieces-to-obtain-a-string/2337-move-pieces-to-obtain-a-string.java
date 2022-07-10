class Solution {
    public boolean canChange(String start, String target) {
        Stack<element> sStack=new Stack<>();
        Stack<element> tStack=new Stack<>();
        for(int i=0;i<start.length();i++){
            char ch=start.charAt(i);
            if(ch!='_') sStack.push(new element(ch,i));
            ch=target.charAt(i);
            if(ch!='_') tStack.push(new element(ch,i));
        }
        while(!sStack.empty() && !tStack.empty()){
            element s=sStack.pop();
            element t=tStack.pop();
            if(s.ch!=t.ch) return false;
            if(s.ch=='L' && t.index>s.index) return false;
            if(s.ch=='R' && t.index<s.index) return false;
        }
        if(!sStack.empty() || !tStack.empty()) return false;
        return true;
    }
    class element{
        char ch;
        int index;
        element(char ch,int index){
            this.ch=ch;
            this.index=index;
        }
    }
}