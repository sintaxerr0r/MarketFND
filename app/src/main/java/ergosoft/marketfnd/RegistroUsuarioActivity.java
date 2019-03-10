package ergosoft.marketfnd;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class RegistroUsuarioActivity extends AppCompatActivity {

    //variables
    private EditText nombre;
    private EditText apellido;
    private EditText email;
    private EditText telefono;
    private Button registro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        //xml a java
        nombre = findViewById(R.id.txtnombre);
        apellido = findViewById(R.id.txtapellido);
        email = findViewById(R.id.txtemail);
        telefono = findViewById(R.id.txttelefono);
        registro = findViewById(R.id.btnregistro);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingreso("https://auth-db185.hostinger.com/registrousuario.php");
            }
        });
    }

    private void ingreso(String URL) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "OPERACION EXITOSA", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> parametros = new HashMap<>();
                parametros.put("nombre", nombre.getText().toString());
                parametros.put("apellido", apellido.getText().toString());
                parametros.put("email", email.getText().toString());
                parametros.put("telefono", telefono.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
