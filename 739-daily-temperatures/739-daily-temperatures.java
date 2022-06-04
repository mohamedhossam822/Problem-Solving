class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> indexStack=new Stack<>();
        int[] answer=new int[temperatures.length];
        int index;
        //Travers array
        for(int i=0;i<temperatures.length;i++){
            while(!indexStack.empty()){
                if(temperatures[i]>temperatures[indexStack.peek()]){
                    index= indexStack.pop();
                    answer[index]=i-index;
                }
                else break;
            }
            indexStack.push(i);
        }
        return answer;
        
    }
}