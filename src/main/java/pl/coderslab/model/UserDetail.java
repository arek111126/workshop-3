package pl.coderslab.model;

public class UserDetail {

    private  String exerciseTitle;
    private  String create;
    private  int solutionId;

    public UserDetail(String userTitle, String create, int solutionId) {
        this.exerciseTitle = userTitle;
        this.create = create;
        this.solutionId = solutionId;
    }

    public UserDetail() {
    }

    public String getExerciseTitle() {
        return exerciseTitle;
    }

    public void setExerciseTitle(String exerciseTitle) {
        this.exerciseTitle = exerciseTitle;
    }

    public String getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = create;
    }

    public int getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(int solutionId) {
        this.solutionId = solutionId;
    }
}
