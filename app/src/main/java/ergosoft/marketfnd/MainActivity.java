package ergosoft.marketfnd;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button enlaceregistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enlaceregistro = findViewById(R.id.btnenlaceregistro);

        enlaceregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intregistro = new Intent(getApplicationContext(),RegistroUsuarioActivity.class);
                startActivity(intregistro);
            }
        });

        };



    }

