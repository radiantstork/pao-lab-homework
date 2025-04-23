public class MyCalculator implements Calculator {
    @Override
    public double add(Double x, Double y) throws NullParameterException, OverflowException, UnderflowException {
        if (x == null || y == null) {
            throw new NullParameterException("Null parameters add()");
        }
        double z = x + y;
        if (z == Double.POSITIVE_INFINITY) {
            throw new OverflowException("Overflow add()");
        }
        if (z == Double.NEGATIVE_INFINITY) {
            throw new UnderflowException("Underflow add()");
        }
        return z;
    }

    @Override
    public double divide(Double x, Double y) throws NullParameterException, MyArithmeticException {
        if (x == null || y == null) {
            throw new NullParameterException("Null parameters divide()");
        }
        if (y == 0) {
            throw new MyArithmeticException("Division by zero divide()");
        }
        return x / y;
    }

    @Override
    public double average(Double[] t) throws NullParameterException, OverflowException, UnderflowException, MyArithmeticException {
        if (t == null) {
            throw new NullParameterException("Null parameters average()");
        }

        double sum = 0;
        for (Double x : t) {
            sum = add(x, sum);
        }

        return divide(sum, (double) t.length);
    }
}
