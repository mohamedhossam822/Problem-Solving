class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result=new ArrayList<>();
        LinkedHashMap<Character, int[]> lhm= new LinkedHashMap<>();
        char ch;
        
        for(int i=0;i<s.length();i++){
            ch=s.charAt(i);
            if(!lhm.containsKey(ch)){
                lhm.put(ch,new int[]{i,i});
            }
            else{
                lhm.put(ch,new int[]{lhm.get(ch)[0],i});
            }
        }   
        
        Iterator<int[]> values=lhm.values().iterator();
        int start=0;
        int lastBiggest = values.next()[1];
        int[] arr;
        
        while (values.hasNext()){
            arr=values.next();
            if(lastBiggest>arr[0]){
                lastBiggest= lastBiggest>arr[1] ? lastBiggest : arr[1];
            }
            else{
                result.add(arr[0]-start);
                start=arr[0];
                lastBiggest=arr[1];
            }
        }
        result.add(s.length()-start);
        
        return result;
    }
}