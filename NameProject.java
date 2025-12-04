import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class NameProject {

    public static void main(String[] args) throws FileNotFoundException{

        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> firstOfEachLetter = new ArrayList<>();
        File inputFile = new File("names.txt");
        Scanner input = new Scanner(inputFile);

        while (input.hasNextLine()) {
            String name = input.nextLine();
            names.add(name);
        }
        Collections.sort(names);
        for (int i = 0; i < names.size(); i++) {
            String currentName = names.get(i);

            if (i == 0) {
                firstOfEachLetter.add(currentName);
            } else {
                String previousName = names.get(i - 1);

                if (currentName.charAt(0) != previousName.charAt(0)) {
                    firstOfEachLetter.add(currentName);
                }
            }
        }
        Collections.sort(firstOfEachLetter);
        Collections.reverse(firstOfEachLetter);
        PrintWriter output = new PrintWriter("sortednames.txt");

        for (String n : firstOfEachLetter) {
            output.println(n);
        }

        output.close();

        System.out.println("First (should start with Z): " + firstOfEachLetter.getFirst());
        System.out.println("Last (should start with A): " + firstOfEachLetter.getLast());

        input.close();
        System.out.println("Number of names read: " + names.size());
    }

}
