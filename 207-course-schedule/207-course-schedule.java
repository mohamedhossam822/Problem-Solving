class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courses=new ArrayList<>(numCourses);
        int[] status=new int[numCourses];
        //0 Need to take
        //1 pending
        //2 Took
        for(int i=0;i<numCourses;i++) courses.add(new ArrayList<>());
        
        for(int[] arr : prerequisites) courses.get(arr[0]).add(arr[1]);
        
        for(int i=0;i<numCourses;i++)
            if(!dfs(i,courses,status)) return false;
        return true;
    }
    private boolean dfs(int i,List<List<Integer>> courses,int[] status){
        if(status[i]==2) return true;
        if(status[i]==1) return false;
        status[i]=1;
        for(Integer preCourse : courses.get(i)){
            if(!dfs(preCourse,courses,status)) return false;
        }
        status[i]=2;
        return true;
    }
    
}