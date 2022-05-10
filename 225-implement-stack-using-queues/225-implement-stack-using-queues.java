import java.util.Queue;
class MyStack {
    int counter;
    Queue<Integer> q1= new LinkedList<>();
    Queue<Integer> q2= new LinkedList<>();
    public MyStack() {
        counter=0;
    }
    
    public void push(int x) {
        if(q1.isEmpty()) q2.add(x);
        else q1.add(x);
        counter++;
    }
    
    public int pop() {
        if(q1.isEmpty()){
            for(int i=1;i<counter;i++){
                q1.add(q2.poll());
            }
            counter--;
            return q2.poll();
        } 
        else{
            for(int i=1;i<counter;i++){
                q2.add(q1.poll());
            }
            counter--;
            return q1.poll();
        }
    }
    
    public int top() {
        int x=0;
        if(q1.isEmpty()){
            for(int i=0;i<counter;i++){
                x=q2.poll();
                q1.add(x);
            }
        } 
        else{
            for(int i=0;i<counter;i++){
                x=q1.poll();
                q2.add(x);
            }
        }
        return x;
        
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */