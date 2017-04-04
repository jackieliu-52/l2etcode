public class Solution {
    public boolean detectCapitalUse(String word) {
        if(null == word || word.length() == 0)
			return false;
		char firstChar = word.charAt(0);
		if(checkChar(firstChar))){
			//要么全是大写，要么后面全是小写
			boolean flag = true;
			for(int i = 1;i < word.length();i++)
				if(!checkChar(word.charAt(i))){
					flag = false;
					break;
				}
			
			return flag;
		}else{
			return false;
		}
    }
	public boolean checkChar(char c){
		return c >= 'A' && c <= 'Z';
	}
}