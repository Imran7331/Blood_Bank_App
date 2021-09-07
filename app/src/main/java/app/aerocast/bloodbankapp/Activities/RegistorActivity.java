package app.aerocast.bloodbankapp.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.aerocast.bloodbankapp.R;
import app.aerocast.bloodbankapp.Utils.VolleySingleton;

public class RegistorActivity extends AppCompatActivity {
   private EditText nameEt, cityEt, phoneEt, bloodgroupEt, passwordEt;
  private Button submit_button;
  String abc;

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
                if (isValid(name, city, mobile, blood_group, password)){

                }
            }
        });
    }

    public void registor(String name, String city, String boold_group, String password, String mobile ){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> prams = new HashMap<>();
                return prams;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    private boolean isValid(String name, String city, String blood_group, String password, String mobile){
        List<String> valid_blood_groups = new ArrayList<>();
        valid_blood_groups.add("A+");
        valid_blood_groups.add("A-");
        valid_blood_groups.add("B+");
        valid_blood_groups.add("B-");
        valid_blood_groups.add("AB+");
        valid_blood_groups.add("AB-");
        valid_blood_groups.add("O+");
        valid_blood_groups.add("O-");
        if (name.isEmpty()){
            showMessage("Name is Empty");
            return false;
        }
        else if (city.isEmpty()){
            showMessage("City is Empty");
            return false;
        }
        else if (!valid_blood_groups.contains(blood_group)){
            showMessage("Blood Group invalid! Choose from"+valid_blood_groups);
            return false;
        }
        if (password.isEmpty()){
            showMessage("Password is Empty");
            return false;
        }
        if (mobile.length() != 10){
            showMessage("Invalid Mobile Number! Number Should be of 10 Digits");
            return false;
        }
        return true;
    }
    private void showMessage(String msg){
        Toast.makeText(this,msg , Toast.LENGTH_SHORT).show();
    }
}