package Chap2;

public class LighterApplePredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.weight < 100;
    }
}
