package Programmeren2.Domain;

public enum Difficulty {
    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    EXPERT("Expert"),
    NONE("None"),;

    private String diff;

    private Difficulty(String diff) {
        this.diff = diff;
    }

    public String getValue() {
        return this.diff;
    }

    
}
