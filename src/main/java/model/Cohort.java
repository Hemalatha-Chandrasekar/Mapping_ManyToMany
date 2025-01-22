package model;
import jakarta.persistence.*;

@Entity
@Table(name="cohort")
public class Cohort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cohortId;
    private String cohortName;
    private String duration;

    public Cohort(String javaDeveloper, String s) {
    }

    public int getCohortId() {
        return cohortId;
    }

    public void setCohortId(int cohortId) {
        this.cohortId = cohortId;
    }

    public String getCohortName() {
        return cohortName;
    }

    public void setCohortName(String cohortName) {
        this.cohortName = cohortName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Cohort{" +
                "cohortId=" + cohortId +
                ", cohortName='" + cohortName + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}