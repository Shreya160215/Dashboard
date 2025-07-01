package com.example.dashboard;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class TrackDeliveryActivity extends AppCompatActivity {

    TextView tvBookName, tvTrackingStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);

        tvBookName = findViewById(R.id.tvBookName);
        tvTrackingStatus = findViewById(R.id.tvTrackingStatus);

        String bookTitle = getIntent().getStringExtra("bookTitle");

        if (bookTitle != null) {
            tvBookName.setText("Book: " + bookTitle);

            // Firestore se status fetch karo
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            db.collection("book_orders")
                .whereEqualTo("bookTitle", bookTitle)
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    if (!queryDocumentSnapshots.isEmpty()) {
                        QueryDocumentSnapshot doc = (QueryDocumentSnapshot) queryDocumentSnapshots.getDocuments().get(0);
                        String status = doc.getString("status");
                        updateTrackingStatus(status);
                    } else {
                        tvTrackingStatus.setText("Tracking:\nNo delivery found for this book.");
                    }
                })
                .addOnFailureListener(e -> {
                    tvTrackingStatus.setText("Tracking:\nError fetching delivery status.");
                });
        }
    }

    private void updateTrackingStatus(String status) {
        String trackingInfo = "📦 Book picked up";
        if (status == null) {
            trackingInfo = "⌛ Not yet dispatched";
        } else {
            switch (status.toLowerCase()) {
                case "in transit":
                    trackingInfo += "\n🚚 Out for delivery";
                    break;
                case "delivered":
                    trackingInfo += "\n🚚 Out for delivery\n✅ Delivered";
                    break;
                default:
                    trackingInfo = "⌛ Not yet dispatched";
                    break;
            }
        }
        tvTrackingStatus.setText("Tracking:\n" + trackingInfo);
    }
}
