public class Node {

    Node following = null;

    int data;

    public Node(int data) {
        this.data = data;
    }

    public void appendToEnd(int data) {
        Node end = new Node(data);
        Node n = this;

        while (n.following != null) {
            n = n.following;
        }
        n.following = end;
    }

    // TODO:: Implement to return the length of the SinglyLinkedList
    // For example:: --> 5 --> 6 --> 7 --> 3 --> .
    public void printNodes() {
        if (data != 0) {
            System.out.print(data + " --> ");
        }
        if (following != null) {
            following.printNodes();
        }
    }

    // TODO:: Implement to return the length of the SinglyLinkedList
    int length(Node h) {
        int i = 1;
        if (h != null) {
            i += h.length(h.following);
        } else if (this.following != null) {
            i += this.following.length(this.following.following);
        }
        return i;
    }

    // TODO:: Implement to return the sum of the Nodes
    int sumOfNodes() {
        int i = 0;

        i += data;
        if (following != null) {
            i += following.sumOfNodes();
        }
        return i;
    }

    Node deleteNode(Node head, int data) {
        Node n = head;
        if (n.data == data) {
            return head.following;
        }
        // TODO:: Implement the proper loop in order to remove given data
        while (n.following != null) {
            if (n.following.data == data) {
                n.following = n.following.following;
                return head;
            }
            n = n.following;
        }
        //
        return head;
    }
}