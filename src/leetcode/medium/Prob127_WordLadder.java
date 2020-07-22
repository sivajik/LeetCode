package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
/*
 * I gave up on this finally :( :(
 */
public class Prob127_WordLadder {

	public static void main(String[] args) {

		List<String> l1 = new ArrayList<>();
		l1.addAll(Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log", "cog" }));
		System.out.println(ladderLength("hit", "cog", l1));

		List<String> l2 = new ArrayList<>();
		l2.addAll(Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log" }));
		System.out.println(ladderLength("hit", "cog", l2));

		List<String> l3 = new ArrayList<>();
		l3.addAll(Arrays.asList(new String[] { "hot", "dog" }));
		System.out.println(ladderLength("hot", "dog", l3));

		List<String> l4 = new ArrayList<>();
		l4.addAll(Arrays.asList(new String[] { "a", "b", "c" }));
		System.out.println(ladderLength("a", "c", l4));

		List<String> l5 = new ArrayList<>();
		l5.addAll(Arrays.asList(new String[] { "hot", "cog", "dot", "dog", "hit", "lot", "log" }));
		System.out.println(ladderLength("hit", "cog", l5));

	}

	static public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> set = new HashSet<>();
		for (String s : wordList) {
			set.add(s);
		}

		if (!set.contains(endWord)) {
			return 0;
		}

		return ladderLength1(beginWord, endWord, set);
	}
	
	public static  int ladderLength1(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> queue = new LinkedList<String>();
       
        // count maintains the number of levels we moved in the graph. 
        int count = 1;
        
        // Return value
        int ret = 1; 

        // Queue the begin word
        queue.offer(beginWord);
        wordList.add(endWord);
        wordList.remove(beginWord);
        while(!queue.isEmpty()) {
            String top = queue.poll();
            count--;
            Set<String> neighbors = neighbors(top.toCharArray(), wordList);
            if(neighbors.contains(endWord)) {
                return ret + 1;
            }
            for(String neighbor : neighbors) {
                queue.offer(neighbor);
            }
           
            if(count == 0) {
                ret++;
                count = queue.size();
            }
        }
        return 0;
    }
	
	private static Set<String> neighbors(char[] word, Set<String> wordList) {
        Set<String> ret = new HashSet<String>();
        for(int i = 0; i < word.length; i++) {
            char c = word[i];
            
            for(char j = 'a'; j <= 'z'; j++) {
                word[i] = j;
                String finalWord = String.valueOf(word);
                if(wordList.contains(finalWord)) {
                    ret.add(finalWord);
                    wordList.remove(finalWord);
                }
            }
            word[i] = c;
        }
        return ret;
    }
}
