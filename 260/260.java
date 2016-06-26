public class Solution {
	//第一遍遍历的时候，可以得到这两个数字异或的结果，用Xor保存下来
	//因为两个数字是不一样的，又因为xor的结果是不同的位得到1，所以我们取出其中任意的一个标志位
	//这里标志位可以选取最右边的那个位
	//然后第二次遍历的过程中，我们就可以把所有的数字划分为两组
	//一组是我们选取标志位上为1的，另一组就是我们选取标志位上不为1的
	//然后再去与原数组进行异或操作，就可以得到结果了
    public int[] singleNumber(int[] nums) {
    int result[] = new int[2];        
    int xor = nums[0];
    for (int i=1; i<nums.length; i++)
    {
        xor ^= nums[i];
    }

    int bit = xor & -xor;
    int num1 = 0;
    int num2 = 0;

    for (int num : nums)
    {
        if ((num & bit) > 0)
        {
            num1 ^= num;
        }
        else
        {
            num2 ^= num;
        }
    }

    result[0] = num1;
    result[1] = num2;
    return result;
}
}