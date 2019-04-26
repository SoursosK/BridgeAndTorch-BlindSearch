import java.util.Scanner;
//bfs dfs ucs ids
public class BridgeAndTorch {

    private int state[];
    private int costs[];


    public BridgeAndTorch(int state[], int costs[]){
        this.state = state;
        this.costs = costs;

    }

    public static void main(String[] args) {
        int state[];
        int costs[];

        Scanner sc = new Scanner(System.in);
        System.out.println("Please insert the number of people waiting to cross the bridge:");
    
        int numberOfPeople = sc.nextInt();
        state = new int[numberOfPeople+1];
        costs = new int[numberOfPeople];

        for(int i=0; i<costs.length; i++){
            System.out.println("Please insert the crossing time of Person " + Integer.sum(i, 1) + ":");
            costs[i] = sc.nextInt();
        }

        sc.close();
        BridgeAndTorch bridgeAndTorch = new BridgeAndTorch(state, costs);

        // System.out.println("The costs are:");
        // for(int i=0; i<cost.length; i++){
        //     System.out.println(cost[i]);
        // }

    }


}