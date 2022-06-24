/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        int start=1;
        int finish=n;
        
        while(finish>start){
            int m=start + (finish - start) / 2;
            
            if(isBadVersion(m))finish=m;
            else start=m+1;
        }
        return finish;
        
    }
}