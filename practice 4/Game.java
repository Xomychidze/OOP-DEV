

interface Attackable {
    void receiveAttack(int damage);
}

interface Pushable {
    void push(int dx, int dy);
}

interface Interactable {
    void interact();
}

abstract class GameObject {
    private String name;
    private int x;
    private int y;

    public GameObject(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() { return name; }
    public int getX() { return x; }
    public int getY() { return y; }

    protected void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract String describe();

    @Override
    public String toString() {
        return String.format("%s [%d, %d]", name, x, y);
    }
}

abstract class LivingEntity extends GameObject {
    private int health;
    private int maxHealth;
    private boolean alive;

    public LivingEntity(String name, int x, int y, int maxHealth) {
        super(name, x, y);
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.alive = true;
    }

    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }
    public boolean isAlive() { return alive; }

    public void takeDamage(int damage) {
        if (!alive) {
            System.out.println(getName() + " уже мёртв.");
            return;
        }
        health = Math.max(0, health - damage);
        System.out.printf("  %s получает %d урона! HP: %d/%d%n",
                getName(), damage, health, maxHealth);
        if (health == 0) {
            alive = false;
            die();
        }
    }

    protected abstract void die();

    @Override
    public String describe() {
        return String.format("%s | HP: %d/%d | %s",
                getName(), health, maxHealth, alive ? "жив" : "мёртв");
    }
}

abstract class StaticObject extends GameObject {
    private boolean destroyed;

    public StaticObject(String name, int x, int y) {
        super(name, x, y);
        this.destroyed = false;
    }

    public boolean isDestroyed() { return destroyed; }

    protected void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public abstract void destroy();

    @Override
    public String describe() {
        return getName() + " | позиция: [" + getX() + ", " + getY() + "]"
                + (destroyed ? " | УНИЧТОЖЕН" : "");
    }
}

class Knight extends LivingEntity {
    private String weaponName;
    private int attackPower;

    public Knight(String name, int x, int y, String weaponName, int attackPower) {
        super(name, x, y, 100);
        this.weaponName = weaponName;
        this.attackPower = attackPower;
    }

    public void move(int dx, int dy) {
        setPosition(getX() + dx, getY() + dy);
        System.out.printf("%s перемещается в [%d, %d]%n", getName(), getX(), getY());
    }

    public void attack(Attackable target) {
        System.out.printf("%s атакует %s оружием «%s» (урон: %d)!%n",
                getName(), ((GameObject) target).getName(), weaponName, attackPower);
        target.receiveAttack(attackPower);
    }

    public void push(Pushable target, int dx, int dy) {
        System.out.printf("%s толкает %s на (%d, %d)...%n",
                getName(), ((GameObject) target).getName(), dx, dy);
        target.push(dx, dy);
    }

    public void interact(Interactable target) {
        System.out.printf("%s взаимодействует с %s...%n",
                getName(), ((GameObject) target).getName());
        target.interact();
    }

    @Override
    protected void die() {
        System.out.println("💀 " + getName() + " пал в бою... Конец игры.");
    }
}

class Goblin extends LivingEntity implements Attackable {
    private String type;

    public Goblin(String name, int x, int y, int health, String type) {
        super(name, x, y, health);
        this.type = type;
    }

    @Override
    public void receiveAttack(int damage) {
        takeDamage(damage);
    }

    @Override
    protected void die() {
        System.out.println("  ☠ " + getName() + " (" + type + ") убит!");
    }

    @Override
    public String describe() {
        return super.describe() + " | Тип: " + type;
    }
}

class WoodenBox extends StaticObject implements Attackable, Pushable {

    public WoodenBox(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void receiveAttack(int damage) {
        System.out.println("  " + getName() + " разлетается в щепки!");
        destroy();
    }

    @Override
    public void push(int dx, int dy) {
        if (isDestroyed()) {
            System.out.println("  " + getName() + " уже сломан — толкать нечего.");
            return;
        }
        setPosition(getX() + dx, getY() + dy);
        System.out.printf("  %s сдвинут на новую позицию [%d, %d]%n",
                getName(), getX(), getY());
    }

    @Override
    public void destroy() {
        setDestroyed(true);
        System.out.println("  [УНИЧТОЖЕН] " + getName());
    }
}

class Rock extends StaticObject implements Pushable {

    public Rock(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void push(int dx, int dy) {
        int realDx = Integer.signum(dx);
        int realDy = Integer.signum(dy);
        setPosition(getX() + realDx, getY() + realDy);
        System.out.printf("  %s тяжело сдвигается на [%d, %d]%n",
                getName(), getX(), getY());
    }

    @Override
    public void destroy() {
        System.out.println(getName() + " уничтожен.");
    }
}

class Chest extends StaticObject implements Pushable, Interactable {
    private boolean opened;
    private String loot;

    public Chest(String name, int x, int y, String loot) {
        super(name, x, y);
        this.opened = false;
        this.loot = loot;
    }

    @Override
    public void push(int dx, int dy) {
        setPosition(getX() + dx, getY() + dy);
        System.out.printf("  %s сдвинут на позицию [%d, %d]%n",
                getName(), getX(), getY());
    }

    @Override
    public void interact() {
        if (opened) {
            System.out.println("  " + getName() + " уже открыт и пуст.");
        } else {
            opened = true;
            System.out.println("  🔓 " + getName() + " открывается...");
            System.out.println("  Внутри: " + loot + "!");
        }
    }

    @Override
    public void destroy() {
        setDestroyed(true);
        System.out.println(getName() + " уничтожен.");
    }

    @Override
    public String describe() {
        return super.describe() + " | " + (opened ? "Открыт" : "Закрыт") + " | Лут: " + loot;
    }
}

public class Game {
    public static void main(String[] args) {

        Knight knight = new Knight("Сэр Артур", 0, 0, "Меч Рассвета", 35);
        Goblin goblin1 = new Goblin("Гоблин-воин", 3, 2, 50, "Воин");
        Goblin goblin2 = new Goblin("Гоблин-шаман", 5, 1, 30, "Шаман");
        WoodenBox box = new WoodenBox("Деревянный ящик", 1, 1);
        Rock rock = new Rock("Большой камень", 2, 0);
        Chest chest = new Chest("Старинный сундук", 4, 3, "Золото x50 и зелье здоровья");

        System.out.println(knight.describe());
        System.out.println(goblin1.describe());
        System.out.println(goblin2.describe());
        System.out.println(box.describe());
        System.out.println(rock.describe());
        System.out.println(chest.describe());

        knight.move(1, 1);
        knight.attack(box);
        knight.push(rock, 3, 0);
        knight.push(chest, 1, 0);
        knight.interact(chest);
        knight.interact(chest);

        knight.attack(goblin1);
        knight.attack(goblin1);
        knight.attack(goblin2);

        System.out.println(knight.describe());
        System.out.println(goblin1.describe());
        System.out.println(goblin2.describe());
        System.out.println(box.describe());
        System.out.println(rock.describe());
        System.out.println(chest.describe());
    }
}