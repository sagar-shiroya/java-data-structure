import util.ListNode;

import java.util.List;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Main {
    public static void main(String[] args) {
        // Create LinkList with below values and return head
        int[] arr = {12,23,34,56,67};
        ListNode head = createLinkedList(arr);

        // Display LinkedList Node Values
        printLinkedList(head);

        // Calculate size of LinkedList
        System.out.println("Size of LinkedList: " + calculateSizeOfLinkedList(head));

        // Find the mid of LinkedList
        System.out.println("Middle element of LinkedList: " + findMidOfLinkedList(head));
    }

    public static int findMidOfLinkedList(ListNode head){
        ListNode fastNode = head;
        ListNode slowNode = head;

        while(fastNode != null && fastNode.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next != null ? fastNode.next.next : fastNode.next;
        }

        return slowNode.val;
    }

    public static int calculateSizeOfLinkedList(ListNode head){
        int count = 0;
        ListNode temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void printLinkedList(ListNode head){
        ListNode temp = head;

        while(temp != null){
            if(temp.next == null){System.out.print(temp.val);}
            else System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode createLinkedList(int[] A){
        int i = 0;
        ListNode head = new ListNode(A[i]);
        i++;

        ListNode temp = head;
        while(i < A.length){
            ListNode newNode = new ListNode(A[i]);
            temp.next = newNode;
            temp = temp.next;
            i++;
        }
        return head;
    }
}
