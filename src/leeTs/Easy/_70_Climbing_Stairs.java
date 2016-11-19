package leeTs.Easy;

public class _70_Climbing_Stairs {

	public static void main(String[] args) {
		System.out.println(String.format("The result is %d", climbStairs(4)));
	}

	public static int climbStairs(int n) {
		if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;
        
        for(int i=2; i<n; i++){ // noted that i ++ !
        	all_ways = one_step_before + two_steps_before; // all for this stair points
        	two_steps_before = one_step_before; // two step former for next points 
            one_step_before = all_ways; // one step former for next points
            /*could be simplified to
             one_step_before = one_step_before + two_step_before;
             two_step_before = one_step_before - two_step_before; 
             * */
        }
        return all_ways;
	}
}
