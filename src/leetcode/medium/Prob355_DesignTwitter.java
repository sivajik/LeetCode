package leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Prob355_DesignTwitter {

	public static void main(String[] args) {
		Twitter twitter = new Twitter();
		// User 1 follows user 2.
		twitter.follow(1, 5);

		twitter.getNewsFeed(1);

	}

	static class Twitter {
		Map<Integer, Set<Integer>> fans = new HashMap<>();
		int timeStamp = 0;
		Map<Integer, LinkedList<Tweet>> tweets = new HashMap<>();

		public Twitter() {

		}

		public void postTweet(int userId, int tweetId) {

			if (fans.get(userId) == null) {
				fans.put(userId, new HashSet<>());
			}
			fans.get(userId).add(userId); // need to pull his own + followers tweets.

			if (tweets.get(userId) == null) {
				tweets.put(userId, new LinkedList<>());
			}
			tweets.get(userId).addFirst(new Tweet(timeStamp++, tweetId));
		}

		public List<Integer> getNewsFeed(int userId) {
			if (fans.get(userId) == null) {
				return new ArrayList<>();
			}

			PriorityQueue<Tweet> p = new PriorityQueue<>(new Comparator<Tweet>() {
				public int compare(Tweet o1, Tweet o2) {
					// TODO Auto-generated method stub
					return -o1.time + o2.time;
				}
			});

			Set<Integer> allCelbsWeFollow = fans.get(userId);
			for (Integer eachCeleb : allCelbsWeFollow) {
				LinkedList<Tweet> userTweets = tweets.get(eachCeleb);
				if (userTweets != null) {
					for (Tweet tweet : userTweets) {
						p.add(tweet);
						if (p.size() > 10) {
							p.poll();
						}
					}
				}
			}

			List<Integer> list = new ArrayList<>();

			while (!p.isEmpty()) {
				list.add(p.poll().id);
			}
			System.out.println(list);
			return list;
		}

		public void follow(int followerId, int followeeId) {
			if (fans.get(followerId) == null) {
				fans.put(followerId, new HashSet<>());
			}
			fans.get(followerId).add(followeeId);
		}

		public void unfollow(int followerId, int followeeId) {
			if (fans.containsKey(followerId) && followerId != followeeId) {
				fans.get(followerId).remove(followeeId);
			}
		}
	}

	static class Tweet {
		int time;
		int id;

		Tweet(int time, int id) {
			this.time = time;
			this.id = id;
		}
	}
}
