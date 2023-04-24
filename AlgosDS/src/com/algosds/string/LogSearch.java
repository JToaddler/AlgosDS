package com.algosds.string;

/**
 * https://www.youtube.com/watch?v=Nj2Bpw1KKds
 * 
 * For this problem, we must sort log strings based on a variety of rules. There
 * are two types of log strings: letter logs and digit logs. Letter logs contain
 * a unique id separated with a space to the rest of the log portion. The log
 * portion contains only lower case letters; however, a digit log contains only
 * digits. The rules we must implement our comparator class by are as follows:
 * letter logs always come before digit logs, letter logs are sorted
 * lexicographically, if letter logs are equal we must sort by the id
 * lexicographically, and digit logs should maintain their order.
 * 
 * The time complexity for our algorithm is big oh O(N*log(N)) where N is the
 * number of elements we have in our array. Under the hood, the array sort uses
 * a dual pivot quick sort algorithm which is due to the use of sorting
 * primitives. If we were not sorting primitives, the sort function would use
 * TimSort. The space complexity is big oh O(log(N)) since quick sort must
 * utilize recursive calls to apply sorting.
 * 
 *
 * time complexity O(N*log(N))
 * 
 */
public class LogSearch {
	
	

}
