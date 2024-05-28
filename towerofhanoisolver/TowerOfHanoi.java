package towerofhanoisolver;

public class TowerOfHanoi {

    // Recursive function to solve the Tower of Hanoi puzzle
    public static void solveHanoi(int n, char source, char auxiliary, char destination) {
        // Base case: only one disk to move
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        // Recursive case: move n-1 disks from source to auxiliary, using destination as a temporary peg
        solveHanoi(n - 1, source, destination, auxiliary);
        
        // Move the nth disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        
        // Move the n-1 disks from auxiliary to destination, using source as a temporary peg
        solveHanoi(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        int n = 3; // Number of disks
        
        // Solve the Tower of Hanoi puzzle
        solveHanoi(n, 'A', 'B', 'C');
    }
}
