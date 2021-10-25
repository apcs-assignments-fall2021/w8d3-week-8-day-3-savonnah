public class Rational
{
    // instance variables: every Rational object will have its own copy
    // of these variables
    public int numerator;
    public int denominator;
    
    /**
     * Constructor: the special method that will actually create a new Rational
     * object
     * Constructors are always public
     * Constructors have the same name as the class
     * Constructors have no return type
     */
    public Rational(int a, int b) {
        numerator = a;
        denominator = b;
    }

    // *****
    // You should go ahead and copy and paste the methods
    // from last class into here:
    // *****

    public static Rational add(Rational r, Rational s) {
        int rnum = r.numerator;
        int rden = r.denominator;
        int snum = s.numerator;
        int sden = s.denominator;
        int nume1 = rnum*sden;
        int nume2 = snum*rden;
        int den = rden*sden;
        int num = nume1+nume2;
        Rational t = new Rational(num, den);
        Rational simpadd = Rational.simplify(t);

        return simpadd;
    }

    // This method takes two Rationals, subtracts thems up,
    // and returns a Rational equal to the difference
    public static Rational subtract(Rational r, Rational s) {
        int rnum = r.numerator;
        int rden = r.denominator;
        int snum = s.numerator;
        int sden = s.denominator;
        int nume1 = rnum*sden;
        int nume2 = snum*rden;
        int den = rden*sden;
        int num = nume1-nume2;
        Rational t = new Rational(num, den);
        Rational simpsub = Rational.simplify(t);

        return simpsub;
    }

    public static Rational multiply(Rational r, Rational s) {
        int rnum = r.numerator;
        int rden = r.denominator;
        int snum = s.numerator;
        int sden = s.denominator;
        int den = rden*sden;
        int num = rnum*snum;
        Rational t = new Rational(num, den);
        Rational simpmult = Rational.simplify(t);

        return simpmult;
    }

    public static Rational divide(Rational r, Rational s) {
        int rnum = r.numerator;
        int rden = r.denominator;
        int snum = s.numerator;
        int sden = s.denominator;
        int den = rden*snum;
        int num = rnum*sden;
        Rational t = new Rational(num, den);
        Rational simpdiv = Rational.simplify(t);

        return simpdiv;
    }

    // Finds the greatest common factor between a and b
    // To find the greatest common factor, find the largest number x
    // such that a and b are both multiples of x
    public static int greatestCommonFactor(int a, int b){
        int largenum = Math.max(a,b);
        int gcf = 1;
        for(int i = 1; i<=largenum; i++){
            if(a%i == 0 && b%i == 0){
                gcf = i;
            }
        }
        return gcf;
    }

    // This method is given a rational, and returns a simplified version
    // of the input rational
    // Use the greatestCommonFactor method here
    // e.g. simplify(2/4) => 1/2
    //      simplify(1/2) => 1/2
    public static Rational simplify(Rational r) {
        int rnum = r.numerator;
        int rden = r.denominator;
        int gcf = Rational.greatestCommonFactor(rnum, rden);
        int newnum = rnum/gcf;
        int newden = rden/gcf;
        Rational t = new Rational(newnum, newden);

        return t;
    }

    // This following method is NOT static, we'll talk about it next class!
    // This returns a string representation of a Rational (e.g. "1/2")




    // *****
    // Here are all of our NON-STATIC methods:
    // *****

    // Returns whether or not the numerator is greater than or equal
    // to the denominator
    // Example:
    // Rational r = new Rational(5,2);
    // System.out.println(r.isImproper()) // true
    public boolean isImproper() {

        return (this.numerator >= this.denominator);
    }

    // Returns whether or not the Rational is currently simplified
    // or not
    // Example:
    // Rational r = new Rational(6,12);
    // System.out.println(r.isSimplified()) // false
    public boolean isSimplified() {
        Rational new1 = new Rational (this.numerator, this.denominator);
        Rational simpnew1 = Rational.simplify(new1);
        if (new1.equals(simpnew1)){
            return true;
        }
            return false;

    }

    // Calculates the double value of our Rational
    // Example:
    // Rational r = new Rational(3,4);
    // System.out.println(r.calculateDecimalValue()) // 0.75
    public double calculateDecimalValue() {
        double num = (double)(this.numerator);
        double den = (double)(this.denominator);

        double dou = (num/den);
        return dou;
    }

    // Returns the Rational we get from raising the rational number to an integer power
    // Example:
    // Rational r = new Rational(2,5);
    // System.out.println(r.pow(2)) // 4/25
    public Rational pow(int exponent) {
        int num = 1;
        for (int i = 0; i < exponent; i++){
            num *= this.numerator;
        }

        int den = 1;
        for (int i = 0; i < exponent; i++){
            den *= this.denominator;
        }
        Rational new1 = new Rational (num, den);
        return new1;
    }

    // Checks to see if either the numerator or denominator match a given number
    // Example:
    // Rational r = new Rational(3,4);
    // System.out.println(r.contains(3)) // true
    public boolean contains(int x) {
        if (this.numerator == x || this.denominator == x){
            return true;
        }
        return false;
    }

    // This returns a string representation of a Rational (e.g. "1/2")
    // This method has already been written for you
    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    // *********
    // Here are is an example of a void method that changes the original Rational:
    // *********

    // This is a non-static version of simplify that returns a Rational
    // Example usage:
    // Rational r = new Rational(2, 4);
    // Rational s = r.simplify2(); // s = 1/2
    public Rational simplify2() {
        int gcf = gcf(this.numerator, this.denominator);
        int nume = this.numerator/gcf;
        int denom = this.denominator/gcf;
        Rational x = new Rational(nume, denom);
        return x;
    }

    // This is a non-static version of simplify that **changes** the original Rational
    // Note that the method is **void** because it doesn't need to return anything
    // Example usage:
    // Rational r = new Rational(2, 4);
    // r.simplify3(); // r is now equal to 1/2
    public void simplify3() {
        int gcf = gcf(this.numerator, this.denominator);
        this.numerator = this.numerator/gcf;
        this.denominator = this.denominator/gcf;
    }

    // Finds the greatest common factor between a and b
    // To find the greatest common factor,
    public static int gcf(int a, int b){
        int maxNum = 1;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0 && b % i == 0) {
                maxNum = i;
            }
        }
        return maxNum;
    }

    // *********
    // Here are some methods that you will write later in class:
    // *********
    // Increments the current value of our Rational (increases the value
    // of the current Rational by 1/1)
    // Example:
    // Rational r = new Rational(3, 5);
    // r.increment(); // r is now 8/5
    public void increment() {
        this.numerator = this.numerator+this.denominator;
        this.denominator = this.denominator;
    }

    // Decrements the current value of our Rational (decreases the value
    // of the current Rational by 1/1)
    // Example:
    // Rational r = new Rational(6, 5);
    // r.decrement(); // r is now 1/5
    public void decrement() {
        this.numerator = this.numerator-this.denominator;
        this.denominator = this.denominator;
    }

    // Given an int input representing the new denominator, changes the
    // current Rational to an equivalent fraction with that new denominator
    // You can assume that the numerator will always end up as a whole number
    // Rational r = new Rational(3, 8);
    // r.changeToEquivalentFraction(64); // r is now 24/64 (which is equivalent to 3/8)
    public void changeToEquivalentFraction(int newDenominator) {
        if (newDenominator>this.denominator){
            int numdiv = newDenominator/this.denominator;
            this.numerator = this.numerator*numdiv;
            this.denominator = newDenominator;
        }
        else{
            int numdiv = this.denominator/newDenominator;
            this.numerator = this.numerator/numdiv;
            this.denominator = newDenominator;
        }

    }

    // **********
    // Methods you'll write for homework:
    // **********
    // Returns whether or not the Rational is a negative number
    // Example:
    // Rational r = new Rational(-3,4);
    // System.out.println(r.isNegative()) // true
    public boolean isNegative() { 
        if (this.numerator<0 && this.denominator<0){
            return false;
        }
        else if(this.numerator<0 || this.denominator<0){
            return true;
        }
        return false;
    }

    // Calculates the reciprocal of a Rational number.
    // The reciprocal of 3/4 is 4/3, the reciprocal of 1/2 is 2/1
    // Example:
    // Rational r = new Rational(5,2);
    // System.out.println(r.reciprocal()) // 2/5
    public Rational reciprocal() {
        int num = this.denominator;
        int den = this.numerator;
        Rational new1 = new Rational (num, den);
        return new1;
    }

    // Checks whether the current Rational is the exactly the same as other
    // Example:
    // Rational r = new Rational(2,5);
    // Rational s = new Rational(2,4);
    // System.out.println(r.equals(s)) // false
    public boolean equals(Rational other) {
        int snum = other.numerator;
        int sden = other.denominator;
        if (this.numerator == snum && this.denominator == sden){
            return true;
        }


        return false; // YOUR CODE HERE
    }

    // Rounds the current Rational to the nearest whole number value
    // Example:
    // Rational r = new Rational(3, 2);
    // r.round(); // r is now 2/1
    public void round() {
        Rational new1 = new Rational (this.numerator, this.denominator);
        Rational simpnew1 = Rational.simplify(new1);
        if (new1 == simpnew1){
            this.numerator = this.numerator;
            this.denominator = this.denominator;
        }
        else{
            double num = (double)(this.numerator);
            double den = (double)(this.denominator);
            double div = num/den;
            double end = div-(int)(div);
            double start =div-end;

            if (end>=0.5) {
                start+=1;
            }
            this.numerator = (int)(start);
            this.denominator = 1;
        }


    }


    }














