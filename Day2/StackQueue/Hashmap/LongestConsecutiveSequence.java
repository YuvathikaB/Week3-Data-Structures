package HashMap;
import java.util.HashSet;
import java.util.Scanner;
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestStreak = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the elements of the array separated by spaces : ");
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        int[] nums = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            nums[i] = Integer.parseInt(inputArray[i]);
        }
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        int result = solution.longestConsecutive(nums);
        System.out.print("The length of the longest consecutive elements sequence is : " + result);
        scanner.close();
    }
}

