package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Homework 9 Demo: Visitor + Memento ===");

        Hero hero1 = new Hero("Arlan", 100, 50, 15, 5, 120, null);
        Hero hero2 = new Hero("Darian", 130, 30, 20, 10, 80, null);

        List<Hero> party = List.of(hero1, hero2);

        ChronomancerEngine engine = new ChronomancerEngine();
        VaultRunResult result = engine.runVault(party);

        System.out.println("\nFinal Vault Result:");
        System.out.println(result);
    }
}