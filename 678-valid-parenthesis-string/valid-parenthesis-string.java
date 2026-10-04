class Solution {
    public boolean checkValidString(String s) {
        int open = 0;
        int maxopen = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                open++;
                maxopen++;

            }else if(c == ')'){
                open--;
                maxopen--;

            }else{
                open--;
                maxopen++;
            }
            if(maxopen < 0){
                return false;
            }

            open = Math.max(0, open);
        } 
        return open == 0;
    }
}