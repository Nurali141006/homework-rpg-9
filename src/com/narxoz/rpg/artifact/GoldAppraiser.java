package com.narxoz.rpg.artifact;

public class GoldAppraiser implements ArtifactVisitor {
    private int totalValue = 0;

    @Override
    public void visit(Weapon weapon) {
        int price = weapon.getValue() + weapon.getDamage() * 5;
        totalValue += price;
        System.out.println("GoldAppraiser: Weapon " + weapon.getName() + " costs " + price + " gold.");
    }

    @Override
    public void visit(Potion potion) {
        int price = potion.getValue() + potion.getHealAmount() * 2;
        totalValue += price;
        System.out.println("GoldAppraiser: Potion " + potion.getName() + " costs " + price + " gold.");
    }

    @Override
    public void visit(Scroll scroll) {
        int price = scroll.getValue() + 30;
        totalValue += price;
        System.out.println("GoldAppraiser: Scroll " + scroll.getName() + " costs " + price + " gold.");
    }

    @Override
    public void visit(Ring ring) {
        int price = ring.getValue() + 50;
        totalValue += price;
        System.out.println("GoldAppraiser: Ring " + ring.getName() + " costs " + price + " gold.");
    }

    @Override
    public void visit(Armor armor) {
        int price = armor.getValue() + armor.getDefenseBonus() * 4;
        totalValue += price;
        System.out.println("GoldAppraiser: Armor " + armor.getName() + " costs " + price + " gold.");
    }

    public int getTotalValue() {
        return totalValue;
    }
}