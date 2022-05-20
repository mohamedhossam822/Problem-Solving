class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        HashSet<Integer> vertices=new HashSet<>(n);
        for(int i=0;i<n;i++){
            vertices.add(i);
        }
        for(int i=0;i<edges.size();i++){
            vertices.remove(edges.get(i).get(1));
        }
        return  new ArrayList<Integer>(vertices);
    }
}