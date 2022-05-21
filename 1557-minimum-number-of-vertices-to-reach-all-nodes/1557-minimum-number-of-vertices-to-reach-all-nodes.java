class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        HashSet<Integer> vertices=new HashSet<>(n);
        for(int i=0;i<n;i++){
            vertices.add(i);
        }
        for(List<Integer> j : edges){
            vertices.remove(j.get(1));
        }
        return  new ArrayList<Integer>(vertices);
    }
}