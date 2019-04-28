
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;

//javac BridgeAndTorch.java && java BridgeAndTorch

public class BridgeAndTorch {

    private LinkedList<Node> dataStructure;

    private int finiteState[] = { 1, 1, 1, 1, 1 };
    private int state[] = { 0, 0, 0, 0, 0 };
    private int costs[] = { 1, 2, 5, 10 };

    private int createdNodesCounter;
    private int visitedNodesCounter;

    // private int finiteState[] = { 1, 1, 1, 1 };
    // private int state[] = { 0, 0, 0, 0 };
    // private int costs[] = { 1, 2, 5 };

    public BridgeAndTorch(int state[], int costs[]) {

        dataStructure = new LinkedList<>();
        this.createdNodesCounter = 0;
        this.visitedNodesCounter = 0;

        // this.finiteState = state;
        // Arrays.fill(this.finiteState, 1);
        // this.state = state;
        // this.costs = costs;

        // System.out.println("The finiteState are:");
        // for (int i = 0; i < finiteState.length; i++) {
        // System.out.println(finiteState[i]);
        // }

        //BFS();
        DFS();
    }

    private void BFS() {
        dataStructure.add(new Node("startingNode", this, null, this.state, 0, 0));

        while (!dataStructure.isEmpty()) {
            this.visitedNodesCounter++;
            System.out.println("\n" + this.visitedNodesCounter);

            Node node = dataStructure.getFirst();

            System.out.println("node " + node.getName() + " depth: " + node.getDepth());
            dataStructure.removeFirst();

            if (!node.checkFiniteState()) {
                node.createChildren();

                for (Node childNode : node.getChildren()) 
                    this.dataStructure.addLast(childNode);
            } else {
                printOutput(node, "BFS");
                break;
            }

            //testing purposes
            // try {
            // Thread.sleep(1300);
            // } catch (Exception e) {
            // System.out.println("exception caught");
            // }
        }
    }

    private void DFS() {  // repeated state avoidance has to be added
        dataStructure.add(new Node("startingNode", this, null, this.state, 0, 0));

        while (!dataStructure.isEmpty()) {
            this.visitedNodesCounter++;
            System.out.println("\n" + this.visitedNodesCounter);

            Node node = dataStructure.getFirst();

            System.out.println("node " + node.getName() + " depth: " + node.getDepth());
            dataStructure.removeFirst();

            if (!node.checkFiniteState()) {
                node.createChildren();

                for(int i=node.getChildren().size()-1; i>=0; i--){
                    Node childNode = node.getChildren().get(i);
                    this.dataStructure.addFirst(childNode);
                }

            } else {
                printOutput(node, "DFS");
                break;
            }

        }


    }

    private void UCS(){
    }

    private void IDS(){
    }

    private void printOutput(Node node, String algorithName){
        System.out.println("\n" + algorithName + " found a solution to the problem!");
        System.out.println("The final cost is " + node.getCost() + " minutes.");
        System.out.println("The nodes created were " + this.createdNodesCounter + ", with " + this.visitedNodesCounter
                + " of them being visited.\n");

        ArrayList<String> output = new ArrayList<>();

        while (node.getDepth() != 0) {
            if (node.getName().length() > 1) {
                String s = "A" + node.getName().charAt(0) + " and A" + node.getName().charAt(1)
                        + " crossed the bridge in " + (node.getCost() - node.getParentNode().getCost()) + " minute(s)";
                
                output.add(s);
            } else {
                String s = "A" + node.getName() + " returns back in "
                        + (node.getCost() - node.getParentNode().getCost()) + " minute(s)";
                
                output.add(s);
            }
            node = node.getParentNode();
        }

        for (int i = output.size() - 1; i >= 0; i--)
            System.out.println(output.get(i));
    }

    // public void insertNode(Node node) {  
    //     this.dataStructure.add(node);
    // }

    public int getCrossingTime(int i) {
        return this.costs[i];
    }

    public int calculateCrossingTime(int i, int j) {
        if (this.costs[i] > this.costs[j])
            return this.costs[i];
        else
            return this.costs[j];
    }

    public int[] getFiniteState() {
        return this.finiteState;
    }

    public void incrementCreatedNodesCounter() {
        this.createdNodesCounter++;
    }

    public static void main(String[] args) {
        // int state[];
        // int costs[];

        // Scanner sc = new Scanner(System.in);
        // System.out.println("Please insert the number of people waiting to cross the
        // bridge:");

        // int numberOfPeople = sc.nextInt();
        // state = new int[numberOfPeople + 1];
        // costs = new int[numberOfPeople];

        // for (int i = 0; i < costs.length; i++) {
        // System.out.println("Please insert the crossing time of Person " +
        // Integer.sum(i, 1) + ":");
        // costs[i] = sc.nextInt();
        // }

        // sc.close();
        // BridgeAndTorch bridgeAndTorch = new BridgeAndTorch(state, costs);

        BridgeAndTorch bridgeAndTorch = new BridgeAndTorch(null, null);
    }

}
