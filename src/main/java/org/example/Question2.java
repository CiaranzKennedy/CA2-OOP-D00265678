package org.example;
import java.util.Scanner;

/**
 *  Your Name: Ciaran Kennedy
 *  Class Group: GD2
 */
public class Question2  // Car Parking - Stack
{
    // DriveWay class to simulate parking and removing cars
    public static class DriveWay {
        private int maxSize;
        private int top;
        private int[] stack;

        // Constructor
        public DriveWay() {
            maxSize = 4;
            stack = new int[maxSize];
            top = -1;
        }
        public void park(int value) {
            if (top < maxSize - 1) {
                stack[++top] = value;
                System.out.println("Parked car " + value);
            } else {
                System.out.println("Stack Overflow! Unable to park car " + value);
            }
        }
        public void leave(int carNumber) {
            boolean foundCar = false;
            if (top >= 0) {
                for (int i = 0; i <= top; i++) {
                    if (stack[i] == carNumber) {
                        foundCar = true;
                        for (int j = i; j < top; j++) {
                            stack[j] = stack[j + 1];
                        }
                        top--;
                        System.out.println("Car " + carNumber + " left the driveway.");
                        break;
                    }
                }
            }
            if (!foundCar) {
                System.out.println("Car " + carNumber + " not found in the driveway.");
            }
        }

        // Print all cars in the stack (driveway)
        public void printStack() {
            if (top == -1) {
                System.out.println("Driveway is empty.");
            } else {
                System.out.print("Cars in driveway: ");
                for (int i = top; i >= 0; i--) {
                    System.out.print(stack[i] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void runSimulation() {
        Scanner s = new Scanner(System.in);
        DriveWay driveway = new DriveWay();
        int input = -1;

        while (input != 0) {
            System.out.println("What car would you like to park/remove? (Enter car number to park, '-carNumber' to remove that car, '0' to stop)");
            input = s.nextInt();

            if (input > 0) {
                driveway.park(input);
            } else if (input < 0) {
                driveway.leave(-input);
            } else if (input == 0) {
                System.out.println("Ending simulation.");
                driveway.printStack();
            }
        }
    }

    public static void main(String[] args) {
        runSimulation();  // Run the simulation
    }
}

