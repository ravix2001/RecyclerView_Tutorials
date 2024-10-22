package com.example.recyclerview_tutorials;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ContactModel> arrContacts = new ArrayList<>();
    RecyclerContactAdapter adapter;
    FloatingActionButton openDialogBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        openDialogBtn = findViewById(R.id.openDialogBtn);

        openDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_layout);

                EditText edtName = dialog.findViewById(R.id.edtName);
                EditText edtNumber = dialog.findViewById(R.id.edtNumber);
                Button actionBtn = dialog.findViewById(R.id.actionBtn);

                actionBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name , number = "";

                        name = edtName.getText().toString();

                        if(!edtNumber.getText().toString().equals("")) {
                            number = edtNumber.getText().toString();
                            arrContacts.add(new ContactModel(R.drawable.baseline_account_box_24,name,number));
                            adapter.notifyItemInserted(arrContacts.size()-1);
                            dialog.dismiss();
                            recyclerView.scrollToPosition(arrContacts.size()-1);
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Please Enter Number", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                dialog.show();
            }
        });

        recyclerView = findViewById(R.id.recyclerContact);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        /*ContactModel model = new ContactModel(R.drawable.ic_launcher_foreground, "A", "9876543210");
        arrContacts.add(model);*/
        arrContacts.add(new ContactModel(R.drawable.baseline_account_box_24, "A", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.baseline_account_box_24, "B", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.baseline_account_box_24, "C", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.baseline_account_box_24, "D", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.baseline_account_box_24, "E", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.baseline_account_box_24, "F", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.baseline_account_box_24, "G", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.baseline_account_box_24, "H", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.baseline_account_box_24, "I", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.baseline_account_box_24, "J", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.baseline_account_box_24, "K", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.baseline_account_box_24, "L", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.baseline_account_box_24, "M", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.baseline_account_box_24, "N", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.baseline_account_box_24, "O", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.baseline_account_box_24, "P", "9876543210"));

        adapter = new RecyclerContactAdapter(this, arrContacts);
        recyclerView.setAdapter(adapter);

    }
}