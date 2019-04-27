
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;

//javac BridgeAndTorch.java && java BridgeAndTorch

public class BridgeAndTorch {

    private int finiteState[] = { 1, 1, 1, 1, 1 };
    private int state[] = { 0, 0, 0, 0, 0 };
    private int costs[] = { 1, 2, 5, 10 };

    public BridgeAndTorch(int state[], int costs[]) {

        // this.finiteState = state;
        // Arrays.fill(this.finiteState, 1);
        // this.state = state;
        // this.costs = costs;

        // System.out.println("The finiteState are:");
        // for (int i = 0; i < finiteState.length; i++) {
        // System.out.println(finiteState[i]);
        // }
        
        BFS();
    }

    private void BFS() {

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(this, null, this.state, 0, 0));


    }


    

    public int getCrossingTime(int i){
        return this.costs[i];
    }

    public int calculateCrossingTime(int i, int j) {
        if(this.costs[i] > this.costs[j])
            return this.costs[i];
        else    
            return this.costs[j];
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
