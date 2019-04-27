import java.util.ArrayList;

import javax.swing.text.AsyncBoxView.ChildState;

public class Node {
    private BridgeAndTorch bt;

    private Node parentNode;
    private ArrayList<Node> childs;
    private int state[];

    private int depth;
    private int cost;

    public Node(BridgeAndTorch bt, Node parentNode, int state[], int depth, int cost) {
        this.bt = bt;

        this.parentNode = parentNode;
        this.state = state;

        this.depth = depth;
        this.cost = cost;

        createChilds();
    }

    private void createChilds() {

        // if the torch is on the left side
        if (state[state.length - 1] == 0)
            for (int i = 0; i < state.length - 1; i++)
                for (int j = i + 1; j < state.length - 1; j++)
                    if (i == 0 && j == 0) {
                        int chileState[] = this.state;
                        childState[i] = 1;
                        childState[j] = 1;
                        childState[state.length - 1] = 1; //torch goes right

                        int crossingTime = bt.calculateCrossingTime(i, j);

                        childs.add(new Node(bt, this, childState, this.depth + 1, this.cost + crossingTime));
                    }

        // if the torch is on the right side
        if (state[state.length - 1] == 1)
            for (int i = 0; i < state.length - 1; i++)
                if (i == 1) {
                    int chileState[] = this.state;
                    childState[i] = 0;
                    childState[state.length - 1] = 0; //torch goes left

                    int crossingTime = bt.getCrossingTime(i);

                    childs.add(new Node(bt, this, childState, this.depth + 1, this.cost + crossingTime));
                }
    }



}