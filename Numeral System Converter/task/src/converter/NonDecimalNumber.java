package converter;

public class NonDecimalNumber {
    String number;
    int radix;

    public NonDecimalNumber(String number, int radix) {
        this.number = number;
        this.radix = radix;
    }

    public double toDecimal() {
        double decimalValue = 0;
        String[] initialValue = this.number.split("\\.");
        if (initialValue.length == 2) {
            decimalValue = intPart(initialValue[0], this.radix) + fractionalPart(initialValue[1], radix);
        } else {
            decimalValue = intPart(initialValue[0], this.radix);
        }
        return decimalValue;
    }

    private int intPart(String number, int radix) {
        int integerPartDecimal;
        if (radix == 1) {
            integerPartDecimal = number.length();
        } else {
            integerPartDecimal = Integer.parseInt(number,radix);
        }
        return integerPartDecimal;
    }

    private double fractionalPart(String number, int radix) {
        double fractionalPartDecimal = 0;
        for (int i = 0; i < number.length(); i++) {
            System.out.println(number.substring(i, i + 1));
            int nextSymbol = intPart(number.substring(i, i + 1), radix);
            fractionalPartDecimal +=  nextSymbol / Math.pow(radix, i + 1);
        }
        return fractionalPartDecimal;
    }

}
