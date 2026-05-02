package com.narxoz.rpg.artifact;

public class EnchantmentScanner implements ArtifactVisitor {

    @Override
    public void visit(Weapon weapon) {
        System.out.println("EnchantmentScanner: " + weapon.getName() + " has battle energy. Damage: " + weapon.getDamage());
    }

    @Override
    public void visit(Potion potion) {
        System.out.println("EnchantmentScanner: " + potion.getName() + " contains healing magic. Heal: " + potion.getHealAmount());
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println("EnchantmentScanner: " + scroll.getName() + " casts spell: " + scroll.getSpellName());
    }

    @Override
    public void visit(Ring ring) {
        System.out.println("EnchantmentScanner: " + ring.getName() + " has effect: " + ring.getEffect());
    }

    @Override
    public void visit(Armor armor) {
        System.out.println("EnchantmentScanner: " + armor.getName() + " protects with defense bonus: " + armor.getDefenseBonus());
    }
}