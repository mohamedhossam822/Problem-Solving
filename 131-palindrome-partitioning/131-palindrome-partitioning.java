class Solution {
    List<List<String>> res=new ArrayList<>();
    HashMap<String,Boolean> paliStrs=new HashMap<>();
    
    public List<List<String>> partition(String s) {
        
        getAllPalis(s,0,s.length()-1,new ArrayList<>());
        
        return res;
    }
    
    private void getAllPalis(String s,int start,int end,List<String> strs){
        
        for(int i=start;i<=end;i++){
            String str=s.substring(start,i+1);
            
            if(isPali(str)){
                strs.add(str);
                if(i==end) res.add(new ArrayList<>(strs));
                else getAllPalis(s,i+1,end,strs);
                strs.remove(strs.size() - 1);
            }
            
        }
        
    }
    
    private boolean isPali(String s){
        if(paliStrs.containsKey(s)) return paliStrs.get(s);
        int l=0;
        int r=s.length()-1;
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)){
                paliStrs.put(s,false);
                return false;
            }
            l++;
            r--;
        }
            
        paliStrs.put(s,true);
        return true;
    }
    
    
}