import java.util.HashMap;
import java.util.Map.Entry;
class Solution {

    public String reorganizeString(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        StringBuilder str = new StringBuilder();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Obj> q = new PriorityQueue<>();
        for (Entry<Character, Integer> entry : hm.entrySet()) {
            q.add(new Obj(entry.getKey(),(int)entry.getValue()));
        }
        Obj temp,temp2;
        while (q.size()>0){
            temp=q.poll();
            str.append(temp.ch);
            temp.val=temp.val-1;
            if(q.size()==0 && temp.val>0) return "";
            if(q.size()>0){
                temp2=q.poll();
                str.append(temp2.ch);
                temp2.val=temp2.val-1;
                if(temp2.val>0) q.add(temp2);
                if(temp.val>0) q.add(temp);
            }  
        }
            
        return str.toString();
    }

    class Obj implements Comparable<Obj>{
        int val;
        char ch;

        public Obj(char ch, int val) {
            this.val = val;
            this.ch = ch;
        }

        @Override
        public int compareTo(Obj c) {
            return this.val<c.val? 1 :-1;
        }
    }
}
