package proxy;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

@Logged

public class MathBox implements ObjectBox {
    private Set<Integer> sortedSet = new TreeSet();

    public MathBox(Integer[] mas) {
        for (int i = 0; i < mas.length; i++) {
            sortedSet.add(mas[i]);
        }
    }

    @Override
    @ClearData
    public Double summator() {
        Double sum = 0.0;
        for (Integer temp : sortedSet) {
            sum += temp;
        }

        return sum;
    }

    public TreeSet splitter(Integer divider) {
        TreeSet set = new TreeSet();
        try {
            if (divider == 0) throw new ArithmeticException();
            for (Integer temp : sortedSet) {

                if (divider == 0) throw new ArithmeticException();
                set.add((double) temp / divider);
            }
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль!");
        }

        return set;
    }

    public void printSet() {
        for (Integer temp : sortedSet) {
            System.out.println(temp);
        }
    }

    public void delete(Integer element) {
        if (sortedSet.contains(element)) sortedSet.remove(element);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return Objects.equals(sortedSet, mathBox.sortedSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sortedSet);
    }
}
