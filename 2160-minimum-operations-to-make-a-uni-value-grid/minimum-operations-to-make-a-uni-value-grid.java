class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int mod = grid[0][0]%x;
        int sum = 0;
        int[] nums = new int[m*n];
        int k = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]%x != mod) return -1;
                nums[k++] = grid[i][j];
            }
        }
        int mp1 = -1;
        int mp2 = -1;
        Arrays.sort(nums);
        int avg = (nums.length%2==1)?nums[nums.length/2]:(nums[nums.length/2]+nums[(nums.length/2)-1])/2;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=avg){
                mp1 = (i!=0)?nums[i-1]:-1;
                mp2 = nums[i];
                break;
            }
        }
        int op1 = 0;
        int op2 = 0;
        System.out.println(avg);
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            System.out.print(num + ", ");
        }
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(mp1!=-1){
                op1 += Math.abs(num-mp1)/x;
            }
            op2 += Math.abs(num-mp2)/x;
        }
        if(mp1==-1) return op2;
        return Math.min(op1,op2);
    }
}