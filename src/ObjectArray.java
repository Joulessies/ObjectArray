import java.util.Scanner;

public class ObjectArray {

    // Code Fields.
    private Object[] array;
    private int size;

    // Adding the constructor method to the elements.
    public void ArrayConstructor(int initialSize) {
        array = new Object[initialSize];
        size = 0;
    }

    //Setting the size of the resize
    private void resize() {
        int newArraySize = array.length;
        Object[] newArray = new Object[newArraySize];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    // Setting the size of the elements on the array.
    public void setElement(int index, Object element) {
        if (index >= array.length) {
            resize();
        }

        array[index] = element;
        size = Math.max(size, index + 1);
    }


    // Populating the array.
    public void populateArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter elements for the array: ");
        System.out.print("(Type 'exit' to quit)");

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            } else if (input.equals("")) {

        }
    }
}