package Design_pattern.cau2;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 3};

        SortingContext context = new SortingContext();

        SortingStrategy bubbleSort = new BubbleSort();
        context.setStrategy(bubbleSort);
        context.sortArray(arr);

        SortingStrategy selectionSort = new SelectionSort();
        context.setStrategy(selectionSort);
        context.sortArray(arr);
    }
}
