class Solution {
    public String decodeMessage(String key, String message) {
       char[] KeyValue=new char[26];
        StringBuilder res=new StringBuilder();
        
        int index=0;
        int marked=0;
        
        for(int i=0;i<key.length();i++){
            
            char curr=key.charAt(i);
            
            if(curr==' ') continue;
            if(KeyValue[curr-'a']!=0) continue;
            
            KeyValue[curr-'a']=(char)(index+'a');
            index++;
            marked++;
            
            if(marked==26) break;
        }
        
        
        for(int i=0;i<message.length();i++){
            char curr=message.charAt(i);
            
            if(curr==' ') res.append(' ');
            else res.append(KeyValue[curr-'a']);
        }
        return res.toString();
    }
}