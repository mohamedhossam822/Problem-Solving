class Solution {
    HashSet<Integer> visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited=new HashSet<>();
        visit(0,rooms);
        return visited.size()==rooms.size();
    }
    private void visit(int i,List<List<Integer>> rooms){
        visited.add(i);
        int r;
        for(int j=0;j<rooms.get(i).size();j++){
            r=rooms.get(i).get(j);
            if(!visited.contains(r)) visit(r,rooms);
        }
    }
}