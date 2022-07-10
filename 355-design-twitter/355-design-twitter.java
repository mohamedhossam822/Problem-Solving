class Twitter {
    int date;
    HashMap<Integer,User> users;
    public Twitter() {
        users=new HashMap<>();
        date=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!users.containsKey(userId)) users.put(userId,new User());
        User curr=users.get(userId);
        curr.tweets.add(new tweet(date,tweetId));
        date++;
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<List<tweet>> listOfTweets=new ArrayList<>();
        if(users.containsKey(userId)){
            User curr=users.get(userId);
            listOfTweets.add(curr.tweets);
            for(Integer follow : curr.Following){
                listOfTweets.add(users.get(follow).tweets);
            }
        }
        return getTopfeed(listOfTweets);
    }
    
    public void follow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)) users.put(followerId,new User());
        if(!users.containsKey(followeeId)) users.put(followeeId,new User());
        User curr=users.get(followerId);
        curr.Following.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)) users.put(followerId,new User());
        if(!users.containsKey(followeeId)) users.put(followeeId,new User());
        User curr=users.get(followerId);
        curr.Following.remove(followeeId);
    }
    
    private List<Integer> getTopfeed(List<List<tweet>> listOfTweets){
        PriorityQueue<tweet> pq=new PriorityQueue<>(10,(t1,t2)->{return t2.date-t1.date;});
        
        for(List<tweet> list:listOfTweets){
            for(tweet Tweet :  list) pq.add(Tweet);
        }
        List<Integer> res=new ArrayList<>();
        int number=10;
        while(number>0 &&  !pq.isEmpty()){
           res.add(pq.poll().id);
            number--;
        } 
        return res;
    }
}

class User{
    LinkedList<tweet> tweets=new LinkedList<>();
    HashSet<Integer> Following=new HashSet<>();
}
class tweet{
    int date;
    int id;
    public tweet(int date,int id){
        this.id=id;
        this.date=date;
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */