package app.aerocast.bloodbankapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.aerocast.bloodbankapp.R;

public class RegistorActivity extends AppCompatActivity {
   private EditText nameEt, cityEt, phoneEt, bloodgroupEt, passwordEt;
  private Button submit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registor);
        nameEt = findViewById(R.id.name);
        cityEt = findViewById(R.id.city);
        phoneEt = findViewById(R.id.number);
        bloodgroupEt = findViewById(R.id.blood_group);
        passwordEt = findViewById(R.id.password);
        submit_button = findViewById(R.id.submit_button);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,city,blood_group,password,mobile;
                name = nameEt.getText().toString().trim();
                city = cityEt.getText().toString().trim();
                blood_group = bloodgroupEt.getText().toString().trim();
                password = passwordEt.getText().toString().trim();
                mobile = phoneEt.getText().toString().trim();
                showMessage(name+"\n"+city+"\n"+blood_group+"\n"+password+"\n"+mobile);
            }
        });
    }
    private void showMessage(String msg){
        Toast.makeText(this,msg , Toast.LENGTH_SHORT).show();
    }
}