public class CommonElements {

    private int comparisons = 0;
    int counter=0;

    public Comparable[] findCommonElements(Comparable[][] collections) {
      // create commonElements and shortest array
        Comparable[] commonElements = new Comparable[10];
        Comparable[] shortestArray = null;

        for (Comparable[] array : collections) {
            if ( shortestArray == null ||array.length < shortestArray.length) {
                shortestArray = array;

            }
        }
        if (shortestArray == null) {
           return null;
       }
        for (Comparable item : shortestArray) {
            boolean common = false;
            boolean found = false;
            for (Comparable[] array : collections) {
                // we don't need to compare the array  on itself
                if (array == shortestArray) continue;
                for (int j = 0; j < array.length; ++j) {
                    Comparable compareElement = array[j];
                    if (compareElement != null) {
                        comparisons++;
                        if (compareElement.equals(item)) {
                            array[j] = null;
                            found = true;
                            break;
                        }
                    }
                }
                common = found;
                // if not found for this this array, we won't  need to check remaining ones
                if (!found) break;
            }

            if (common) {

                commonElements[counter]=item;
                counter++;

        }}
        return commonElements;
    }

    public int getComparisons() {
        return comparisons;
    }

    public void setComparisons(int comparisons) {
        this.comparisons = comparisons;
    }
// test set1 and result
    public void test1() {
        Comparable[] col1 = {'A', 'B', 'C', 'G', 'E', 'F', 'G'};
        Comparable[] col2 = {'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        Comparable[] col3 = {'A', 'C', 'E', 'G', 'I', 'K', 'O'};
        Comparable[][] collection = {col1, col2, col3};
        Comparable [] result = findCommonElements(collection);
        System.out.println("test-1");
        System.out.println(getComparisons());

           for (Comparable e: result){
               if (e!=null)
               System.out.println(e);
           }
    }
// test set 2 and result
    public void test2()
    {
        Comparable[] col1 = {'A', 'B', 'C', 'D', 'E', 'F', 'M', 'J'};
        Comparable[] col2 = {'C', 'E', 'F', 'G', 'H', 'M'};
        Comparable[] col3 = {'A', 'C', 'D', 'F', 'M'};
        Comparable[][] collection = {col1, col2, col3};
        Comparable [] result = findCommonElements(collection);
        System.out.println("test-2");
        System.out.println(getComparisons());
        for (Comparable e: result){
            if (e!=null)
            System.out.println(e);
        }
    }
// test set 3 and result
    public void test3()
    {
        Comparable[] col1 = {'A', 'B', 'C', 'D'};
        Comparable[] col2 = {'D', 'E', 'F', 'G', 'H'};
        Comparable[] col3 = {'A', 'C', 'E', 'G', 'I', 'K'};
        Comparable[][] collection = {col1, col2, col3};
        Comparable [] result = findCommonElements(collection);
        System.out.println("test-3");
        System.out.println(getComparisons());
        for (Comparable e: result){
            if (e!=null)
                System.out.println(e);
        }
    }
// test set 4 and result

    public void test4()
    {
        Comparable[] col1 = {};
        Comparable[] col2 = {'D', 'E', 'F', 'G', 'H'};
        Comparable[] col3 = {'A', 'C', 'E', 'G', 'I', 'K'};
        Comparable[][] collection = {col1, col2, col3};
        Comparable [] result = findCommonElements(collection);
        System.out.println("test-4");
        System.out.println(getComparisons());
        for (Comparable e: result){
            if (e!=null)
                System.out.println(e);
        }
    }

    public static void main(String[] args)
    {
        new CommonElements().test1();
        new CommonElements().test2();
        new CommonElements().test3();
        new CommonElements().test4();
    }
}