class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> cols=new ArrayList<>();
        List<List<Integer>> results=new ArrayList<>();
        for(int[] building : buildings){
            List<Integer> temp=new ArrayList<>(3);
            temp.add(building[0]);
            temp.add(building[2]);
            temp.add(0);
            cols.add(temp);
            
            temp=new ArrayList<>(3);
            temp.add(building[1]);
            temp.add(building[2]);
            temp.add(1);
            cols.add(temp);
            
        }
        Collections.sort(cols,(a,b)->{
            if(a.get(0)==b.get(0)){
                if(a.get(2)==b.get(2)){
                    if(a.get(2)==0) return b.get(1)-a.get(1); 
                    if(a.get(2)==1) return a.get(1)-b.get(1); 
                }
               return a.get(2)-b.get(2);
            }
            return a.get(0)-b.get(0);
        });
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int preStart=0;
        for(List<Integer> Col: cols){
            int max_value=0;
            if(Col.get(2)==0){
                if(!pq.isEmpty()) max_value=pq.peek();
                pq.add(Col.get(1));
                if(max_value>=Col.get(1)) continue;
                List<Integer> temp=new ArrayList<>(2);
                temp.add(Col.get(0));
                temp.add(Col.get(1));
                preStart=Col.get(0);
                results.add(temp);
            }else{
                max_value=0;
                pq.remove(Col.get(1));
                if(!pq.isEmpty()) max_value=pq.peek();
                if(max_value>=Col.get(1)) continue;
                List<Integer> temp=new ArrayList<>(2);
                temp.add(Col.get(0));
                temp.add(max_value);
                if(preStart==Col.get(0)) results.remove(results.size()-1);
                preStart=Col.get(0);
                results.add(temp);
            }
        }
        
        return results;
    }
}