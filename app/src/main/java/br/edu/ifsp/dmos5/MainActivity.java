package br.edu.ifsp.dmos5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ifsp.dmos5.model.User;
import br.edu.ifsp.dmos5.model.exception.UserLoggedException;
import br.edu.ifsp.dmos5.service.UserLoginService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private UserLoginService userLoginService = new UserLoginService();

    private Button button_new_user;
    private Button button_login;
    private EditText edittext_username;
    private EditText edittext_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_login = findViewById(R.id.button_login);
        button_login.setOnClickListener(this);
        button_new_user = findViewById(R.id.button_new_user);
        button_new_user.setOnClickListener(this);
        edittext_username = findViewById(R.id.edittext_username);
        edittext_password = findViewById(R.id.edittext_password);

    }

    @Override
    public void onClick(View view) {
        try {
            if (view == button_login) {
                if (!edittext_username.getText().toString().trim().isEmpty() && !edittext_password.getText().toString().trim().isEmpty()) {
                    User user = new User(edittext_username.getText().toString(), edittext_password.getText().toString());
                    if (userLoginService.loginUser(user)) {
                        Toast.makeText(this, "Usuário logado com sucesso!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this, "Falha ao realizar o login!", Toast.LENGTH_SHORT).show();
                    }
                }
            } else if (view == button_new_user) {
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
            }
        } catch (UserLoggedException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}