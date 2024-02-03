package solutions;
import helper.ListNode;

//Problem 1 : 21. Merge Two Sorted Lists (Easy)

//        You are given the heads of two sorted linked lists list1 and list2.
//        Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
//        Return the head of the merged linked list.
//    Reference :https://leetcode.com/problems/merge-two-sorted-lists/description/

//Problem 2 : 26. Remove Duplicates from Sorted Array(Easy)

//        Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
//        Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
//        Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
//        Return k.
//    Reference : https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

//Problem 3 : 83. Remove Duplicates from Sorted List

//        Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
//    Reference : https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/

public class EC1 {

//    Problem 1 Solution
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        if(list1.val<list2.val){
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }
    }

//    Problem 2 Solution :

    public static  int removeDuplicates(int[] nums) {
        if(nums.length==0)
            return 0;
        int indexOfSearch = 1;
        int indexOfInsertion = 0;

        while(indexOfSearch<=nums.length-1){
            if(nums[indexOfSearch]==nums[indexOfInsertion]){
                indexOfSearch++;
            }else {
                indexOfInsertion++;
                nums[indexOfInsertion]=nums[indexOfSearch];
            }
        }
        return indexOfInsertion+1;
    }

//    Problem 3 Solution :
    private static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current!=null && current.next!=null){
            if(current.val==current.next.val){
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {

//        Solution 1 Test
        ListNode listNode1 = new ListNode(1,new ListNode(3,new ListNode(5)));
        ListNode listNode2 = new ListNode(2,new ListNode(4,new ListNode(6)));
        ListNode.printList(mergeTwoLists(listNode1,listNode2));

//        Solution 2 Test
        int[] input =  {0,0,1,1,1,2,2,3,3,4};
        System.out.println(" P2 : " + removeDuplicates(input));

//        Solution 3 Test
        ListNode head = new ListNode(1,new ListNode(1,new ListNode(3)));
        ListNode.printList(deleteDuplicates(head));
    }


}