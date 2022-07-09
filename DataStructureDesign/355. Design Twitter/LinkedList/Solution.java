/**
 * 使用linked list串接所有tweet, User只記錄head
 * postTweet(): 將tewwt加到user的linked list的最前面
 * getNewsFeed(): 將所有follower的第一筆加到PriorityQueue裡(用internalTweetId比較), 之後每poll一筆, 再把next加入
 * 
 * Time complexity: O(1)
 * Space complexity: O(N)
 */
class Twitter {

    private static class Tweet {
        int tweetId;
        int internalTweetId;
        int poster;
        Tweet next; // 使用linked list串接所有tweet
        
        public Tweet(int tweetId, int internalTweetId, int poster) {
            this.tweetId = tweetId;
            this.internalTweetId = internalTweetId;
            this.poster = poster;
        }
        
    }
    
    private class User {
        int userId;
        Tweet head; // 紀錄tweet head
        HashSet<Integer> followers; // 紀錄follow的人
        
        public User(int userId) {
            this.userId = userId;
            followers = new HashSet<>();
            followers.add(userId);
            head = new Tweet(-1, -1, -1);
        }
        
        public boolean hasAnyTweet() {
            return head.next != null;
        }
    }
    
    private int internalId = 0; // Tweet內部編號(用來識別加入的順序)
    private HashMap<Integer, User> userMap;
    
    public Twitter() {
        userMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        User user = checkUser(userId);
        Tweet tweet = new Tweet(tweetId, internalId++, userId);
        // 加到user的linked list的最前面
        Tweet temp = user.head.next;
        user.head.next = tweet;
        tweet.next = temp;
    }
    
    
    public List<Integer> getNewsFeed(int userId) {
        User user = checkUser(userId);
        List<Integer> list = new ArrayList<>();
        // 將所有follower的第一筆加到PriorityQueue裡, 之後每poll一筆, 再把下一筆加入
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.internalTweetId - a.internalTweetId);
        for (Integer id : user.followers) {
            if (checkUser(id).hasAnyTweet()) {
                pq.offer(checkUser(id).head.next);
            }
        }
        // 取得前10筆資料
        while (list.size() < 10 && !pq.isEmpty()) {
            Tweet tweet = pq.poll();
            list.add(tweet.tweetId);
            // 若下一筆不為null, 加到PriorityQueue裡面
            if (tweet.next != null)
                pq.offer(tweet.next);
        }
        return list;
    }
    
    public void follow(int followerId, int followeeId) {
        User follower = checkUser(followerId);
        User followee = checkUser(followeeId);
        follower.followers.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        User follower = checkUser(followerId);
        User followee = checkUser(followeeId);
        follower.followers.remove(followeeId);
    }
    
    // check user是否在userMap中
    private User checkUser(int id) {
        if (!userMap.containsKey(id)) {
            userMap.put(id, new User(id));
        }
        return userMap.get(id);
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