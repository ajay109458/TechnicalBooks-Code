package Chap2;

public class GreenApplePredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.color == Color.GREEN;
    }
}
