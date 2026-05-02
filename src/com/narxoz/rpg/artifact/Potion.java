package com.narxoz.rpg.artifact;

public class Potion extends Artifact {
    private final int healAmount;

    public Potion(String name, int value, int weight, int healAmount) {
        super(name, value, weight);
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }

    @Override
    public void accept(ArtifactVisitor visitor) {
        visitor.visit(this);
    }
}