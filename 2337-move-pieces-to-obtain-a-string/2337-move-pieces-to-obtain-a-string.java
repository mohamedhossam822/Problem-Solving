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
            if(start.charAt(sIndex)!=target.charAt(tIndex)) return false;
            if(start.charAt(sIndex)=='L' && tIndex>sIndex) return false;
            if(start.charAt(sIndex)=='R' && tIndex<sIndex) return false;
            tIndex++;
            sIndex++;
        }
        
        return true;
    }
}