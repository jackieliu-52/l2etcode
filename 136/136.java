public class Solution {
    public int singleNumber(int[] nums) {
        //数组中数字都出现2次，必须要在线性时间内，找到一个只出现过一次的数字，不使用多余空间
		int result = 0;
		for(int i = 0;i < nums.length;i++){
			//苦思没有想法，就去讨论区看到了一个挺好的结果，利用异或运算来处理
			//因为我们知道异或是这样的 1^1=0(也就是相同的数会抵消) 所以只需要遍历完所有的数字之后
			//剩下的必定是那个只有一个存在的数字
			result = result ^ nums[i];
		}
		return result;
    }
}