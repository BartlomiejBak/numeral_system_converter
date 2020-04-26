package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sourceRadix = scanner.nextInt();
        String sourceNumber = scanner.next();
        int targetRadix = scanner.nextInt();

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







        /*

        //int input = scanner.nextInt();
        //int system = scanner.nextInt();

        String symbol = "";
        String value = "";


        switch (system) {
            case 2:
                symbol = "0b";
                value = Integer.toBinaryString(input);
                break;
            case 8:
                symbol = "0";
                value = Integer.toOctalString(input);
                break;
            case 16:
                symbol = "0x";
                value = Integer.toHexString(input);
                break;
            default:
                break;
        }
        System.out.println(symbol + value);
         */

    }
}
