package com.narxoz.rpg.artifact;

public class WeightCalculator implements ArtifactVisitor {
    private int totalWeight = 0;

    @Override
    public void visit(Weapon weapon) {
        totalWeight += weapon.getWeight();
        System.out.println("WeightCalculator: Weapon weight = " + weapon.getWeight());
    }

    @Override
    public void visit(Potion potion) {
        totalWeight += potion.getWeight();
        System.out.println("WeightCalculator: Potion weight = " + potion.getWeight());
    }

    @Override
    public void visit(Scroll scroll) {
        totalWeight += scroll.getWeight();
        System.out.println("WeightCalculator: Scroll weight = " + scroll.getWeight());
    }

    @Override
    public void visit(Ring ring) {
        totalWeight += ring.getWeight();
        System.out.println("WeightCalculator: Ring weight = " + ring.getWeight());
    }

    @Override
    public void visit(Armor armor) {
        totalWeight += armor.getWeight();
        System.out.println("WeightCalculator: Armor weight = " + armor.getWeight());
    }

    public int getTotalWeight() {
        return totalWeight;
    }
}