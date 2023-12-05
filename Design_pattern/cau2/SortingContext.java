package Design_pattern.cau2;

public class SortingContext {
    private SortingStrategy strategy;

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void sortArray(int[] arr) {
        strategy.sort(arr);
    }
}