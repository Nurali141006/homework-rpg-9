package com.narxoz.rpg.artifact;

public class CurseDetector implements ArtifactVisitor {

    @Override
    public void visit(Weapon weapon) {
        if (weapon.getDamage() > 25) {
            System.out.println("CurseDetector: " + weapon.getName() + " is dangerous and may be cursed.");
        } else {
            System.out.println("CurseDetector: " + weapon.getName() + " is safe.");
        }
    }

    @Override
    public void visit(Potion potion) {
        System.out.println("CurseDetector: " + potion.getName() + " is safe to drink.");
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println("CurseDetector: " + scroll.getName() + " has unstable ancient magic.");
    }

    @Override
    public void visit(Ring ring) {
        if (ring.getEffect().toLowerCase().contains("dark")) {
            System.out.println("CurseDetector: " + ring.getName() + " is cursed.");
        } else {
            System.out.println("CurseDetector: " + ring.getName() + " is safe.");
        }
    }

    @Override
    public void visit(Armor armor) {
        System.out.println("CurseDetector: " + armor.getName() + " has no curse.");
    }
}