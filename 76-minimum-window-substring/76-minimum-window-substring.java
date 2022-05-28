import java.util.Queue;
class Solution {
    public String minWindow(String s, String t) {
        int n=t.length();
        int[] Tchars=new int[58];
        char c;
        int min=100001,start=0,end=0;
        for(int i=0;i<t.length();i++){
            c=t.charAt(i);
            Tchars[c-'A']++;
        }
        Queue<Integer> index= new LinkedList<>();
        Queue<Character> cIndex= new LinkedList<>();
        int[] chars=new int[58];
        for(int i=0;i<s.length();i++){
            c=s.charAt(i);
            if(Tchars[c-'A']>0){
                chars[c-'A']++;
                index.add(i);
                cIndex.add(c);
                if(n!=0) if(Tchars[c-'A']>=chars[c-'A']) n--;
                while(chars[c-'A']>Tchars[c-'A'] && cIndex.peek()==c){
                    chars[c-'A']--;
                    cIndex.poll();
                    index.poll();
                    c=cIndex.peek();
                }
                if(n==0 && (i+1-index.peek())<min){
                    min= i+1-index.peek();
                    start=index.peek();
                    end=i+1;
                } 
                
            }
        }
        if(n!=0) return "";
        return s.substring(start,end);
        
    }
}