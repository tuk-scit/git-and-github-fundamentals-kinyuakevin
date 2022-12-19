package code;

/**
 *
 * @author
 */
public class Health {

    private boolean diabeticProblem;
    private boolean breathingProblem;

    Health() {
        diabeticProblem = false;
        breathingProblem = false;
    }

    public boolean isDiabeticProblem() {
        return diabeticProblem;
    }

    public void setDiabeticProblem(boolean diabeticProblem) {
        this.diabeticProblem = diabeticProblem;
    }

    public boolean isBreathingProblem() {
        return breathingProblem;
    }

    public void setBreathingProblem(boolean breathingProblem) {
        this.breathingProblem = breathingProblem;
    }

    public Health(boolean diabeticProblem, boolean breathingProblem) {
        this.diabeticProblem = diabeticProblem;
        this.breathingProblem = breathingProblem;
    }

    @Override
    public String toString() {
        return diabeticProblem + "," + breathingProblem + ',';
    }

}
