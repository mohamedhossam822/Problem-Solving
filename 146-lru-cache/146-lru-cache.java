class Node{
    int key;
    int val;
    Node next;
    Node prev;
    public Node(int key,int val){
        this.key=key;
        this.val=val;
    }
}
class LRUCache {
    //Value Mappings
    HashMap<Integer,Node> Map;
    Node left,right;
    int capacity;
    int size=0;
    public LRUCache(int capacity) {
        Map= new HashMap<>();
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(!Map.containsKey(key))return -1;
        Node currNode=Map.get(key);
        if(right!=currNode){
            remove(currNode);
            add(currNode);
        }
        return currNode.val;
    }
    public void put(int key, int value) {
        //Already existing Node
        Node AddedNode=new Node(key,value);
        if(Map.containsKey(key)){
            remove(Map.get(key));
            size--;
        } 
        
        if(size==capacity){
            Map.remove(left.key);
            remove(left);
            size--;
        }
        
        Map.put(key,AddedNode);
        add(AddedNode);
        size++;
        
    }
    
    private void remove(Node node){
        if(node.prev==null) {
            if(left.next==null){
                left=null;
                right=null;
            }
            else{
                left=node.next;
            left.prev=null;
            }
            
        }
        else {
            if(node.next!=null){
                node.prev.next=node.next;
                node.next.prev=node.prev;
            } 
            else {
                node.prev.next=null;
                right=node.prev;
            }
        }
    }

    private void add(Node node){
        if(right==null) {
            right=node;
            left=node;
            return;
        }
        node.prev=right;
        node.next=null;
        right.next=node;
        right=node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */