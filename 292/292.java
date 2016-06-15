
public class Solution {
    public boolean canWinNim(int n) {
		//这道题是一道智力题，推理发现只要是4的倍数就会输，其余情况都会赢，
		//暂时不清楚原理
		if(n % 4 == 0)
			return false;
		else
			return true;
    }
}