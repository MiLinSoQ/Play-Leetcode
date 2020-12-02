/**
	Url: https://leetcode.com/problems/design-twitter/
	Author: MiLinSoQ
	Time: 2020-12-02
	Title: Design Twitter
	No: 355
*/
import java.util.*;
/**
	設計一個簡易的 Twitter ，可以讓使用者發文、追蹤、退追蹤、查詢10條最新的發文。
	實踐以下功能：
	1. void postTweet(int userId, int tweetId)
	2. List<Integer> getNewsFeed(int userId) 			取的 user 的10條最新發文
	3. void follow(int followerId, int followeeId)
	4. void unfollow(int followerId, int followeeId)
	
	HashSet 定義：內容不重複。
	
	EX: 
		Twitter twitter = new Twitter();

		// User 1 posts a new tweet (id = 5).
		twitter.postTweet(1, 5);

		// User 1's news feed should return a list with 1 tweet id -> [5].
		twitter.getNewsFeed(1);

		// User 1 follows user 2.
		twitter.follow(1, 2);

		// User 2 posts a new tweet (id = 6).
		twitter.postTweet(2, 6);

		// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
		// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
		twitter.getNewsFeed(1);

		// User 1 unfollows user 2.
		twitter.unfollow(1, 2);

		// User 1's news feed should return a list with 1 tweet id -> [5],
		// since user 1 is no longer following user 2.
		twitter.getNewsFeed(1);

*/
public class Solution {
	
	public static void main(String args[]) {
		
		Twitter tw = new Twitter();
		
		tw.postTweet(1, 5);
		
		tw.postTweet(1, 3);
		
		tw.follow(1, 2);
		
		tw.postTweet(2, 100);
		
		List<Integer> feeds = tw.getNewsFeed(1);
		
		for (int i = 0; i < feeds.size(); i ++) {
			System.out.print(", " + feeds.get(i));
		}
		
		// tw.follow(1, 2);
		// tw.postTweet(3, 6);
		
		// List<Integer> feeds = tw.getNewsFeed(1);
		// for (int i = 0; i < feeds.size(); i ++) {
			// System.out.print(", " + feeds.get(i));
		// }
		
		// tw.postTweet(2, 5);
		
		// tw.follow(1, 2);
		
		// System.out.println(tw.toString());
		
	}
}

class Twitter {

	class User {
		
		public int id;
		
		// private List<Integer> tweets;
		
		private Set<User> followed;
		
		private int[] flo;
		
		public User(int id) {
			this.id = id;
			// this.tweets = new ArrayList<Integer>();
			this.followed = new HashSet();
		}
		
		// public List<Integer> getTweets() { return this.tweets; }
		
		// public void postTweet(int tweetId) {
			// if (this.tweets.contains(tweetId)) return;
			// this.tweets.add(tweetId);
		// }
		
		public void follow(User user) {
			if (user == null) return;
			if (this.followed.contains(user)) return;
			this.followed.add(user);
		}
		
		public void unfollow(User user) {
			if (user == null)return;
			if (!this.followed.contains(user)) return;
			this.followed.remove(user);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null) return false;
			if (getClass() != o.getClass()) return false;
			
			final User u = (User) o;
			return (this.id == u.id);
		}
		
		@Override
		public int hashCode() {
			int B = 7;
			int hash = 0;
			hash = hash * B + this.id;
			return hash;
		}
		
		@Override 
		public String toString() {
			StringBuilder res = new StringBuilder();
			res.append(String.format("User id: %d\n", id));
			// res.append(String.format("Has %d tweet.\n", this.tweets.size()));
			// res.append("[ ");
			// for (Integer tId : this.tweets) {
				// res.append(tId + ", ");
			// }
			// res.append(" ].\n");
			return res.toString();
		}
	}
	
	
	class Tweet {
		
		public int id;
		public User poster;
		public Tweet next;
		
		public Tweet(int id, User user, Tweet next) {
			this.id = id;
			this.poster = user;
			this.next = next;
		}
		
		public Tweet(int id, User user) {
			this(id, user, null);
		}
		
		@Override
		public String toString() {
			StringBuilder res = new StringBuilder();
			res.append(String.format("Id: %d", this.id));
			res.append(String.format(", Poster: %d.\n", this.poster.id));
			return res.toString();
		}
	}
	
	private Set<User> users;
	
	private Tweet tweet;

    /** Initialize your data structure here. */
    public Twitter() {
        this.users = new HashSet();
		this.tweet = null;
		// this.tweets = new ArrayList<Integer>();
    }
    
	public User getUser(int userId) {
		for (User user : this.users) {
			if (user.id == userId) return user;
		}
		User newUser = new User(userId);
		this.users.add(newUser);
		return newUser;
	}
	
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
		User user = getUser(userId);
		Tweet tweet = new Tweet(tweetId, user);
		if (this.tweet == null) {
			this.tweet = tweet;
		} else {
			tweet.next = this.tweet;
			this.tweet = tweet;
		}
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
		List<Integer> feeds = new ArrayList<Integer>();
		User user = getUser(userId);
		Tweet curTweet = this.tweet;
		
		while (curTweet != null && feeds.size() < 10) {
			
			System.out.println(curTweet.toString());
			
			if (curTweet.poster.id == userId || user.followed.contains(curTweet.poster)) {
				feeds.add(curTweet.id);
			}
			
			curTweet = curTweet.next;
		}
		Collections.reverse(feeds);
        return feeds;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        User follower = getUser(followerId);
		User followee = getUser(followeeId);
		follower.follow(followee);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        User follower = getUser(followerId);
		User followee = getUser(followeeId);
		follower.unfollow(followee);
    }
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Twitter\n");
		res.append(String.format("User size %d.", this.users.size()));
		return res.toString();
	}
}

 