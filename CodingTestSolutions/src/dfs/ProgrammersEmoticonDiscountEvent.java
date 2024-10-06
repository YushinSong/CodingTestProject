package src.dfs;

public class ProgrammersEmoticonDiscountEvent {
    class Solution {
        public int[] answer = new int[2];
        public int[] solution(int[][] users, int[] emoticons) {

            dfs(users, emoticons, new int[emoticons.length], 0);

            return answer;
        }
        public void dfs(int[][] users, int[] emoticons, int[] percents, int index){
            if(index == percents.length){
                calculate(users, emoticons, percents);
                return;
            }

            for(int i = 10; i <= 40; i+=10){
                percents[index] = i;
                dfs(users, emoticons, percents, index+1);
            }
        }

        public int[] calculate(int[][] users, int[] emoticons, int[] percent){
            int[] calculateResult = new int[2];

            for(int[] user : users){
                int price = 0;
                for(int i = 0; i < emoticons.length; ++i){
                    if(user[0] > percent[i])
                        continue;
                    price += emoticons[i] - (emoticons[i] * percent[i] / 100);
                }

                if(user[1] <= price)
                    calculateResult[0]++;
                else
                    calculateResult[1] += price;
            }

            if((answer[0]<calculateResult[0]) ||
                    (answer[0]==calculateResult[0] && answer[1]<calculateResult[1]))
                answer = calculateResult;

            return calculateResult;
        }
    }
}
