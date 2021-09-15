package com.example.a2ndmissionmad;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add extends AppCompatActivity {

    private EditText et_name, et_age, et_address;
    private Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        et_name = findViewById(R.id.editTextName);
        et_age = findViewById(R.id.editTextAge);
        et_address = findViewById(R.id.editTextAddress);
        btn_save = findViewById(R.id.buttonSave);

        btn_save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name = et_name.getEditableText().toString().trim();
                String age = et_age.getEditableText().toString().trim();
                String address = et_address.getEditableText().toString().trim();

                if (name.isEmpty()){
                    et_name.setError("Please fill the name column");
                }

                if (age.isEmpty()){
                    et_age.setError("Please fill the age column");
                }

                if (address.isEmpty()){
                    et_address.setError("Please fill the password column");
                }

                if (!name.isEmpty() && !age.isEmpty() && !address.isEmpty()){
//                 Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    Intent intent = new Intent();
//                    intent.putExtra("IDname", name);
//                    intent.putExtra("IDage", age);
//                    intent.putExtra("IDaddress", address);

//                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    User user = new User(name, age, address);
                    intent.putExtra("IDuser", user);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                    setResult(2,intent);
                    setResult(Activity.RESULT_OK, intent);
//                    startActivity(intent);
                    finish();
            }
        };

    });
}
}