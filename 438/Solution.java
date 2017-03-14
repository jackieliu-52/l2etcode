/* Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * 给定一个字符串S和一个非空字符串p，在s中找到p所有颠倒的形式的下标。
 * 例如Input:
 *     s: "cbaebabacd" p: "abc"
 *
 *     Output:
 *     [0, 6]
 */
public class Solution {
     public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;

        int[] hash = new int[256]; //因为题目要求是全小写字母，char足够了，下标就是自己的值

        //记录p中字母出现的次数
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //2个指针，并且初始化count为p的长度
        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            //每次都将右边的指针进行移动，如果右指针指向的字符在p中存在，count就-1
            //hash value >= 1 意味着这个字符依旧还在p中存在
            if (hash[s.charAt(right)] >= 1) {
                count--;
            }
            hash[s.charAt(right)]--;      //这个字符已经出现过了
            right++;

            //当count变为0的时候，就意味着我们找到了这个正确的结果
            if (count == 0) {
                list.add(left);
            }
            //如果我们发现右-左的长度已经和p的长度相等了，那么说明应该把左边的指针向右边移动了
            //同时应该复原count，如果left指针指向字符的hash值大于等于0，说明这个字符在p中存在,否则应该为负数
            if (right - left == p.length() ) {

                if (hash[s.charAt(left)] >= 0) {
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;

            }


        }
        return list;
    }
}