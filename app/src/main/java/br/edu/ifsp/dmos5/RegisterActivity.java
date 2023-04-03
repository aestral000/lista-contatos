package br.edu.ifsp.dmos5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ifsp.dmos5.model.User;
import br.edu.ifsp.dmos5.service.UserLoginService;
import br.edu.ifsp.dmos5.service.UserService;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private UserService userService = new UserService();
    private UserLoginService userLoginService = new UserLoginService();

    private Button button_save;
    private EditText edittext_username;
    private EditText edittext_password;
    private EditText edittext_confirm_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        button_save = findViewById(R.id.button_save);
        button_save.setOnClickListener(this);
        edittext_username = findViewById(R.id.edittext_username);
        edittext_password = findViewById(R.id.edittext_password);
        edittext_confirm_password = findViewById(R.id.edittext_confirm_password);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onClick(View view) {


        if(view == button_save){
            if(!edittext_username.getText().toString().trim().isEmpty() && !edittext_password.getText().toString().trim().isEmpty() && !edittext_confirm_password.getText().toString().trim().isEmpty()){

               if(edittext_password.getText().toString().equals(edittext_confirm_password.getText().toString())) {
                    userLoginService.addUser(new User(edittext_username.getText().toString(), edittext_password.getText().toString()));
               }else{
                   Toast.makeText(this, "As senhas não são identicas!", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}