package com.narxoz.rpg.vault;

import com.narxoz.rpg.artifact.*;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.combatant.HeroMemento;
import com.narxoz.rpg.memento.Caretaker;

import java.util.List;

public class ChronomancerEngine {

    public VaultRunResult runVault(List<Hero> party) {
        int artifactsChecked = 0;
        int snapshotsTaken = 0;
        int rewindsUsed = 0;

        System.out.println("\n=== Chronomancer's Vault Started ===");

        Inventory vaultInventory = new Inventory();
        vaultInventory.addArtifact(new Weapon("Shadow Blade", 100, 8, 30));
        vaultInventory.addArtifact(new Potion("Healing Potion", 40, 1, 25));
        vaultInventory.addArtifact(new Scroll("Fire Scroll", 70, 1, "Fireball"));
        vaultInventory.addArtifact(new Ring("Dark Ring", 120, 1, "dark power"));
        vaultInventory.addArtifact(new Armor("Knight Armor", 150, 15, 20));

        artifactsChecked = vaultInventory.size();

        System.out.println("\n--- Appraisal starts ---");

        GoldAppraiser goldAppraiser = new GoldAppraiser();
        vaultInventory.accept(goldAppraiser);

        vaultInventory.accept(new EnchantmentScanner());
        vaultInventory.accept(new CurseDetector());

        WeightCalculator weightCalculator = new WeightCalculator();
        vaultInventory.accept(weightCalculator);

        System.out.println("--- Appraisal ends ---");

        Caretaker caretaker = new Caretaker();

        for (Hero hero : party) {
            System.out.println("\nHero before snapshot:");
            System.out.println(hero);

            System.out.println("Snapshot taken for " + hero.getName());
            caretaker.save(hero.createMemento());
            snapshotsTaken++;

            System.out.println("Trap activated!");
            hero.takeDamage(40);
            hero.spendMana(10);
            hero.spendGold(20);

            System.out.println("Hero after trap:");
            System.out.println(hero);

            System.out.println("Rewind happens for " + hero.getName());
            HeroMemento memento = caretaker.undo();

            if (memento != null) {
                hero.restoreFromMemento(memento);
                rewindsUsed++;
            }

            System.out.println("Hero after rewind:");
            System.out.println(hero);
        }

        System.out.println("\n=== Chronomancer's Vault Finished ===");

        return new VaultRunResult(
                artifactsChecked,
                snapshotsTaken,
                rewindsUsed
        );
    }
}