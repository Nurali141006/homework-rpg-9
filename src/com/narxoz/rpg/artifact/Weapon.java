package com.narxoz.rpg.artifact;

public class Weapon extends Artifact {
    private final int damage;

    public Weapon(String name, int value, int weight, int damage) {
        super(name, value, weight);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void accept(ArtifactVisitor visitor) {
        visitor.visit(this);
    }
}