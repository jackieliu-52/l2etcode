public class Solution {
    public String reverseString(String s) {
		//利用2个指针，去交换
        char[] a = s.toCharArray();
		int left = 0,right = s.length()-1;
		while(left < right){
			char temp = a[left];
			a[left] = a[right];
			a[right] = temp;
			left++;right--;
		}
		return String.valueOf(a);
    }
}