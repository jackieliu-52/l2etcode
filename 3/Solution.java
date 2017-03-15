/*
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * 找到这个字符串的最长子串（没有重复的字母【应该要考虑大小写】），返回它的长度 
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() ==0)
            return 0;
        int[] hash = new int[256];
        int answer = 0; //最大长度
        int len = s.length();
        char[] chars = s.toCharArray();
        int left = 0,right = 0;
        int count = 0; //保存每次的最大长度
        while(right < len){
            if(hash[chars[right]] == 0){
                //说明还没到最长子串
                hash[chars[right]]++; //记录这个出现的字母
                right++;
                count++;
                answer = count > answer? count : answer;
            }else{
                //已经出现了重复字母了
                hash[chars[left]]--; 
                left++;
                count--; //重新计算
            }
        }

        return answer;
		
    }
}