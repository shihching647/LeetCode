/**
 *
 * Time complexity: O(1)
 * Space complexity: O(N)
 */
class Twitter {

    private static class Tweet {
        int tweetId;
        int internalTweetId;
        int poster;
        
        public Tweet(int tweetId, int internalTweetId, int poster) {
            this.tweetId = tweetId;
            this.internalTweetId = internalTweetId;
            this.poster = poster;
        }
    }
    
    private int internalId = 0; // Tweet內部編號(用來識別加入的順序)
    private Map<Integer, List<Tweet>> userTweetMap; // 用來記錄使用者所有的Tweets
    private Map<Integer, PriorityQueue<Tweet>> userShowTweetMap; // 用來記錄使用者顯示的Tweets
    private Map<Integer, HashSet<Integer>> userFollowerMap;  // 用來記錄使用者follow那些人
    
    public Twitter() {
        userTweetMap = new HashMap<>();
        userShowTweetMap = new HashMap<>();
        userFollowerMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        checkUser(userId);
        Tweet tweet = new Tweet(tweetId, internalId++, userId);
        userTweetMap.get(userId).add(tweet);
        // 更新所有有follow該使用者的顯示tweets
        for (Map.Entry<Integer, HashSet<Integer>> entry : userFollowerMap.entrySet()) {
            if (entry.getValue().contains(userId)) {
                userShowTweetMap.get(entry.getKey()).offer(tweet);
            }
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        checkUser(userId);
        List<Tweet> list = new ArrayList<>();
        HashSet<Integer> followerSet = userFollowerMap.get(userId);
        PriorityQueue<Tweet> pq = userShowTweetMap.get(userId);
        // 取得前10筆資料
        while (list.size() < 10 && !pq.isEmpty()) {
            Tweet tweet = pq.poll();
            // 因為在unfollow時, 並沒有把unfollow用戶的tweet移除, 故在此需要再檢查是否有follow該用戶
            if (followerSet.contains(tweet.poster)) {
                list.add(tweet);
            }
        }
        // 轉換成tweetId, 並加回pq
        List<Integer> result = new ArrayList<>();
        for (Tweet tweet : list) {
            result.add(tweet.tweetId);
            pq.offer(tweet);
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        checkUser(followerId);
        checkUser(followeeId);
        if (userFollowerMap.get(followerId).contains(followeeId))
            return;
        userFollowerMap.get(followerId).add(followeeId);
        // 將followee的所有tweets加到follower的顯示Tweets中
        PriorityQueue<Tweet> pq = userShowTweetMap.get(followerId);
        for (Tweet tweet : userTweetMap.get(followeeId)) {
            pq.offer(tweet);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        checkUser(followerId);
        checkUser(followeeId);
        if (!userFollowerMap.get(followerId).contains(followeeId))
            return;
        // 僅移除關係, 並不移除對應的tweets(在顯示tweets時處理)
        userFollowerMap.get(followerId).remove(followeeId);
    }
    
    // check user是否查詢過, 沒有的話幫他初始化
    private void checkUser(int id) {
        if (!userTweetMap.containsKey(id)) {
            userTweetMap.put(id, new ArrayList<>());
            userShowTweetMap.put(id, new PriorityQueue<>((a, b) -> b.internalTweetId - a.internalTweetId));
            userFollowerMap.put(id, new HashSet<>());
            userFollowerMap.get(id).add(id); // 使用者一定follow自己
        }
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