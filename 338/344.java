public class Solution {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();  //转换为char数组
		int length = chars.length;
		char[] newchar = new char[length];  //新的字符串
		for(int i = 0 ;i < length; i++){
			newchar[i] = chars[(length - 1) - i];
			if(i == ((length - 1) -i) )
				continue; //跳过
		}
		return String.valueOf(newchar); 
    }
}