/**
 * TASK 2 — Swimmable extends Moveable
 *
 * An interface extending another interface:
 *  - Swimmable "is-a" Moveable (everything that swims can also move)
 *  - Adds swim-specific methods on top
 *
 * Classes implementing Swimmable MUST implement ALL methods:
 *   move() and getSpeed() (from Moveable) + swim() and getDiveDepth() (from Swimmable)
 */
public interface Swimmable extends Moveable {
    void swim();
    int  getDiveDepth(); // max depth in meters
}
