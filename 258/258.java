public class Solution {
    public int addDigits(int num) {
        //这大概是一个比较偏 发现规律的数学题，如果用普通的循环破解是很简单的
		//- -然而看了半天看不出有什么规律，就看了提示，有一篇wiki上讲述了规则
		//大概的意思就是，如果一个数字是9的倍数，那么他的这个返回值就是9
		//如果这个数返回值是1，那么它一定是9的倍数+1 ，以此类推
		if( num == 0)
			return 0;
		int multiple9 = (int)(Math.floor(num / 9.0) * 9);
		if(num == multiple9)
			return 9;
		else
			return num - multiple9;
    }
}