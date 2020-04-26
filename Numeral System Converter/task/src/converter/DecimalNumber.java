package converter;

public class DecimalNumber {
    double number;

    public DecimalNumber(double number) {
        this.number = number;
    }

    public String toNonDecimal(int radix, int range) {
        String result = "";
        if (radix == 1) {
            result = newBaseIntPart((int) this.number / 1, radix);
        } else {
            String intPart = newBaseIntPart((int) this.number / 1, radix);
            String fractPart = newBaseFractPart(this.number % 1, radix, range);
            result =  intPart + "." + fractPart;
        }
        return result;
    }

    private String newBaseFractPart(double v, int radix, int range) {
        String fractPart = "";
        String nextSign = "";
        for (int i = 0; i < range; i++) {
            v *= radix;
            nextSign = Integer.toString((int) v / 1, radix);
            fractPart += nextSign;
            v = v % 1;
        }
        return fractPart;
    }

    private String newBaseIntPart(int v, int radix) {
        String intPart = "";
        if (radix == 1) {
            for (int i = 0; i < v; i++) {
                intPart += "1";
            }
        } else {
            intPart = Integer.toString(v, radix);
        }
        return intPart;
    }
}
