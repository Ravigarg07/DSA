import java.util.Hashtable;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Hashtable<Integer,Integer> ht = new Hashtable<>();
        for(int i=0;i<nums.length;i++){
            ht.put(nums[i],i);
        }
        int ans[] = new int[2];
        for(int i=0;i<nums.length;i++){
            int num = target-nums[i];
            if(ht.containsKey(num) && i!=ht.get(num)){
                ans[0] = i;
                ans[1] = ht.get(num);
                return ans;
            }
        }
        return ans;
    }
}