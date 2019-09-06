package pl.coderslab.model;

public class MainViewData {
    private String exerciseTitle;
    private String authorSolution;
    private String addSolutionData;
    private int solutionId;

    public MainViewData(String exerciseTitle, String authorSolution, String addDate, int solutionId) {
        this.exerciseTitle = exerciseTitle;
        this.authorSolution = authorSolution;
        this.addSolutionData = addDate;
        this.solutionId = solutionId;
    }

    public MainViewData() {
    }

    public String getExerciseTitle() {
        return exerciseTitle;
    }

    public void setExerciseTitle(String exerciseTitle) {
        this.exerciseTitle = exerciseTitle;
    }

    public String getAuthorSolution() {
        return authorSolution;
    }

    public void setAuthorSolution(String authorSolution) {
        this.authorSolution = authorSolution;
    }

    public String getAddSolutionData() {
        return addSolutionData;
    }

    public void setAddSolutionData(String addSolutionData) {
        this.addSolutionData = addSolutionData;
    }

    public int getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(int solutionId) {
        this.solutionId = solutionId;
    }
}
