import java.util.Hashtable;

class Solution {
    int n;
    int f;
    Hashtable<Integer,Integer> cache;
    public int numDecodings(String s) {
        cache=new Hashtable<>();
        n=s.length();
        f=0;
        if(s.charAt(0)=='0') return 0;
        if(f==1) return 0;
        return explore(0,s);
    }
    
    public int explore(int i,String s){
        if(cache.containsKey(i)){
            return cache.get(i);
        }
        if(i>n) return 0;
        if(i==n) return 1;
        char c=s.charAt(i);
        if(c=='0') {
            f=1;
            return 0;
        }
        int sum=0;
        if(i+1==n) sum+=explore(i+1,s);
        else{
            if(c=='1'){
                if(s.charAt(i+1)!=0) sum+=explore(i+1,s);
                if(i+2==n) sum+=explore(i+2,s); 
                else if(s.charAt(i+2)!='0'){
                    sum+=explore(i+2,s); 
                } 
            } 
            else if( c=='2'){
                c=s.charAt(i+1);
                if(c!='0') sum+=explore(i+1,s);
                if(c!='7' && c!='8' && c!='9'){
                    if(i+2==n) sum+=explore(i+2,s); 
                    else if(s.charAt(i+2)!='0') sum+=explore(i+2,s);     
                } 
                
            }
            else sum+=explore(i+1,s);
        }
        cache.put(i,sum);
        return sum;
    }
}