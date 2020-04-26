package converter;

public class DecimalNumber {
    double number;

    public DecimalNumber(double number) {
        this.number = number;
    }

    public String toNonDecimal(int radix, int range) {
        String result;
        if (radix == 1) {
            result = newBaseIntPart((int) this.number, radix);
        } else if (this.number % 1 == 0) {
            result = newBaseIntPart((int) this.number, radix);
        } else {
            String intPart = newBaseIntPart((int) this.number, radix);
            String fractPart = newBaseFractPart(this.number % 1, radix, range);
            result =  intPart + "." + fractPart;
        }
        return result;
    }

    private String newBaseFractPart(double v, int radix, int range) {
        StringBuilder fractPart = new StringBuilder();
        String nextSign;
        for (int i = 0; i < range; i++) {
            v *= radix;
            nextSign = Integer.toString((int) v, radix);
            fractPart.append(nextSign);
            v = v % 1;
        }
        return fractPart.toString();
    }

    private String newBaseIntPart(int v, int radix) {
        StringBuilder intPart = new StringBuilder();
        if (radix == 1) {
            intPart.append("1".repeat(Math.max(0, v)));
        } else {
            intPart = new StringBuilder(Integer.toString(v, radix));
        }
        return intPart.toString();
    }
}
