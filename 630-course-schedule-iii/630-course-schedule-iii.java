class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a, b) -> a[1]-b[1]);
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        int day=0;
        for(int i=0;i<courses.length;i++)
        {
            if(day+courses[i][0]<=courses[i][1]){
                day+=courses[i][0];
                maxHeap.add(courses[i][0]);
            }else{
                if(maxHeap.size()==0) continue;
                int longestCourse=maxHeap.peek();
                if(courses[i][0]<longestCourse && day+courses[i][0]-longestCourse<=courses[i][1]){
                    maxHeap.poll();
                    day-=longestCourse;
                    day+=courses[i][0];
                    maxHeap.add(courses[i][0]);
                }
                
            }
        }
        return maxHeap.size();
    }
}