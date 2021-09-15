    package com.example.a2ndmissionmad;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

    public class Profile extends AppCompatActivity {
    private TextView tv_Pname, tv_Page, tv_Paddress;
    private ImageButton btn_edit, btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        tv_Pname = findViewById(R.id.tv_Pname);
        tv_Page = findViewById(R.id.tv_Page);
        tv_Paddress = findViewById(R.id.tv_Paddress);
        btn_edit = findViewById(R.id.btn_edit);
        btn_delete = findViewById(R.id.btn_delete);


        Intent intent = getIntent();
        User user = intent.getParcelableExtra("profil");


        tv_Pname.setText(user.getName());
        tv_Page.setText(user.getAge());
        tv_Paddress.setText(user.getAddress());

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                onDeleteClick();
            }
        });
    }

    public void onDeleteClick(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        Integer confirm = 1;
        Integer index = intent.getParcelableExtra("index");
        intent.putExtra("del",confirm);
        intent.putExtra("indexd", index);
        startActivity(intent);

    }
}