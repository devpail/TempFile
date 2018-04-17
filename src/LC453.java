/**
 * 453. 最小移动次数使数组元素相等
 *
 * @author zhangzhb
 * @create 2018/4/17 13:23
 **/
public class LC453 {
    public static void main(String[] args) {
        int nums[] = new int[]{83,86,77,15,93,35,86,92,49,21};
        /**
         * 典型的思维错误，好气没想到
         * */
        /*long st = System.currentTimeMillis();

        System.out.println(minMoves(nums));
        long et = System.currentTimeMillis();

        System.out.println((et-st)/1000);*/
        /**
         * 除最大所有的+1，相当于最大的-1,相当于所有数字减小到最小值
         * */
        int count = 0;
        int min  = nums[0];
        //找到最小值
        for(int i=1;i<nums.length;i++){
            if(min>nums[i]) min = nums[i];
        }
        //累加所有数与最小值的和
        for (int i = 0; i < nums.length; i++) {
            count+=(nums[i]-min);
        }
        System.out.println(count);

    }

    public static int minMoves(int[] nums) {

        //每次除了最大的数，对其它数进行+1
        int count = 0;
        int maxIndex = 0;
        //条件 循环
        while(true){
            //判断是否全部相等，记录最大值下标
            maxIndex = getMaxIndex(nums);
            if(maxIndex == -1) break;
            count++;
            //对其他元素+1
            nums = moveNums(nums, maxIndex);
        }
        return count;
    }

    //进行一次移动
    public static int[] moveNums(int[] nums, int maxIndex){
        for(int i=0;i<nums.length;i++){
            if(i!=maxIndex){
                nums[i]++;
            }
        }
        return nums;
    }

    //判断元素是否全部相等，如果不是则获取最大值下标
    public static int getMaxIndex(int[] nums){
        int maxIndex = 0;
        int maxValue = nums[0];
        int equalCount = 0;
        for(int i=1;i<nums.length;i++){
            //如果相等，记录相等次数；如果找到更大得数则替换最大值和最大值下标
            if(maxValue < nums[i]){
                maxValue = nums[i];
                maxIndex = i;
            }else if(maxValue == nums[i]){
                equalCount++;
            }
        }

        if(equalCount == (nums.length-1)){
            return -1;
        }else{
            return maxIndex;
        }
    }

}
