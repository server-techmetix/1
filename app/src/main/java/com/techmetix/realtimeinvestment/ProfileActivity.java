package com.techmetix.realtimeinvestment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {
    TextInputLayout profile_name,profile_email,profile_phoneNo,profile_state,profile_city,profile_pin;
    Button Continue_btn;
    boolean validate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile_name=findViewById(R.id.profile_name);
        profile_email=findViewById(R.id.profile_email);
        profile_phoneNo=findViewById(R.id.profile_phoneNo);
        profile_state=findViewById(R.id.profile_state);
        profile_city=findViewById(R.id.profile_city);
        profile_pin=findViewById(R.id.profile_pin);
        Continue_btn=findViewById(R.id.continue_btn);

        Continue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = profile_name.getEditText().getText().toString();
                String email = profile_email.getEditText().getText().toString();
                String phoneNo = profile_phoneNo.getEditText().getText().toString();
                String state = profile_state.getEditText().getText().toString();
                String city = profile_city.getEditText().getText().toString();
                String pin = profile_pin.getEditText().getText().toString();

                if (registerUser(validate)){
                    Toast.makeText(ProfileActivity.this, "Please enter valid data",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ProfileActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    private boolean validateName() {
        String val = profile_name.getEditText().getText().toString();

        if (val.isEmpty()) {
            profile_name.setError("Name cannot be empty");
            return false;
        } else {
            profile_name.setError(null);
            profile_name.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateEmail() {
        String val = profile_email.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            profile_email.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            profile_email.setError("Invalid email address");
            return false;
        } else {
            profile_email.setError(null);
            profile_email.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePhoneNo() {
        String val = profile_phoneNo.getEditText().getText().toString();

        if (val.isEmpty()) {
            profile_phoneNo.setError("PhoneNo cannot be empty");
            return false;
        }else if (val.length() >= 10) {
            profile_phoneNo.setError("PhoneNo too long");
            return false;
        }
        else {
            profile_phoneNo.setError(null);
            profile_phoneNo.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateState() {
        String val = profile_state.getEditText().getText().toString();

        if (val.isEmpty()) {
            profile_state.setError("State cannot be empty");
            return false;
        } else {
            profile_state.setError(null);
            profile_state.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateCity() {
        String val = profile_city.getEditText().getText().toString();

        if (val.isEmpty()) {
            profile_city.setError("Field cannot be empty");
            return false;
        } else {
            profile_city.setError(null);
            profile_city.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePin() {
        String val = profile_pin.getEditText().getText().toString();

        if (val.isEmpty()) {
            profile_pin.setError("PhoneNo cannot be empty");
            return false;
        }else if (val.length() >= 6) {
            profile_phoneNo.setError("PhoneNo too long");
            return false;
        }
        else {
            profile_pin.setError(null);
            profile_pin.setErrorEnabled(false);
            return true;
        }
    }

    public boolean registerUser(boolean view) {

        if (!validateName()  |  !validateEmail()  |  !validatePhoneNo()  |  !validateState()  |  !validateCity()  |  !validatePin()) {
            return true;
        } else {
            return false;
        }

    }
}