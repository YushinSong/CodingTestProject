package src.array;

public class LeetCodeIntegerToRoman {
    class Solution {
        public String intToRoman(int num) {
            String answer = "";
            String[] powerTen = new String[]{"I", "X", "C", "M"};
            String[] powerfive = new String[]{"V", "L", "D"};

            int pos = 0;
            while(num > 0){
                String posRoman = "";
                int number = num % 10;
                num /= 10;

                if(number == 9){
                    posRoman = powerTen[pos] + powerTen[pos+1];
                }else if(number == 4){
                    posRoman = powerTen[pos] + powerfive[pos];
                }else{
                    if(number >= 5){
                        number -= 5;
                        posRoman = powerfive[pos];
                    }

                    for(int i = 0; i < number; ++i){
                        posRoman += powerTen[pos];
                    }
                }

                answer = posRoman + answer;
                ++pos;
            }

            return answer;
        }
    }
}
