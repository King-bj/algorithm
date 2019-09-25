package coding;

/**
 * 1.判断链表是否有环
 * 思路：速度追击， 同时从起点出发，一个每次走1步，一个每次走两步，如果两人能相遇就有环
 * 2.如何获取环的长度，入环点
 * 因为两个指针步速相差1，那么当第一次指针相遇后，让两个指针再次顺着环走，直到第二次相遇，那么走的次数就是环长
 * 设入环点到起点长度为x，入环点到相遇点为s1,相遇点到入环点为s2
 * 首次相遇  第一个指针走的距离 D = X+S1  第二个指针走的距离 D = X+S1+n(S1+S1)  （n是绕环圈数）
 * 两个指针的速度是2:1所以   距离也就是2:1   那么  2(X+S1) = X+S1+n(S1+S1)   X = (n-1)(S1+S2)+S2
 * 结论：链表头结点到入环点的距离，等于从首次相遇点绕环n-1圈再回到入环点的距离
 * 首次相遇后，只要把其中一个指针放回到头节点位置，另一个指针保持在首次相遇点，两个指针都是每次向前走1步。那么，它们最终相遇的节点，就是入环节点
 */
public class CircumLincked {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    /**
     * 是否有环
     * @param head
     * @return
     */
    public static boolean isCycle(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    /**
     * 环长
     * 因为两个指针步速相差1，那么当第一次指针相遇后，让两个指针再次顺着环走，直到第二次相遇，那么走的次数就是环长
     * @param head
     * @return
     */
    public static int circumLength(Node head) {
        Node p1 = head;
        Node p2 = head;
        if(!isCycle(head)){
            return 0;
        }
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                int i = 0;
                while (p2 != null && p2.next != null){
                    p1 = p1.next;
                    p2 = p2.next.next;
                    i++;
                    if(p1 == p2){
                       return i;
                    }
                }
            }
        }
        return 0;
    }

    /**
     * 入环点
     * 首次相遇后，只要把其中一个指针放回到头节点位置，另一个指针保持在首次相遇点，两个指针都是每次向前走1步。
     * 那么，它们最终相遇的节点，就是入环节点
     * @param head
     * @return
     */
    public static int circumPoint(Node head) {
        Node p1 = head;
        Node p2 = head;
        if(!isCycle(head)){
            return 0;
        }
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                int i = 0;
                p1 = head;
                while (p2 != null && p2.next != null){
                    p1 = p1.next;
                    p2 = p2.next;
                    i++;
                    if(p1 == p2){
                        return i;
                    }
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) throws Exception {
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(2);
        Node node5 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;
        System.out.println(circumPoint(node1));
        System.out.println(circumLength(node1));
        System.out.println(isCycle(node1));
    }

}
