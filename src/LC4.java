public class LC4 {

    /**
    *只出现一次的数字
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 说明：
     *
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     *
     * 示例 1:
     *
     * 输入: [2,2,1]
     * 输出: 1
     * 示例 2:
     *
     * 输入: [4,1,2,1,2]
     * 输出: 4
    * */
    public static void main(String[] args) {
        int[] nums = new int[]{4};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {

        int num,i,j;
        for(i=0;i<nums.length;i++){
            num = nums[i];
            for(j=0;j<nums.length;j++){
                if(nums[j]==num){
                    if(i==j){
                        continue;
                    }else{
                        break;
                    }
                }
            }
            //如果当前j是最后一个数的下标，并且当前数与最后一个数不相等，说明这个数就这一个
            if(j == nums.length){
                return num;
            }
        }
        return 0;

    }
}
