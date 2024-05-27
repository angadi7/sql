package bitwisealgorithm;

public class UniqueElements {

    public static int[] findUniqueElements(int[] nums) {
        // Step 1: XOR all the elements in the array
        int xorResult = 0;
        for (int num : nums) {
            xorResult ^= num;
        }

        // Step 2: Find a set bit in the xorResult (we use the rightmost set bit)
        int setBit = xorResult & -xorResult;

        // Step 3: Divide elements into two groups and XOR elements within each group
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & setBit) == 0) {
                num1 ^= num; // Group 1
            } else {
                num2 ^= num; // Group 2
            }
        }

        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 1, 4};
        int[] uniqueElements = findUniqueElements(nums);
        System.out.println("The two unique elements are: " + uniqueElements[0] + " and " + uniqueElements[1]);
    }
}
