package Programmeren2.Domain;

public enum Gender {
    MALE("Male"),
    FEMALE("female"),
    NONE("None");
    private String value;

    private Gender(String value) {
        this.value = value;
    }

    // get value within parentheses
    public String getValue() {
        return this.value;
    }

    // convert value within parentheses to Gender
    public static Gender convertToGender(String value){
        value = value.trim().toLowerCase();
        if(value.equals("male")){
            return MALE;
        }
        if(value.equals("female")){
            return FEMALE;
        }
        else {
            return NONE;
        }
    }
}
