package leetcode401_500;

/**
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 * <p>
 * 解题思路：遍历整个数组，中间初始化一个临时变量去保存连续1的个数，遇到1累加，遇到0比较临时变量和最大连续1个数变量的值，然后在讲临时变量的值置为0，
 *  直到循环结束，然后再比较一下，得到的就是最大连续1的个数。
 */
public class _485 {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0, count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        return Math.max(maxCount, count);
    }

    private static int findMaxConsecutiveOnes2(int[] nums) {
        int maxCnt = 0, cnt = 0;
        for(int num : nums) {
            cnt = ++cnt * num;
            if (cnt > maxCnt) maxCnt = cnt;
        }
        return maxCnt;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 1, 1, 1, 0, 1, 1};
        System.out.println(findMaxConsecutiveOnes2(nums));
    }
}
