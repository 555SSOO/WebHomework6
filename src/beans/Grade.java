package beans;

public class Grade {

    public Grade(){}

    public Grade(String assistant_name, Double grade){
        this.assistant_name = assistant_name;
        this.grade = grade;
    }

    private String assistant_name;

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    private Double grade;

    public String getAssistant_name() {
        return assistant_name;
    }

    public Double getGrade() {
        return grade;
    }
}
