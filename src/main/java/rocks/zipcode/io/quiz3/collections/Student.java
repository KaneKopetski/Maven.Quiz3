package rocks.zipcode.io.quiz3.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leon on 10/12/2018.
 */
public class Student {
    List<Lab> labs ;

    public Student() {
        this.labs = new ArrayList<>();
    }

    public Student(List<Lab> labs) {
        this.labs = labs;
    }

    public Lab getLab(String labName) {
        for (Lab lab : labs) {
            if (lab.getName().equals(labName)) {
                return lab;
            }
        }
         return null;
    }

    public void setLabStatus(String labName, LabStatus labStatus) {
        Lab lab = getLab(labName);
        if (lab == null) {
            throw new UnsupportedOperationException();
        }
        lab.setStatus(labStatus);
    }

    public void forkLab(Lab lab) {
        labs.add(lab);
        lab.setStatus(LabStatus.PENDING);
    }

    public LabStatus getLabStatus(String labName) {
        for (Lab lab : labs) {
            if (lab.getName().equals(labName)) {
                return lab.getStatus();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        labs.sort((lab1, lab2) -> lab1.getName().compareTo(lab2.getName()));

        StringBuilder sb = new StringBuilder();
        for (Lab lab : labs) {
            sb.append(lab.getName() + " > " + lab.getStatus() + "\n");
        }
        return sb.toString().trim();
    }
}
