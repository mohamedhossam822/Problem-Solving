class Solution {
    HashMap<String,List<String>> Dict=new HashMap<>();
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        //Insert products into hashMap
        for(int i=0;i<products.length;i++) InsertWord(products[i]);
        List<List<String>> res=new ArrayList<>();
        for(int i=1;i<=searchWord.length();i++){
            String temp=searchWord.substring(0,i);
            List<String> tempList=new ArrayList<>();
            if(Dict.containsKey(temp)){
                int size=Math.min(3,Dict.get(temp).size());
                Collections.sort(Dict.get(temp));
                for(int j=0;j<size;j++){
                    tempList.add(Dict.get(temp).get(j));
                }
            }
            res.add(tempList);
        }
        
        return res;
    }
    
    public void InsertWord(String word){
        String temp;
        for(int i=1;i<=word.length();i++){
            temp=word.substring(0,i);
            if(!Dict.containsKey(temp)) Dict.put(temp,new ArrayList<>());
            Dict.get(temp).add(word);
        }
    }
}
