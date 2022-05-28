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
        int max=0;
        for (Map.Entry<String, Integer> set :hm.entrySet()) {
            if(set.getValue()>5000) return set.getKey();
            if(set.getValue()>max) max=set.getValue();
            if(msgSent[set.getValue()]==null) msgSent[set.getValue()]=set.getKey();
            else{
                if(set.getKey().compareTo(msgSent[set.getValue()])>0){
                    msgSent[set.getValue()]=set.getKey();
                } 
            }
        }
        return msgSent[max];
        
    }
}