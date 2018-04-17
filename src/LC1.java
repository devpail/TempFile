/**
 * 1. 两数之和
 *
 * @author zhangzhb
 * @create 2018/4/17 14:35
 **/
public class LC1 {
    public static void main(String[] args) {
        int [] nums = new int[]{2, 7, 11, 15};
        System.out.println(twoSum(nums,9));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int v = target - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == v && j != i){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return result;
    }


}
