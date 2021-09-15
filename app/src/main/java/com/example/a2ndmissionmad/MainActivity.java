    package com.example.a2ndmissionmad;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

    public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fab;
    private ArrayList<User> listUser;
    public ListView list_item;
    private Intent intent;
    int launch_second_activity = 1;
//    int launch_delete_activity = 2;
    int conf = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        list_item = (ListView) findViewById(R.id.list_item);

        listUser = new ArrayList<User>();


        UserAdapter userAdapter = new UserAdapter(getApplicationContext(), listUser);
        list_item.setAdapter(userAdapter);

//        listUser.add(new User("Nama", "26", "Kuning"));



//        if(listUser != null){
//            intent = getIntent();
//            User user = intent.getParcelableExtra("IDuser");
//            listUser.add(user);
//        }

        this.fab = (FloatingActionButton)findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                onAddClicked();
            }
        });

        this.list_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User user = listUser.get(position);
                Intent intent = new Intent(getApplicationContext(), Profile.class);
                Integer index = position;
                String name = user.getName();
                String age = user.getAge();
                String address = user.getAddress();

                User users = new User(name, age, address);
                intent.putExtra("index",index);
                intent.putExtra("profil", users);
                startActivity(intent);

            }
        });




    }

    public void Delete(){
        Intent intent = new Intent();
        Integer indexd = intent.getParcelableExtra("indexd");
        listUser.remove(indexd);
        indexd = -1;
        conf = 0;
    }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            ArrayAdapter<User> adapter = (ArrayAdapter<User>) list_item.getAdapter();

            if(requestCode == launch_second_activity){
                if(resultCode == Activity.RESULT_OK){
//                    UserAdapter userAdapter = new UserAdapter(getApplicationContext(), listUser);

                    intent = getIntent();
                    User user = data.getParcelableExtra("IDuser");
//                    String name = intent.getStringExtra("IDname");
//                    String age = intent.getStringExtra("IDage");
//                    String address = intent.getStringExtra("IDaddress");
                    listUser.add(user);
//                    userAdapter.notifyDataSetChanged();

                    Log.d("mytag",listUser.toString());
                }
            }
            if(getIntent().getParcelableExtra("del") != null) {
                Integer conf = intent.getParcelableExtra("del");
                if(conf == 1){
                    Delete();
                }
            }

            adapter.notifyDataSetChanged();
        }

        @Override
        protected void onResume() {
            super.onResume();
            UserAdapter adapter = new UserAdapter(this, listUser);
            adapter.notifyDataSetChanged();
    }

    public void onAddClicked() {
//        int launch_second_activity = 1;
        Intent intent = new Intent(this, Add.class);
        startActivityForResult(intent,launch_second_activity);
//        Toast.makeText(getApplicationContext(), "MASUK1", Toast.LENGTH_SHORT).show();
//        startActivity(intent);
    }

    private class UserAdapter extends ArrayAdapter<User> {


        public UserAdapter(Context context, List<User> objects) {
            super(context, 0, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item_user, parent, false);
            }

            TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            TextView tv_age = (TextView) convertView.findViewById(R.id.tv_age);
            TextView tv_address = (TextView) convertView.findViewById(R.id.tv_address);

            final User user = listUser.get(position);
            
            tv_name.setText(user.getName());
            tv_age.setText(user.getAge() + " years old");
            tv_address.setText(user.getAddress());
            Toast.makeText(getApplicationContext(), "coba", Toast.LENGTH_SHORT).show();

            return convertView;
        }
    }
}