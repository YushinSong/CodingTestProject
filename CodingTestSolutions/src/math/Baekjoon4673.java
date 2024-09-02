package src.math;

public class Baekjoon4673 {
    public static void main(String[] args) {
        boolean[] arr = new boolean[10000];
        for(int i = 1; i < 10000; ++i){
            int number = d(i);
            if(number < 10000)
                arr[number] = true;
        }
        for(int i = 1; i < 10000; ++i) {
            if(!arr[i])
                System.out.println(i);
        }
    }

    public static int d(int n){
        int result = n;
        while(n > 0){
            result += n % 10;
            n /= 10;
        }
        return result;
    }
}
