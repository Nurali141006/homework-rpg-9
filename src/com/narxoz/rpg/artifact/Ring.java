package com.narxoz.rpg.artifact;

public class Ring extends Artifact {
    private final String effect;

    public Ring(String name, int value, int weight, String effect) {
        super(name, value, weight);
        this.effect = effect;
    }

    public String getEffect() {
        return effect;
    }

    @Override
    public void accept(ArtifactVisitor visitor) {
        visitor.visit(this);
    }
}