class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<HashSet<Integer>> cities=new ArrayList<>(n);
        int max;
        for(int i=0;i<n;i++) cities.add(new HashSet<>());
        for(int i=0;i<roads.length;i++){
            cities.get(roads[i][0]).add(roads[i][1]);
            cities.get(roads[i][1]).add(roads[i][0]);
        }
        max=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int val=cities.get(i).size()+cities.get(j).size();
                if(cities.get(i).contains(j)) val--;
                if(val>max) max=val; 
            }
        }
        
        return max;
    }
}