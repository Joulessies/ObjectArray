import java.util.Scanner;

public class ObjectArray() {

    private Object[] array;
    private int size;

    public void ArrayConstructor(int initialSize) {
        array = new Object[initialSize];
        size = 0;
    }

    public void setElement(int index, Object element) {
        if (index >= array.length) {
            resize();
        }

        array[index] = element;
        size = Math.max(size, index + 1);
    }

    public void populateArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter elements for the array: ");
        System.out.print("(Type 'exit' to quit)");
    }

}