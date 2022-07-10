class Solution {
    public boolean canChange(String start, String target) {
        int sIndex=0;
        int tIndex=0;
        int n=start.length();
        while(sIndex<n && tIndex<n){
            while(sIndex<n && start.charAt(sIndex)=='_') sIndex++;
            
            while(tIndex<n && target.charAt(tIndex)=='_') tIndex++;
            if(sIndex==n && tIndex==n) return true;
            if(sIndex==n || tIndex==n) return false;
            char sChar=start.charAt(sIndex);
            if(sChar!=target.charAt(tIndex)) return false;
            if(sChar=='L' && tIndex>sIndex) return false;
            if(sChar=='R' && tIndex<sIndex) return false;
            tIndex++;
            sIndex++;
        }
        
        return true;
    }
}