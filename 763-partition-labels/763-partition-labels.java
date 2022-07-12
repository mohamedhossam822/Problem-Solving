class Solution {
    public List<Integer> partitionLabels(String s) {
        LinkedHashMap<Character,charIndcies> charIndciesMap=new LinkedHashMap<>();
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(charIndciesMap.containsKey(curr)){
                charIndcies ch=charIndciesMap.get(curr);
                ch.end=i;
            }else{
                charIndcies ch=new charIndcies();
                ch.start=i;
                ch.end=i;
                charIndciesMap.put(curr,ch);
            } 
        }
        int end=0;
        int start=0;
        for(charIndcies ch : charIndciesMap.values()){
            if(end<ch.start){
                res.add(1+end-start);
                start=ch.start;
                end=ch.end;
            } 
            else{
                end=Math.max(end,ch.end);
            } 
        }
        res.add(1+end-start);
        return res;
    }
    
    class charIndcies{
        int start;
        int end;
    }
}