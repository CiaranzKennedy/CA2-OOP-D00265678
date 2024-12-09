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
public class Question1 {    // Interfaces
    public static void main(String[] args) {
        System.out.println("Question 1");
        // create container here...
        ContainerManager manager = new ContainerManager();
        Box box = new Box(2.0, 3.0, 1.0,1.0);
        Cylinder cylinder = new Cylinder(4.0, 1.0, 1.0);
        Pyramid pyramid = new Pyramid(4.0, 3.0);

        manager.add(box);
        manager.add(cylinder);
        manager.add(pyramid);

        System.out.println("Total weight: " + manager.totalWeight());
        System.out.println("Total rectangular volume: " + manager.totalRectangularVolume());

        List<IMeasurableContainer> allContainers = manager.getAllContainers();
        for (IMeasurableContainer container : allContainers) {
            if(container instanceof Box) {
                Box box1 = (Box) container;
                System.out.println("Box Length: " + box1.getLength()+", Width:"+ box1.getWidth() + ", Depth:"+ box1.getDepth() + ", Weight:"+ box1.getWeight());
            }
            if(container instanceof Cylinder) {
                Cylinder cylinder2 = (Cylinder) container;
                System.out.println("Cylinder: " + cylinder2.getHeight()+", Diameter:"+ cylinder2.getDiameter() + ", Weight:"+ cylinder2.getWeight());
            }
            if(container instanceof Pyramid) {
                Pyramid pyramid3 = (Pyramid) container;
                System.out.println("Pyramid: " + pyramid3.getSideLength() + ", Weight:"+ pyramid3.getWeight());
            }
        }
    }
}


