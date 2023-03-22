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
        
        // Insert K in LinkedList
        ListNode newHead = insertKLinkedList(head, 25);
        printLinkedList(newHead);
        
        // Insert K at position C in LinkedList
        ListNode newHead2 = insertKAtPositionLinkedList(head, 55 , 1);
        printLinkedList(newHead2);
        
        // Get Nth Node of LinkedList(0-based indexing)
        int N = 3;
        System.out.println(N + "th node of LinkedList: " + getNthNode(newHead2, N));
        
        // Delete Bth Node
        int M = 3;
        ListNode headNode3 = deleteBthNode(newHead2, M);
        System.out.print("After deleting " + M + "th node from LinkedList(0-based indexing): ");
        printLinkedList(headNode3);
    }
    
    public static ListNode deleteBthNode(ListNode head, int B) {
        if(B == 0){
            head = head.next;
            return head;
        }
        ListNode temp = head;

        int count = 1;
        while(count < B && temp.next != null){
            temp = temp.next;
            count++;
        }
        if(temp.next != null){
            temp.next = (temp.next.next != null) ? temp.next.next : null;
        } else {
            temp = null;
        }

        return head;
    }
    
    public static int getNthNode(ListNode head, int N){
        if(head == null) return -1;

        if(N == 0) return head.val;

        ListNode temp = head;
        int count = 0;
        while(temp.next != null && count < N){
            count++;
            temp = temp.next;
        }
        
        return temp.val;
    }
    
    public static ListNode insertKAtPositionLinkedList(ListNode head, int K, int C){
        ListNode newNode = new ListNode(K);
        if(head == null) {
            head = newNode;
            return head;
        }

        if(C == 0) {
            newNode.next = head;
            head = newNode;
            return head;
        }

        ListNode temp = head;
        int count = 1;
        while(temp.next != null && count < C){
            count++;
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }
    
    public static ListNode insertKLinkedList(ListNode head, int K){
        ListNode newNode = new ListNode(K);
        if(head == null) {
            head = newNode;
            return head;
        }

        if(K < head.val){
            newNode.next = head;
            head = newNode;
            return head;
        }

        ListNode temp = head;
        while(temp.next != null && K > temp.next.val){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
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
