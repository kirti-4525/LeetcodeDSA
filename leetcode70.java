public class leetcode70{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n=3;
        int result=solution.climbStairs(n);
        System.out.println("result is: "+ result);
    }
}

// 1.The recursive solution uses the concept of Fibonacci numbers to solve the problem. 
// It calculates the number of ways to climb the stairs by recursively calling the climbStairs function
// for (n-1) and (n-2) steps. However, this solution has exponential time complexity (O(2^n)) due to redundant calculations.


// class Solution {
//     public int climbStairs(int n) {
//         if (n == 0 || n == 1) {
//             return 1;
//         }
//         return climbStairs(n-1) + climbStairs(n-2);
//     }
// }


// 2. Memoization an unordered map (memo) to store the already computed results for each step n. Before making a recursive call, we check if the result for the given n exists in the memo. 
// class Solution {
//     public int climbStairs(int n) {
//         Map<Integer, Integer> memo = new HashMap<>();
//         return climbStairs(n, memo);
//     }
    
//     private int climbStairs(int n, Map<Integer, Integer> memo) {
//         if (n == 0 || n == 1) {
//             return 1;
//         }
//         if (!memo.containsKey(n)) {
//             memo.put(n, climbStairs(n-1, memo) + climbStairs(n-2, memo));
//         }
//         return memo.get(n);
//     }
// }



// 3. Tabulation  solution eliminates recursion and uses a bottom-up approach to solve the problem iteratively.
// It creates a DP table (dp) of size n+1 to store the number of ways to reach each step. 
// The base cases (0 and 1 steps) are initialized to 1 since there is only one way to reach them. 
// Then, it iterates from 2 to n, filling in the DP table by summing up the values for the previous two steps. 
// Finally, it returns the value in the last cell of the DP table, which represents the total number of ways to reach the top.

// class Solution {
//     public int climbStairs(int n) {
//         if (n == 0 || n == 1) {
//             return 1;
//         }

//         int[] dp = new int[n+1];
//         dp[0] = 1;
//         dp[1] = 1;

        
//         for (int i = 2; i <= n; i++) {
//             dp[i] = dp[i-1] + dp[i-2];
//         }
//         return dp[n];
//     }
// }



// 4. The space-optimized solution further reduces the space complexity by using only two variables (prev and curr)
//  instead of an entire DP table. It initializes prev and curr to 1 since 
//  there is only one way to reach the base cases (0 and 1 steps). Then, in each iteration, 
//  it updates prev and curr by shifting their values. curr becomes the sum of the previous two values, 
//  and prev stores the previous value of curr.

class Solution{
    public int climbStairs(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        int prev=1;
        int curr=1;

        for(int i=2;i<=n;i++){
            int temp=curr;
            curr=prev+curr;
            prev=temp; 
        }

        return curr;
        
    }
}