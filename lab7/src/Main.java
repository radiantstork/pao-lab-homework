import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // EX 1
        MyCalculator calc = new MyCalculator();
        testExceptions(calc);

        try {
            Double[] numArray = readFromFile("input.txt");
            System.out.println("Average: " + calc.average(numArray));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        // EX 2
        List<String> t = readFileToList("words.txt");
        for (String line : t) {
            System.out.println(line);
        }
        System.out.println();
        
        System.out.println(longestWord("words.txt"));
    }

    public static void testExceptions(MyCalculator calc) {
        // case 1.1: null parameter add()
        try {
            calc.add(10.0, null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // case 1.2: sum overflow add()
        try {
            calc.add(Double.POSITIVE_INFINITY, 5.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // case 1.3: sum underflow add()
        try {
            calc.add(Double.NEGATIVE_INFINITY, 5.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        // case 2.1: null parameter divide()
        try {
            calc.divide(null, 0.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // case 2.2: division by zero divide()
        try {
            calc.divide(1.0, 0.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        // case 3.1: null parameter average()
        try {
            calc.average(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // case 3.2: sum overflow average()
        try {
            calc.average(new Double[]{Double.POSITIVE_INFINITY});
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // case 3.3: sum underflow average()
        try {
            calc.average(new Double[]{Double.NEGATIVE_INFINITY});
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // catch 3.4: division by zero average()
        try {
            calc.average(new Double[]{});
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }

    public static Double[] readFromFile(String filePath) throws FileProcessingException {
        List<Double> numList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNext()) {
                String aux = scanner.next();
                try {
                    numList.add(Double.parseDouble(aux));
                } catch (NumberFormatException e) {
                    throw new FileProcessingException("Invalid value: " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileProcessingException("File not found: " + e.getMessage());
        }

        return numList.toArray(new Double[0]);
    }

    // -----

    public static String longestWord(String filePath) {
        String longest = "";
        try (Scanner scanner = new Scanner(new File(filePath))) {
            String line;
            while (scanner.hasNext()) {
                line = scanner.next();
                for (String word : line.split(" ")) {
                    if (word.length() > longest.length()) {
                        longest = word;
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        appendClassToFile(filePath);
        return longest;
    }

    public static void appendClassToFile(String filePath) {
        String className = "src/" + Main.class.getSimpleName() + ".java";
        try {
            BufferedReader fin = new BufferedReader(new FileReader(className));
            FileWriter fout = new FileWriter(filePath, true);
            String line;
            while ((line = fin.readLine()) != null) {
                fout.write(line + "\n");
            }
            fout.close();
            fin.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<String> readFileToList(String filePath) {
        List<String> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}