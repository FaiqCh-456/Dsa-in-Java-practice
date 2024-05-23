package Lab.Trees;

import java.util.PriorityQueue;

public class KthLargest {

    public static int LargestK(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);


        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }


        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {

        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println(LargestK(nums1, k1));

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println(LargestK(nums2, k2));
    }
}
