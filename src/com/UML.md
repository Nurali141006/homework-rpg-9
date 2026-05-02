Diagram 1

--|> = inheritance
..|> = implements interface
--> = uses / association

ArtifactVisitor <<interface>>                               
+ visit(weapon: Weapon): void
+ visit(potion: Potion): void
+ visit(scroll: Scroll): void
+ visit(ring: Ring): void
+ visit(armor: Armor): void

Artifact <<abstract>>
- name: String
- value: int
- weight: int
+ accept(visitor: ArtifactVisitor): void

Weapon
- damage: int
+ accept(visitor): void

Potion
- healAmount: int
+ accept(visitor): void

Scroll
- spellName: String
+ accept(visitor): void

Ring
- effect: String
+ accept(visitor): void

Armor
- defenseBonus: int
+ accept(visitor): void



GoldAppraiser
EnchantmentScanner
CurseDetector
WeightCalculator

Inventory
- artifacts: List<Artifact>
+ addArtifact(artifact): void
+ accept(visitor: ArtifactVisitor): void
+ size(): int
+ getArtifacts(): List<Artifact>

Weapon, Potion, Scroll, Ring, Armor --|> Artifact
GoldAppraiser ..|> ArtifactVisitor
EnchantmentScanner ..|> ArtifactVisitor
CurseDetector ..|> ArtifactVisitor
WeightCalculator ..|> ArtifactVisitor
Inventory --> Artifact
Artifact --> ArtifactVisitor



Diagram 2

Hero
- name: String
- hp: int
- maxHp: int
- mana: int
- gold: int
- attackPower: int
- defense: int
- inventory: Inventory
+ createMemento(): HeroMemento
+ restoreFromMemento(memento: HeroMemento): void
+ takeDamage(amount): void
+ spendMana(amount): boolean
+ spendGold(amount): boolean

HeroMemento
- name: String
- hp: int
- mana: int
- gold: int
- maxHp: int
- attackPower: int
- defense: int
- inventorySnapshot: List<Artifact>
~ getHp(): int
~ getMana(): int
~ getGold(): int
~ getInventorySnapshot(): List<Artifact>

Caretaker
- history: Stack<HeroMemento>
+ save(memento: HeroMemento): void
+ undo(): HeroMemento
+ peek(): HeroMemento
+ size(): int

ChronomancerEngine
+ runVault(party: List<Hero>): VaultRunResult

VaultRunResult
- artifactsAppraised: int
- mementosCreated: int
- restoredCount: int
+ toString(): String

Hero --> HeroMemento : creates/restores
Caretaker --> HeroMemento : stores
ChronomancerEngine --> Hero
ChronomancerEngine --> Caretaker
ChronomancerEngine --> VaultRunResult
Hero --> Inventory
HeroMemento --> Artifact

