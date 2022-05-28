class Solution {
    public int characterReplacement(String s, int k) {
        int passes=k,lastIndex=-1,count=0,max=0,start=0;;
        char curCh=s.charAt(0);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=curCh){
                if(passes>0){
                    if(passes==k) lastIndex=i;
                    passes--;
                }
                else {
                    if(k==0) lastIndex=i;
                    curCh=s.charAt(lastIndex);
                    i=lastIndex;
                    start=i;
                    count=0;
                    passes=k;
                }
            }
            count++;
            if(count>max) max=count;
        }
        if(passes>0){
            for(int i=start-1;i>=0;i--)
            {
                count++;
                passes--;
                if(count>max) max=count;
                if(passes==0) break;
            }
        }
        return max;
    }
}