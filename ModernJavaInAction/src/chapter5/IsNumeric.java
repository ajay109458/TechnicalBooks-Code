package chapter5;

public class IsNumeric implements ValidationStrategy{
    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}
