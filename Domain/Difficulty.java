package Programmeren2.Domain;

public enum Difficulty {
    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    EXPERT("Expert"),
    NONE("None"),;

    private String value;

    private Difficulty(String diff) {
        this.value = diff;
    }

    // get value within parentheses
    public String getValue() {
        return this.value;
    }

    // convert value within parentheses to Difficulty
    public static Difficulty convertToDiff(String value){
        value = value.trim().toLowerCase();
        if(value.equals("beginner")){
            return BEGINNER;
        }
        if(value.equals("intermediate")){
            return INTERMEDIATE;
        }
        if(value.equals("expert")){
            return EXPERT;
        }
        else {
            return NONE;
        }
    }
}
