package com.usst.model;

import java.util.List;

public class Operation {

    public OperationRoom getOperationRoom() {
        return operationRoom;
    }

    public void setOperationRoom(OperationRoom operationRoom) {
        this.operationRoom = operationRoom;
    }

    private OperationRoom operationRoom;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    private Patient patient;

    private Doctor doctor;

    private List<Nurse> nurses;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getShowNurses() {

        String showNurses = "";
        for (Nurse nurse : nurses) {
            showNurses = showNurses + nurse.getId() + "  " + nurse.getName() + "<br>";
        }
        return showNurses;
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(List<Nurse> nurses) {
        this.nurses = nurses;
    }

    public Analgesist getAnalgesist() {
        return analgesist;
    }

    public void setAnalgesist(Analgesist analgesist) {
        this.analgesist = analgesist;
    }

    private String showNurses;

    public String getShowTime() {
        showTime = date + " " + startTime + ":00-" + endTime + ":00";
        return showTime;
    }

    private String showTime;

    private Analgesist analgesist;

    private int id;

    private int doctorId;

    private int operationRoomId;

    private int analgesistId;

    private int patientId;

    private String name;

    private String date;

    private int startTime;

    private int endTime;

    private int status;

    private int doctorStatus;

    private int analgesistStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getOperationRoomId() {
        return operationRoomId;
    }

    public void setOperationRoomId(int operationRoomId) {
        this.operationRoomId = operationRoomId;
    }

    public int getAnalgesistId() {
        return analgesistId;
    }

    public void setAnalgesistId(int analgesistId) {
        this.analgesistId = analgesistId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDoctorStatus() {
        return doctorStatus;
    }

    public void setDoctorStatus(int doctorStatus) {
        this.doctorStatus = doctorStatus;
    }

    public int getAnalgesistStatus() {
        return analgesistStatus;
    }

    public void setAnalgesistStatus(int analgesistStatus) {
        this.analgesistStatus = analgesistStatus;
    }
}