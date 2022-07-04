class Solution {
    HashSet<String> cache=new HashSet<>();
    public int compareVersion(String version1, String version2) {
        if(version1.length()==0 && version2.length()==0) return 0;
        //get the first part of the 2 versions
        String v1=version1.split("\\.")[0];
        String v2=version2.split("\\.")[0];
        String key=v1+'.'+v2;
        if(cache.contains(key))
            return compareVersion(version1.substring(Math.min(v1.length()+1,version1.length()),version1.length()),
                                  version2.substring(Math.min(v2.length()+1,version2.length()),version2.length()));
            
        int v1Indx=0;
        int v2Indx=0;
        
        //Remove leading zeros
        while(v1Indx<v1.length() && v1.charAt(v1Indx)=='0') v1Indx++;
        while(v2Indx<v2.length() && v2.charAt(v2Indx)=='0') v2Indx++;
        
        if(v1.length()-v1Indx>v2.length()-v2Indx) return 1;
        if(v1.length()-v1Indx<v2.length()-v2Indx) return -1;
        
        while(v1Indx<v1.length() && v2Indx<v2.length())
        {
            if(v1.charAt(v1Indx)>v2.charAt(v2Indx)) return 1;
            if(v1.charAt(v1Indx)<v2.charAt(v2Indx)) return -1;
            v1Indx++;
            v2Indx++;
        }
        cache.add(key);
        return compareVersion(version1.substring(Math.min(v1.length()+1,version1.length()),version1.length()),
                              version2.substring(Math.min(v2.length()+1,version2.length()),version2.length()));
    }
}