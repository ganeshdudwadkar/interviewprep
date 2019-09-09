package leetcode.easy;

// Paint Fences (LC 276) -> locked

public class PaintFences {

    public int numWays(int n, int k) {
        if(n == 0 || k == 0) return 0;
        int[] dp = new int[n];
        dp[0] = k;
        if (n>1){
            dp[1] = k*k;
        }
        for(int i = 2; i < n; i++){
            dp[i] = dp[i-1]*(k-1) + dp[i-2]*(k-1);
        }
        return dp[n-1];
    }

}

class Runner{

    public static void main(String[] args){
        PaintFences obj = new PaintFences();
        System.out.println(obj.numWays(5, 3));
        System.out.println(obj.numWays(7, 2));
    }
}