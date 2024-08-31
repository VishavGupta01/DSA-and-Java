//Problem:
//Given an n non-negative integers representing an elevation map where the width of each bar is 1, Compute how much water it can trap after rain.

public class problemRainWaterTrapping { //Time Complexity ∝ Number of Bars given in the Problem. So, Time Complexity = O(n)
    public static void main(String[] args) {
        int bars[] = {4,2,0,6,3,2,5};
        int width = 1;
        //Auxiliary Arrays / Helping Arrays (Function Similar to Usual Arrays)
        int LMB[] = new int[7];
        int RMB[] = new int[7];

        //Calculating LMB (Left Most Boundary)
        LMB[0] = bars[0]; //Left Most will have the same boundary because it has no other value for comparison
        for(int i = 1; i < bars.length; i++) {
            LMB[i] = Math.max(LMB[i-1], bars[i]);
        }

        //Calculating RMB (Right Most Boundary)
        RMB[RMB.length-1] = bars[bars.length-1]; //Right Most will have the same boundary because it has no other value for comparison
        for(int i = RMB.length-2; i >= 0; i--) {
            RMB[i] = Math.max(RMB[i+1], bars[i]);
        }

        int trappedWater = 0;
        for(int i = 0; i < bars.length; i++) {
            //Trapped Water = Trapped Water + (Minimum of Left & Right Bound. - Height of the Bar) * Width of the Bar
            trappedWater += ((Math.min(LMB[i], RMB[i]) - bars[i]) * width);
        }
        System.out.println("Total Trapped Water: " + trappedWater);
    }
}
