public class RationalClient {
    
    public static void main(String[] args) {
        Rational r = new Rational(1, 2);
        System.out.println(r);

        // We can use dot notation to access the integer values
        // of the numerator and denominator directly
        System.out.println(r.numerator);
        System.out.println(r.denominator);

        Rational r1 = new Rational(5,2);
        System.out.println(r1.isImproper());

        Rational r2 = new Rational(6,12);
        System.out.println(r2.isSimplified()); // false

        Rational r3 = new Rational(3,4);
        System.out.println(r3.calculateDecimalValue()); // 0.75

        Rational r4 = new Rational(2,5);
        System.out.println(r4.pow(2)); // 4/25

        Rational r5 = new Rational(3,4);
        System.out.println(r5.contains(3)); // true

        Rational r6 = new Rational(3,4);
        System.out.println(r6.contains(5)); // false

        Rational r7 = new Rational(2, 4);
        r7.simplify3(); // r is now equal to 1/2
        System.out.println(r7);

        Rational r8 = new Rational(3, 5);
        r8.increment(); // r is now 8/5
        System.out.println(r8);

        Rational r9 = new Rational(6, 5);
        r9.decrement(); // r is now 1/5
        System.out.println(r9);

        Rational r10 = new Rational(3, 8);
        r10.changeToEquivalentFraction(64); // r is now 24/64 (which is equivalent to 3/8)
        System.out.println(r10);

        Rational r11 = new Rational(-3,4);
        System.out.println(r11.isNegative()); // true

        Rational r12 = new Rational(5,2);
        System.out.println(r12.reciprocal()); // 2/5

        Rational r13 = new Rational(2,5);
        Rational s = new Rational(2,4);
        System.out.println(r13.equals(s)); // false

        Rational r14 = new Rational(2,5);
        Rational s1 = new Rational(2,5);
        System.out.println(r14.equals(s1)); // true

        Rational r15 = new Rational(3, 2);
        r15.round(); // r is now 2/1
        System.out.println(r15);

        Rational r16 = new Rational(4, 2);
        r16.round(); // r is now 2/0
        System.out.println(r16);

        // Rational s = new Rational(1, 3);
        // System.out.println(s);
        // Rational t = Rational.add(r, s);
        // System.out.println(t);
    }
}
