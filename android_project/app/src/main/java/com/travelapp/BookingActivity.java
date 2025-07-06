package com.travelapp;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class BookingActivity extends AppCompatActivity {

    private ImageButton btnBackBooking;
    private ImageButton btnNotification;
    private RadioGroup radioGroupTripType;
    private RadioButton radioOneWay;
    private RadioButton radioRoundTrip;
    private EditText editTextDeparture;
    private EditText editTextDestination;
    private ImageButton btnSwapLocations;
    private EditText editTextDepartureDate;
    private TextView labelReturnDate;
    private LinearLayout layoutReturnDate;
    private EditText editTextReturnDate;
    private EditText editTextPassengers;
    private Spinner spinnerSeatClass;
    private Button btnSearchFlights;
    private RecyclerView recyclerViewRecentFlights;
    
    private Calendar calendar;
    private SimpleDateFormat dateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        initViews();
        setupSpinner();
        setupClickListeners();
        setupRecyclerView();
        
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    }

    private void initViews() {
        btnBackBooking = findViewById(R.id.btnBackBooking);
        btnNotification = findViewById(R.id.btnNotification);
        radioGroupTripType = findViewById(R.id.radioGroupTripType);
        radioOneWay = findViewById(R.id.radioOneWay);
        radioRoundTrip = findViewById(R.id.radioRoundTrip);
        editTextDeparture = findViewById(R.id.editTextDeparture);
        editTextDestination = findViewById(R.id.editTextDestination);
        btnSwapLocations = findViewById(R.id.btnSwapLocations);
        editTextDepartureDate = findViewById(R.id.editTextDepartureDate);
        labelReturnDate = findViewById(R.id.labelReturnDate);
        layoutReturnDate = findViewById(R.id.layoutReturnDate);
        editTextReturnDate = findViewById(R.id.editTextReturnDate);
        editTextPassengers = findViewById(R.id.editTextPassengers);
        spinnerSeatClass = findViewById(R.id.spinnerSeatClass);
        btnSearchFlights = findViewById(R.id.btnSearchFlights);
        recyclerViewRecentFlights = findViewById(R.id.recyclerViewRecentFlights);
    }

    private void setupSpinner() {
        String[] seatClasses = {
            getString(R.string.seat_economy),
            getString(R.string.seat_premium_economy),
            getString(R.string.seat_business),
            getString(R.string.seat_first)
        };
        
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, 
            android.R.layout.simple_spinner_item, seatClasses);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSeatClass.setAdapter(adapter);
    }

    private void setupClickListeners() {
        btnBackBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BookingActivity.this, "Thông báo", Toast.LENGTH_SHORT).show();
            }
        });

        radioGroupTripType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioRoundTrip) {
                    labelReturnDate.setVisibility(View.VISIBLE);
                    layoutReturnDate.setVisibility(View.VISIBLE);
                } else {
                    labelReturnDate.setVisibility(View.GONE);
                    layoutReturnDate.setVisibility(View.GONE);
                }
            }
        });

        editTextDeparture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLocationPicker(true);
            }
        });

        editTextDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLocationPicker(false);
            }
        });

        btnSwapLocations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapLocations();
            }
        });

        editTextDepartureDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker(true);
            }
        });

        editTextReturnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker(false);
            }
        });

        editTextPassengers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPassengerPicker();
            }
        });

        btnSearchFlights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSearchFlights();
            }
        });
    }

    private void setupRecyclerView() {
        recyclerViewRecentFlights.setLayoutManager(
            new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        // Set adapter for recent flights here
    }

    private void showLocationPicker(boolean isDeparture) {
        // Implement location picker dialog
        String[] cities = {"Hà Nội", "Hồ Chí Minh", "Đà Nẵng", "Nha Trang", "Phú Quốc", "Cần Thơ"};
        
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(isDeparture ? "Chọn điểm đi" : "Chọn điểm đến");
        builder.setItems(cities, new android.content.DialogInterface.OnClickListener() {
            @Override
            public void onClick(android.content.DialogInterface dialog, int which) {
                if (isDeparture) {
                    editTextDeparture.setText(cities[which]);
                } else {
                    editTextDestination.setText(cities[which]);
                }
            }
        });
        builder.show();
    }

    private void swapLocations() {
        String departure = editTextDeparture.getText().toString();
        String destination = editTextDestination.getText().toString();
        
        editTextDeparture.setText(destination);
        editTextDestination.setText(departure);
    }

    private void showDatePicker(boolean isDepartureDate) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
            this,
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    calendar.set(year, month, dayOfMonth);
                    String selectedDate = dateFormat.format(calendar.getTime());
                    
                    if (isDepartureDate) {
                        editTextDepartureDate.setText(selectedDate);
                    } else {
                        editTextReturnDate.setText(selectedDate);
                    }
                }
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        );
        
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    private void showPassengerPicker() {
        // Implement passenger picker dialog
        String[] passengerOptions = {"1 người lớn", "2 người lớn", "3 người lớn", "4 người lớn"};
        
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("Chọn số hành khách");
        builder.setItems(passengerOptions, new android.content.DialogInterface.OnClickListener() {
            @Override
            public void onClick(android.content.DialogInterface dialog, int which) {
                editTextPassengers.setText(passengerOptions[which]);
            }
        });
        builder.show();
    }

    private void handleSearchFlights() {
        String departure = editTextDeparture.getText().toString().trim();
        String destination = editTextDestination.getText().toString().trim();
        String departureDate = editTextDepartureDate.getText().toString().trim();
        
        if (validateBookingInput(departure, destination, departureDate)) {
            Toast.makeText(this, getString(R.string.success_booking), Toast.LENGTH_SHORT).show();
            // Implement flight search logic
        }
    }

    private boolean validateBookingInput(String departure, String destination, String departureDate) {
        if (departure.isEmpty()) {
            editTextDeparture.setError(getString(R.string.error_empty_field));
            return false;
        }

        if (destination.isEmpty()) {
            editTextDestination.setError(getString(R.string.error_empty_field));
            return false;
        }

        if (departure.equals(destination)) {
            editTextDestination.setError("Điểm đến phải khác điểm đi");
            return false;
        }

        if (departureDate.isEmpty()) {
            editTextDepartureDate.setError(getString(R.string.error_empty_field));
            return false;
        }

        if (radioRoundTrip.isChecked() && editTextReturnDate.getText().toString().trim().isEmpty()) {
            editTextReturnDate.setError(getString(R.string.error_empty_field));
            return false;
        }

        return true;
    }
}
