public interface Calculator {
    double add(Double x, Double y)
            throws NullParameterException, OverflowException, UnderflowException;

    double divide(Double x, Double y)
        throws NullParameterException, MyArithmeticException;

    double average(Double[] t)
        throws NullParameterException, OverflowException, UnderflowException, MyArithmeticException;
}
