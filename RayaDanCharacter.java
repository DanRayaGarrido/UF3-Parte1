import java.io.Serializable;
public class RayaDanCharacter implements Serializable {
    private String name;
    private int level;
    private int experience;

    public RayaDanCharacter(String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public String toString() {
        return name + " | Nivel: " + level + " | EXP: " + experience;
    }
}
