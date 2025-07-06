package com.travelapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private ImageButton btnBackLogin;
    private EditText editTextEmailPhone;
    private EditText editTextPasswordLogin;
    private ImageButton btnTogglePasswordLogin;
    private TextView textForgotPassword;
    private CheckBox checkBoxRemember;
    private Button btnLogin;
    private ImageButton btnGoogleLoginLogin;
    private ImageButton btnFacebookLoginLogin;
    private TextView textRegisterLink;
    
    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
        setupClickListeners();
    }

    private void initViews() {
        btnBackLogin = findViewById(R.id.btnBackLogin);
        editTextEmailPhone = findViewById(R.id.editTextEmailPhone);
        editTextPasswordLogin = findViewById(R.id.editTextPasswordLogin);
        btnTogglePasswordLogin = findViewById(R.id.btnTogglePasswordLogin);
        textForgotPassword = findViewById(R.id.textForgotPassword);
        checkBoxRemember = findViewById(R.id.checkBoxRemember);
        btnLogin = findViewById(R.id.btnLogin);
        btnGoogleLoginLogin = findViewById(R.id.btnGoogleLoginLogin);
        btnFacebookLoginLogin = findViewById(R.id.btnFacebookLoginLogin);
        textRegisterLink = findViewById(R.id.textRegisterLink);
    }

    private void setupClickListeners() {
        btnBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnTogglePasswordLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePasswordVisibility();
            }
        });

        textForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleForgotPassword();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });

        btnGoogleLoginLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleGoogleLogin();
            }
        });

        btnFacebookLoginLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleFacebookLogin();
            }
        });

        textRegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void togglePasswordVisibility() {
        if (isPasswordVisible) {
            editTextPasswordLogin.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            btnTogglePasswordLogin.setImageResource(R.drawable.ic_eye_off);
        } else {
            editTextPasswordLogin.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            btnTogglePasswordLogin.setImageResource(R.drawable.ic_eye_off);
        }
        editTextPasswordLogin.setSelection(editTextPasswordLogin.getText().length());
        isPasswordVisible = !isPasswordVisible;
    }

    private void handleForgotPassword() {
        Toast.makeText(this, "Chức năng quên mật khẩu", Toast.LENGTH_SHORT).show();
        // Implement forgot password logic
    }

    private void handleLogin() {
        String emailPhone = editTextEmailPhone.getText().toString().trim();
        String password = editTextPasswordLogin.getText().toString();

        if (validateInput(emailPhone, password)) {
            // Thực hiện đăng nhập
            Toast.makeText(this, getString(R.string.success_login), Toast.LENGTH_SHORT).show();
            
            // Chuyển đến màn hình booking
            Intent intent = new Intent(LoginActivity.this, BookingActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private boolean validateInput(String emailPhone, String password) {
        if (emailPhone.isEmpty()) {
            editTextEmailPhone.setError(getString(R.string.error_empty_field));
            return false;
        }

        if (password.isEmpty()) {
            editTextPasswordLogin.setError(getString(R.string.error_empty_field));
            return false;
        }

        // Validate email or phone format
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailPhone).matches() && 
            !android.util.Patterns.PHONE.matcher(emailPhone).matches()) {
            editTextEmailPhone.setError("Email hoặc số điện thoại không hợp lệ");
            return false;
        }

        return true;
    }

    private void handleGoogleLogin() {
        Toast.makeText(this, "Đăng nhập Google", Toast.LENGTH_SHORT).show();
        // Implement Google login logic
    }

    private void handleFacebookLogin() {
        Toast.makeText(this, "Đăng nhập Facebook", Toast.LENGTH_SHORT).show();
        // Implement Facebook login logic
    }
}
