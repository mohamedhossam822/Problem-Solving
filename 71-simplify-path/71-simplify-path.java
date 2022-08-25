class Solution {
    public String simplifyPath(String path) {
        
        StringBuilder res=new StringBuilder();
        Stack<String> stack=new Stack<>();
        StringBuilder currentPath=new StringBuilder();
        
        for(int i=0;i<path.length();i++){
            
            char ch=path.charAt(i);
            
            if(ch=='/'){
                if(currentPath.length()!=0 && !currentPath.toString().equals("."))  stack.push(currentPath.toString()); 
                
                if(i+1<path.length() && path.charAt(i+1)=='.' 
                  && i+2<path.length() && path.charAt(i+2)=='.'
                  && (i+3==path.length() || path.charAt(i+3)=='/')){
                    i+=2;
                    if(!stack.empty()) stack.pop();
                }
                
                currentPath.setLength(0);
            }
            else    currentPath.append(ch);
        }
        
        if(currentPath.length()!=0 && !currentPath.toString().equals("."))  stack.push(currentPath.toString()); 
        
        if(stack.empty()) return "/";
        
        Iterator value = stack.iterator();
        while (value.hasNext()) {
            res.append('/');
            res.append(value.next());
        }
        
        return res.toString();
    }
}