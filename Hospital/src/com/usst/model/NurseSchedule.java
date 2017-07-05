package com.usst.model;

public class NurseSchedule {
    private int operationId;

    private int nurseId;

    private int nurseStatus;

    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public int getNurseStatus() {
        return nurseStatus;
    }

    public void setNurseStatus(int nurseStatus) {
        this.nurseStatus = nurseStatus;
    }
}