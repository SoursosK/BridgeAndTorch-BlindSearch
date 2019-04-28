import java.util.ArrayList;
import java.util.Arrays;

public class Node {
    private String name;

    private BridgeAndTorch bt;

    private Node parentNode;
    private ArrayList<Node> childs;
    private int state[];

    private int depth;
    private int cost;

    public Node(String name, BridgeAndTorch bt, Node parentNode, int state[], int depth, int cost) {
        this.name = name;
        
        this.bt = bt;

        this.parentNode = parentNode;
        this.childs = null;
        this.state = state;

        this.depth = depth;
        this.cost = cost;
    }

    public boolean checkFiniteState(){
        if(Arrays.equals(this.state, this.bt.getFiniteState()))
            return true;
        else
            return false;
    }

    private void insertChildsToDataStructure() {
        for (Node childNode : childs){
            bt.incrementCreatedNodesCounter();
            this.bt.insertNode(childNode);
        }
    }

    public void createChilds() {
        this.childs = new ArrayList<>();

        // if the torch is on the left side
        if (state[state.length - 1] == 0)
            
            for (int i = 0; i < state.length - 1; i++)
                for (int j = i + 1; j < state.length - 1; j++){

                    if (this.state[i] == 0 && this.state[j] == 0) {
                        int childatate[] = this.state.clone();
                        childatate[i] = 1;
                        childatate[j] = 1;
                        childatate[childatate.length - 1] = 1; // torch goes right

                        int crossingTime = bt.calculateCrossingTime(i, j);

                        childs.add(new Node(i+""+j, bt, this, childatate, this.depth + 1, this.cost + crossingTime));
                        
                        System.out.println("child created left side");
                    }
                }

        // if the torch is on the right side
        if (state[state.length - 1] == 1)

            for (int i = 0; i < state.length - 1; i++)

                if (this.state[i] == 1) {
                    int childState[] = this.state.clone();
                    childState[i] = 0;
                    childState[state.length - 1] = 0; // torch goes left

                    int crossingTime = bt.getCrossingTime(i);

                    childs.add(new Node(i+"", bt, this, childState, this.depth + 1, this.cost + crossingTime));
                    
                    System.out.println("child created right side");
                }

        insertChildsToDataStructure();
    }

    

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public ArrayList<Node> getChilds() {
        return childs;
    }

    public void setChilds(ArrayList<Node> childs) {
        this.childs = childs;
    }

    public int[] getState() {
        return state;
    }

    public void setState(int[] state) {
        this.state = state;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }


}