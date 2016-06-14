public class Solution {
    public int[] countBits(int num) {
		int[] nums = new int[num + 1];    
        for(int i = 0;i <= num ;i++)
			nums[i] = countBit(i); 
		return nums;
    }
	
	public static int countBit(int i){
		if(i == 0)
			return 0;
		//看看它是不是2的N次方，是的话，返回1
		double n = Math.log(i)/Math.log(2);  //判断n是不是整数
		if(n % 1 == 0)
			return 1;
		//最容易想到的方法
		int in = (int)n;   //截去整数部分
		int count = 1;
		i -= Math.pow(2.0,in); 
		for(int m = in-1;m >= 0;m--){
			int rest = (int)(i - Math.pow(2.0,m));
			if(rest == 0){
				count++;	
				break; 
			}
			else if(rest > 0){
				count++;
				i = rest;
			}
			else{
				continue;
			}
		}//for
		return count;
	}
}