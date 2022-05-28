import java.util.Queue;
class Solution {
    public String minWindow(String s, String t) {
        int[] Tchars=new int[58];
        char c;
        int min=100001,start=0,end=0;
        for(int i=0;i<t.length();i++){
            c=t.charAt(i);
            Tchars[c-'A']++;
        }
        int f=0;
        Queue<Integer> index= new LinkedList<>();
        Queue<Character> cIndex= new LinkedList<>();
        int[] chars=new int[58];
        for(int i=0;i<s.length();i++){
            c=s.charAt(i);
            if(Tchars[c-'A']>0){
                chars[c-'A']++;
                index.add(i);
                cIndex.add(c);
                while(chars[c-'A']>Tchars[c-'A'] && cIndex.peek()==c){
                    chars[c-'A']--;
                    cIndex.poll();
                    index.poll();
                    c=cIndex.peek();
                }
                if(f==0){
                    f=1;
                    for(int j=0;j<58;j++){
                        if(Tchars[j]>chars[j]){
                            f=0;
                            break;
                    }}  
                }
                if(f==1 && (i+1-index.peek())<min){
                    min= i+1-index.peek();
                    start=index.peek();
                    end=i+1;
                } 
                
            }
        }
        if(f==0) return "";
        return s.substring(start,end);
        
    }
}