package com.narxoz.rpg.artifact;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Artifact> artifacts = new ArrayList<>();

    public void addArtifact(Artifact artifact) {
        artifacts.add(artifact);
    }
    public List<Artifact> getArtifacts() {
    return new ArrayList<>(artifacts);
}

    public void accept(ArtifactVisitor visitor) {
        for (Artifact artifact : artifacts) {
            artifact.accept(visitor);
        }
    }

    public List<String> getArtifactNames() {
        List<String> names = new ArrayList<>();
        for (Artifact artifact : artifacts) {
            names.add(artifact.getName());
        }
        return names;
    }

    public int size() {
        return artifacts.size();
    }

    public Inventory copy() {
        Inventory copy = new Inventory();
        for (Artifact artifact : artifacts) {
            copy.addArtifact(artifact);
        }
        return copy;
    }
}