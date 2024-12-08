package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 *  Your Name: Ciaran Kennedy
 *  Class Group: GD2
 */
// Define the interface IMeasurableContainer
interface IMeasurableContainer {
    double weight();
    double rectangularVolume();
}

// Define the Box class implementing IMeasurableContainer
class Box implements IMeasurableContainer {
    private double length, width, depth, weight;

    public Box(double length, double width, double depth, double weight) {
        this.length = length;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public double rectangularVolume() {
        return length * width * depth;
    }

    // Getter methods
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getDepth() {
        return depth;
    }

    public double getWeight() {
        return weight;
    }
}

// Define the Cylinder class implementing IMeasurableContainer
class Cylinder implements IMeasurableContainer {
    private double height, diameter, weight;

    public Cylinder(double height, double diameter, double weight) {
        this.height = height;
        this.diameter = diameter;
        this.weight = weight;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public double rectangularVolume() {
        double radius = diameter / 2;
        return height * diameter * diameter; // Rectangular volume is height × diameter × diameter
    }

    // Getter methods
    public double getHeight() {
        return height;
    }

    public double getDiameter() {
        return diameter;
    }

    public double getWeight() {
        return weight;
    }
}

// Define the Pyramid class implementing IMeasurableContainer
class Pyramid implements IMeasurableContainer {
    private double sideLength, weight;

    public Pyramid(double sideLength, double weight) {
        this.sideLength = sideLength;
        this.weight = weight;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public double rectangularVolume() {
        return sideLength * sideLength * sideLength; // Assuming Toblerone fits in a cube
    }

    // Getter methods
    public double getSideLength() {
        return sideLength;
    }

    public double getWeight() {
        return weight;
    }
}

// Define the ContainerManager class


class ContainerManager {
    private List<IMeasurableContainer> containers;

    public ContainerManager() {
        containers = new ArrayList<>();
    }

    public void add(IMeasurableContainer container) {
        containers.add(container);
    }

    public double totalWeight() {
        double totalWeight = 0;
        for (IMeasurableContainer container : containers) {
            totalWeight += container.weight();
        }
        return totalWeight;
    }

    public double totalRectangularVolume() {
        double totalVolume = 0;
        for (IMeasurableContainer container : containers) {
            totalVolume += container.rectangularVolume();
        }
        return totalVolume;
    }

    public void clearAll() {
        containers.clear();
    }

    public List<IMeasurableContainer> getAllContainers() {
        return new ArrayList<>(containers);
    }
}
class JerrysBox implements IMeasurableContainer {
    private double length, width, depth, weight;

    public JerrysBox(double length, double width, double depth, double weight) {
        this.length = length;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public double rectangularVolume() {
        return length * width * depth;
    }

    // Getter methods
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getDepth() {
        return depth;
    }

    public double getWeight() {
        return weight;
    }
}
public class Question1 {    // Interfaces
    public static void main(String[] args) {
        System.out.println("Question 1");
        // create container here...
        ContainerManager manager = new ContainerManager();
    }
}


