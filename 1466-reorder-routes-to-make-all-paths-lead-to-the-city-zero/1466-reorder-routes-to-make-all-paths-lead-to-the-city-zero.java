class Solution {
    public int minReorder(int n, int[][] connections) {
        //Make 2 adj. list point at / being pointed at
        int counter=0;
        List<List<Integer>> IpointAt=new ArrayList<>();
        List<List<Integer>> IpointTo=new ArrayList<>();
        for(int i=0;i<n;i++){
            IpointAt.add(new ArrayList<>());
            IpointTo.add(new ArrayList<>());
        }
        for(int i=0;i<connections.length;i++){
            IpointAt.get(connections[i][0]).add(connections[i][1]);
            IpointTo.get(connections[i][1]).add(connections[i][0]);
        }
        boolean[] visited=new boolean[n];
        visited[0]=true;
        //Make a queue insert 0
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        //BFS
        while(!q.isEmpty()){
            int size=q.size();
            for(int j=0;j<size;j++){
                int temp=q.poll();
                //for every value point is pointing at we increment counter then we add it to the q
                for(int i=0;i<IpointAt.get(temp).size();i++){
                    if(!visited[IpointAt.get(temp).get(i)]){
                        q.add(IpointAt.get(temp).get(i));
                        counter++;
                        visited[IpointAt.get(temp).get(i)]=true;
                    }
                }
                
                // for every value 0 is being point at by we add it to the queue
                for(int i=0;i<IpointTo.get(temp).size();i++){
                    if(!visited[IpointTo.get(temp).get(i)]){
                        q.add(IpointTo.get(temp).get(i));
                        visited[IpointTo.get(temp).get(i)]=true;
                    }
                        
                }
            }
        }
        
        
        return counter;
    }
}