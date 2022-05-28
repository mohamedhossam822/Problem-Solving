import java.util.Queue;
class Solution {
    public String minWindow(String s, String t) {
        int[] Tchars=new int[58];
        HashMap<Character,Integer> tMap=new HashMap<>();
        char c;
        int min=100001,start=0,end=0;
        for(int i=0;i<t.length();i++){
            c=t.charAt(i);
            Tchars[c-'A']++;
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int f=0;
        Queue<Integer> index= new LinkedList<>();
        Queue<Character> cIndex= new LinkedList<>();
        int[] chars=new int[58];
        for(int i=0;i<s.length();i++){
            c=s.charAt(i);
            if(tMap.containsKey(c)){
                chars[c-'A']++;
                Tchars[c-'A']--;
                index.add(i);
                cIndex.add(c);
                while(chars[c-'A']>tMap.get(c) && cIndex.peek()==c){
                    chars[c-'A']--;
                    cIndex.poll();
                    index.poll();
                    c=cIndex.peek();
                }
                f=1;
                for(int j=0;j<58;j++){
                    if(Tchars[j]>0){
                        f=0;
                        break;
                    }}
                if(f==1 && (i+1-index.peek())<min){
                    min= i+1-index.peek();
                    start=index.peek();
                    end=i+1;
                } 
                
            }
        }
        if(min==100001) return "";
        return s.substring(start,end);
        
    }
}