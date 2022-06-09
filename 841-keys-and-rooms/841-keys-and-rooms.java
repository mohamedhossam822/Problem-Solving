class Solution {
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited=new boolean[rooms.size()];
        visit(0,rooms,visited);
        for(boolean isVisited: visited) if(!isVisited) return false;
        return true;
    }
    private void visit(int room,List<List<Integer>> rooms,boolean[] visited){
        visited[room]=true;
        List<Integer> keys=rooms.get(room);
        int roomKey;
        for(int j=0;j<keys.size();j++){
            roomKey=keys.get(j);
            if(!visited[roomKey]) visit(roomKey,rooms,visited);
        }
    }
}