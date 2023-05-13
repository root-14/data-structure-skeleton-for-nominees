/**
 * Created by ilkay on 13,May, 2023
 */
public class NodeItem {
    NodeType nodeType;
    double distance2Factory;

    int x, y;

    public NodeItem(int x, int y, NodeType nodeType) {
        this.nodeType = nodeType;
        this.x = x;
        this.y = y;
    }
}
