class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n=points.length;
        int[][] res=new int[k][2];
        Map<Double, ArrayList<int[]>> Freq = new HashMap<>();
        Double num;
        for (int i = 0; i < n; i++) {
            num=Math.sqrt(points[i][0]*points[i][0]+points[i][1]*points[i][1]);
            ArrayList<int[]> list;
            if (Freq.containsKey(num)){
                list=new ArrayList<>(Freq.get(num));
            } else list=new ArrayList<>();
            list.add(points[i]);
            Freq.put(num, list);
        }
        
        ArrayList<Double> sortedKeys
            = new ArrayList<Double>(Freq.keySet());
        Collections.sort(sortedKeys);
        ArrayList<int[]> list;
        k--;
        for (Double x : sortedKeys){
            list=Freq.get(x);
            for(int j=0;j<list.size();j++){
                res[k]=list.get(j);
                k--;
                if(k==-1) return res;
            }
        }
        return res;
    }
}