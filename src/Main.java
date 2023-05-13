import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NodeItem factoryNodeItem = new NodeItem(3, 7, NodeType.FACTORY);

        List<NodeItem> nodeItems = new ArrayList<>();
        nodeItems.add(new NodeItem(1, 10, NodeType.CUSTOMER));
        nodeItems.add(new NodeItem(1, 4, NodeType.CUSTOMER));
        nodeItems.add(new NodeItem(2, 1, NodeType.CUSTOMER));
        nodeItems.add(new NodeItem(5, 3, NodeType.CUSTOMER));
        nodeItems.add(new NodeItem(6, 5, NodeType.CUSTOMER));
        nodeItems.add(new NodeItem(8, 9, NodeType.CUSTOMER));
        nodeItems.add(new NodeItem(8, 4, NodeType.CUSTOMER));
        nodeItems.add(new NodeItem(9, 2, NodeType.CUSTOMER));


        for (NodeItem item : nodeItems) {
            double distance = Math.sqrt(Math.pow(item.x - factoryNodeItem.x, 2) + Math.pow(item.y - factoryNodeItem.y, 2));
            item.distance2Factory = distance;
        }

        nodeItems.sort(Comparator.comparingDouble(o -> o.distance2Factory));

        Node node = new Node((int) nodeItems.get(0).distance2Factory);

        for (int i = 1; i < nodeItems.size(); i++) {
            node.appendToEnd((int) nodeItems.get(i).distance2Factory);
        }
        node.printNodes();
        System.out.println("\nnode length " + node.length(null));
        System.out.println("\nnode sum " + node.sumOfNodes());
        System.out.println("\nnode delete " + node.deleteNode(node, 4).data);
        node.printNodes();

        //at the end clean all nodes by implementing "deleteNode" method
        while (node != null) {
            node = node.deleteNode(node, node.data);
        }

        node.printNodes();//throws null pointer exception, at the end clean all nodes by implementing "deleteNode" method
    }

}
