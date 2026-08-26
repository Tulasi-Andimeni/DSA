class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

                String answer = "";

        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {

            int ones = 0;

            for (int j = i; j < s.length(); j++) {

                if (s.charAt(j) == '1') {
                    ones++;
                }

               
                if (ones == k) {

                    String current = s.substring(i, j + 1);

                    if (current.length() < minLength) {
                        minLength = current.length();
                        answer = current;
                    }

                    
                    else if (current.length() == minLength
                            && current.compareTo(answer) < 0) {
                        answer = current;
                    }

                   
                    break;
                }
            }
        }

        return answer;
        
    }
}