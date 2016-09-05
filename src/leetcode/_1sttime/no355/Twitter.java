package leetcode._1sttime.no355;

import java.util.*;

public class Twitter {
    private static class Tweet implements Comparable<Tweet> {
        private static int TIME_STAMP = 0;
        static Tweet DUMMY_TWEET = new Tweet(-1, null);
        final int timestamp;
        final int tweetId;
        final User user;
        Tweet(int tweetId, User user) {
            this.user = user;
            this.tweetId = tweetId;
            timestamp = TIME_STAMP++;
        }

        @Override
        public int compareTo(Tweet o) {
            return Integer.compare(o.timestamp, timestamp);
        }

        @Override
        public String toString() {
            return "Tweet{" +
                    "timestamp=" + timestamp +
                    ", tweetId=" + tweetId +
                    ", user=" + user.id +
                    '}';
        }
    }

    private static class User implements Comparable<User> {
        static PriorityQueue<User> PQ = new PriorityQueue<>();
        Tweet top = Tweet.DUMMY_TWEET;
        final int id;
        int idx = -1;
        List<Tweet> tweets = new ArrayList<>();
        Set<User> followees = new HashSet<>();

        private User(int id) {
            this.id = id;
        }

        void follow(User followee) {
            if (followee == this) return;
            followees.add(followee);
        }

        void unfollow(User followee) {
            followees.remove(followee);
        }

        void postTweet(int tweetId) {
            tweets.add(new Tweet(tweetId, this));
            resetTop();
        }

        void resetTop() {
            idx = tweets.size() - 1;
            nextTweet();
        }

        void nextTweet() {
            if (idx < 0) top = Tweet.DUMMY_TWEET;
            else top = tweets.get(idx--);
        }

        List<Integer> getNewsFeed() {
            List<Tweet> res = new LinkedList<>();
            PQ.clear();
            PQ.addAll(followees);
            PQ.add(this);
            for (int i = 0; i < 10; i++) {
                User followee = PQ.poll();
                if (followee.top == Tweet.DUMMY_TWEET) break;
                res.add(followee.top);
                followee.nextTweet();
                PQ.add(followee);
            }

            List<Integer> ret = new ArrayList<>(res.size());
            for (Tweet t : res) {
                t.user.resetTop();
                ret.add(t.tweetId);
            }
            return ret;
        }

        @Override
        public int compareTo(User o) {
            return top.compareTo(o.top);
        }

        @Override
        public String toString() {
            return "User{" +
                    "top=" + top +
                    ", id=" + id +
                    '}';
        }
    }

    private Map<Integer, User> users;

    /** Initialize your data structure here. */
    public Twitter() {
        users = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        User user = getUserById(userId);
        user.postTweet(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        User user = getUserById(userId);
        return  user.getNewsFeed();
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        User follower = getUserById(followerId);
        User followee = getUserById(followeeId);
        follower.follow(followee);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        User follower = getUserById(followerId);
        User followee = getUserById(followeeId);
        follower.unfollow(followee);
    }

    private User getUserById(int userId) {
        User user = users.get(userId);
        if (user == null) {
            user = new User(userId);
            users.put(userId, user);
        }
        return user;
    }

    public static void main(String[] args) {
        parse();
//        twitter.postTweet(1, 11);
//        twitter.postTweet(2, 21);
//        twitter.postTweet(2, 22);
//        twitter.postTweet(1, 12);
//        twitter.follow(1, 2);
//        System.out.println(twitter.getNewsFeed(1));
//        twitter.unfollow(1, 2);
//        System.out.println(twitter.getNewsFeed(1));
    }

    private static void parse() {
        Twitter twitter = new Twitter();
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String data = scanner.nextLine();
        String[] datas = data.split(",");
        int idx = 0;
        for (String cmd : command.split(",")) {
            switch (cmd) {
                case "postTweet":
                    twitter.postTweet(Integer.parseInt(datas[idx++]), Integer.parseInt(datas[idx++]));
                    break;
                case "unfollow":
                    twitter.unfollow(Integer.parseInt(datas[idx++]), Integer.parseInt(datas[idx++]));
                    break;
                case "follow":
                    twitter.follow(Integer.parseInt(datas[idx++]), Integer.parseInt(datas[idx++]));
                    break;
                case "getNewsFeed":
                    System.out.println(twitter.getNewsFeed(Integer.parseInt(datas[idx++])));
                    break;
            }
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