import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PetMain {
    public static void main(String[] args) {
        List<Pet> petList = new ArrayList<>();

        petList.add(new Pet("Cat", "Barsik", 2.7));
        petList.add(new Pet("Dog", "Bobik", 5.8));
        petList.add(new Pet("Parrot", "Kesha", 0.5));
        petList.add(new Pet("Dog", "Bob", 2.2));
        petList.add(new Pet("Pig", "Hrew", 9.4));
        petList.add(new Pet("Spider", "William", 0.06));
        petList.add(new Pet("Mouse", "Lu", 0.1));

        System.out.println("Исходный список:");
        System.out.println(petList);

        System.out.println("\nСортировка по длине клички:");
        Collections.sort(petList, new ComparatorNameLength());
        System.out.println(petList);

        System.out.println("\nСортировка по весу (TreeSet):");
        Set<Pet> petSet = new TreeSet<>(petList);
        System.out.println(petSet);
    }
}
