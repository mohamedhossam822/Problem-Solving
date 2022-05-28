class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        String[] msgSent=new String[5001];
        HashMap<String,Integer> hm=new HashMap<>();
        String[] word;
        for(int i=0;i<messages.length;i++){
            word = messages[i].split(" ");
            if(hm.containsKey(senders[i])) hm.put(senders[i],word.length+hm.get(senders[i]));
            else hm.put(senders[i],word.length);
        }
        int max=0,n;
        for (Map.Entry<String, Integer> set :hm.entrySet()) {
            n=set.getValue();
            if(n>5000) return set.getKey();
            if(n>max) max=n;
            if(msgSent[n]==null || set.getKey().compareTo(msgSent[n])>0)
               msgSent[n]=set.getKey();
        }
        
        return msgSent[max];
    }
}