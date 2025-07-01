package com.example.dashboard;

public class DeliveryRequest {
    private String userName;
    private String bookTitle;
    private String status;

    public DeliveryRequest(String userName, String bookTitle, String status) {
        this.userName = userName;
        this.bookTitle = bookTitle;
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getStatus() {
        return status;
    }

    public String getAddress() {
        return "Default Address";  // Placeholder if needed for XML binding
    }
}
