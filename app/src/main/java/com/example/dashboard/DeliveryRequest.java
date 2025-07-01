package com.example.dashboard;

public class DeliveryRequest {
    String studentName, bookName, status;

    public DeliveryRequest(String studentName, String bookName, String status) {
        this.studentName = studentName;
        this.bookName = bookName;
        this.status = status;
    }

    public String getStudentName() { return studentName; }
    public String getBookName() { return bookName; }
    public String getStatus() { return status; }
}
