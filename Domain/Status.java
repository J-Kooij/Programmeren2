package Programmeren2.Domain;

public enum Status {
    CONCEPT("Concept"),
    ACTIVE("Active"),
    ARCHIVED("Archived");

    private String value;

    private Status(String value) {
        this.value = value;
    }

    // get value within parentheses
    public String getValue() {
        return this.value;
    }

    // convert value within parentheses to Status
    public static Status convertToStatus(String value) {
        value = value.trim().toLowerCase();
        if (value.equals("concept")) {
            return CONCEPT;
        }
        if (value.equals("active")) {
            return ACTIVE;
        } else {
            return ARCHIVED;
        }
    }
}
