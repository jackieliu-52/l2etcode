public class Solution {
    public int myAtoi(String str) {
         int i = 0;
         str = str.trim();        //去除空格
         char[] c = str.toCharArray(); 
         
         int sign = 1;  //表示符号位
         if (i < c.length && (c[i] == '-' || c[i] == '+')) {
             if (c[i] == '-') {
                 sign = -1;
             }
             i++;     
         }      
         
         int num = 0;
		 //如果这个数字超过边界的话，那么要在这一位阻止它
         int bound = Integer.MAX_VALUE / 10;
         while (i < c.length && c[i] >= '0' && c[i] <= '9') {  //判断是否是数字
             int digit = c[i] - '0';
			 //num是否超出边界，很好的利用了逻辑短路
             if (num > bound || (num == bound && digit > 7)) {
                 return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
             }
             num = num * 10 + digit;
             i++;
         }
         return sign * num;
		
    }
}