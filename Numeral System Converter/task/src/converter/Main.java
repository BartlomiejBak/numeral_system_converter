package converter;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inpData = new ArrayList<>();

        while(scanner.hasNext()) {
            inpData.add(scanner.nextLine());
        }
        if (inpData.size() == 3) {

            String firstLine = inpData.get(0);
            String secondLine = inpData.get(1);
            String thirdLine = inpData.get(2);

            boolean correctInts = correctInt(firstLine) && correctInt(thirdLine);

            if (correctInts) {
                int sourceRadix = Integer.parseInt(firstLine);
                int targetRadix = Integer.parseInt(thirdLine);

                if (targetRadix > 0 && targetRadix < 37) {
                    convert(sourceRadix, secondLine, targetRadix);
                } else {
                    System.out.println("Error");
                }
            } else {
                System.out.println("Error");
            }
        } else {
            System.out.println("Error");
        }
    }

    public static void convert (int sourceRadix, String sourceNumber, int targetRadix) {
        double decimalValue;

        if (sourceRadix != 10) {
            NonDecimalNumber number = new NonDecimalNumber(sourceNumber, sourceRadix);
            decimalValue = number.toDecimal();
        } else {
            decimalValue = Double.parseDouble(sourceNumber);
        }

        if (targetRadix == 10) {
            System.out.println(decimalValue);
        } else {
            DecimalNumber numberDec = new DecimalNumber(decimalValue);
            System.out.println(numberDec.toNonDecimal(targetRadix,5));
        }
    }

    public static boolean correctInt(String line) {
        char[] arr = line.toCharArray();
        boolean correct = true;
        for (char c : arr) {
            if (c < '0' || c > '9') {
                correct = false;
                break;
            }
        }
        return correct;
    }


}
