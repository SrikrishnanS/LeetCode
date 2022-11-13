/*
355. Design Twitter

Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.

Implement the Twitter class:

Twitter() Initializes your twitter object.
void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. Each call to this function will be made with a unique tweetId.
List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.

*/

class Twitter 
{
    public static final int MAX_FEEDS = 10;
    
    // user -> set of users followed
    private Map<Integer, Set<Integer>> followers;
 
    // user -> set of user's tweets
    private Map<Integer, Set<int[]>> tweets;

    // max Q for posting tweets to a user
    private Queue<int[]> feedQ;
    
    // counter to keep track of timeline
    private static int count = 0;
    
    public Twitter() 
    {
        followers = new HashMap<Integer, Set<Integer>>();
        tweets    = new HashMap<Integer, Set<int[]>>();
        feedQ     = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
    }
    
    public void postTweet(int userId, int tweetId) 
    {
        ++Twitter.count;
        follow(userId, userId); // self follow
        tweets.putIfAbsent(userId, new HashSet<int[]>());
        tweets.get(userId).add(new int[]{Twitter.count, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) 
    {
        Set<Integer> users = followers.get(userId);
        List<Integer> feeds;
        
        feedQ.clear(); // reset on every call
        
        if (users != null)
            for (int  u : users)
            {
                Set<int[]> posts = tweets.get(u);

                if (posts != null)
                    for (int[] t : posts)
                    {
                        feedQ.offer(t);
                        if (feedQ.size() > MAX_FEEDS)
                            feedQ.poll();
                    }
            }
        feeds = new LinkedList<Integer>();
        
        while (!feedQ.isEmpty())
            feeds.add(0, feedQ.poll()[1]);
            
        return feeds;
    }

    public void follow(int followerId, int followeeId) 
    {
        // followerId follows followeeId
        followers.putIfAbsent(followerId, new HashSet<Integer>());
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) 
    {
        // followerId does not follow followeeId anymore
        followers.get(followerId).remove(followeeId);
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
