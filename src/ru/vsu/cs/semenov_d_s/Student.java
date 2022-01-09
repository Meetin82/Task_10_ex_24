package ru.vsu.cs.semenov_d_s;

import java.util.List;

public class Student {

    String fullName;
    boolean certificate;
    int physicsScores;
    int mathScores;
    int totalScores;
    int rusScores;

    public Student(List<String> data) {
        this.fullName = data.get(0);
        this.certificate = data.get(1).equals("есть");
        this.mathScores = Integer.parseInt(data.get(2));
        this.physicsScores = Integer.parseInt(data.get(3));
        this.rusScores = Integer.parseInt(data.get(4));
        this.totalScores = physicsScores + mathScores + rusScores;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean isCertificate() {
        return certificate;
    }

    public int getTotalScores() {
        return totalScores;
    }

    public int getMathScores() {
        return mathScores;
    }

    public int getPhysicsScores() {
        return physicsScores;
    }

    public int getRusScores() {
        return rusScores;
    }

    public String toString() {
        String availabilityOfCertificate;
        if (certificate) {
            availabilityOfCertificate = "есть";
        } else {
            availabilityOfCertificate = "нет";
        }
        return fullName + " "
                + availabilityOfCertificate + " "
                + mathScores + " "
                + physicsScores + " "
                + rusScores;
    }
}

