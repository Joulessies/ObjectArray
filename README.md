# ObjectArray Java Program

## Overview

The `ObjectArray` Java program is designed to:
1. Populate an array with user input, allowing both numeric and string elements.
2. Display the elements of the array in reverse order.
3. Filter numeric elements, sort them in ascending order, and display them.

## Features

- **Dynamic Array Handling**: Resizes automatically as elements are added.
- **Reverse Display**: Outputs array elements in reverse order of input.
- **Ascending Sort**: Sorts and displays numeric elements in ascending order.

## Code

```java
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ObjectArray {

    // Code Fields
    private Object[] array;
    private int size;

    // Constructor
    public ObjectArray(int initialSize) {
        array = new Object[initialSize];
        size = 0;
    }

    // Resizing the array
    private void resize() {
        int newArraySize = array.length * 2; // Increase size
        Object[] newArray = new Object[newArraySize];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    // Setting the element in the array
    public void setElement(int index, Object element) {
        if (index >= array.length) {
            resize();
        }
        array[index] = element;
        size = Math.max(size, index + 1);
    }

    // Populating the array with user input
    public void populateArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input elements for the array (type 'exit' to quit):");

        int index = 0; // To keep track of the index for setElement
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.isEmpty()) {
                System.out.println("Empty input is not allowed. Please enter a valid element.");
            } else {
                try {
                    // Attempt to parse the input as an integer
                    int num = Integer.parseInt(input);
                    setElement(index++, num);
                } catch (NumberFormatException e) {
                    // If parsing fails, treat the input as a string
                    setElement(index++, input);
                }
            }
        }
        scanner.close();
    }

    // Display elements in reverse order
    public void displayReverseOrder() {
        System.out.println("Elements in reverse order:");
        for (int i = size - 1; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }

    // Display numeric elements in ascending order
    public void displayAscendingOrder() {
        List<Integer> numericElements = new ArrayList<>();

        // Filter numeric elements and add them to a list
        for (int i = 0; i < size; i++) {
            if (array[i] instanceof Integer) {
                numericElements.add((Integer) array[i]);
            }
        }

        // Sort the numeric elements
        Collections.sort(numericElements);

        System.out.println("Numeric elements in ascending order:");
        for (int num : numericElements) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        ObjectArray objArray = new ObjectArray(10); // Initialize with an initial size
        objArray.populateArray();       // Populate the array with user input
        objArray.displayReverseOrder(); // Display the array in reverse order
        objArray.displayAscendingOrder(); // Display numeric elements in ascending order
    }
}

