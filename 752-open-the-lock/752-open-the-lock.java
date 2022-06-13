class Solution {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")) return 0;
        
        int counter=1;
        HashSet<String> visited=new HashSet<>();
        for(int i=0;i<deadends.length;i++) visited.add(deadends[i]);
        
        if(visited.contains("0000")) return -1;
        
        visited.add("0000");
        
        Queue<String> q=new LinkedList<>();
        q.add("0000");
        
        while(!q.isEmpty()){
            int size=q.size();
            while(size>0){
                String lock=q.poll();
                StringBuilder lockBuilder=new StringBuilder(lock);
                String temp;
                char ch;
                for(int i=0;i<4;i++){
                    //Move forward
                    ch=lockBuilder.charAt(i);
                    if(ch=='9') lockBuilder.setCharAt(i,'0');
                    else lockBuilder.setCharAt(i,(char)(ch+1));
                    temp=lockBuilder.toString();
                    if(!visited.contains(temp)){
                        q.add(temp);
                        if(temp.equals(target)) return counter;
                        visited.add(temp);
                    }
                    //Movebackward
                    if(ch=='0') lockBuilder.setCharAt(i,'9');
                    else lockBuilder.setCharAt(i,(char)(ch-1));
                    temp=lockBuilder.toString();
                    if(!visited.contains(temp)){
                        q.add(temp);
                        if(temp.equals(target)) return counter;
                        visited.add(temp);
                    }
                    lockBuilder.setCharAt(i,ch);
                }
                size--;
            }
            counter++;
        }
        
        return -1;
    }
}