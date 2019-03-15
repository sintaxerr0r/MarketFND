package ergosoft.marketfnd;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import Clases.Usuario;

@RequiresApi(api = Build.VERSION_CODES.O)
public class RegistroUsuarioActivity extends AppCompatActivity {

    //variables
    private EditText nombre;
    private EditText apellido;
    private EditText email;
    private EditText telefono;
    private EditText contraseña;
    private EditText contraseñaVal;
    private Button registro;
    private String fecha;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        //xml a java
        nombre = findViewById(R.id.txtnombre);
        apellido = findViewById(R.id.txtapellido);
        email = findViewById(R.id.txtemail);
        telefono = findViewById(R.id.txttelefono);
        SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();
        fecha = datef.format(date);
        contraseña = findViewById(R.id.txtcontraseña);
        contraseñaVal = findViewById(R.id.txtcontraseña_val);

        registro = findViewById(R.id.btnregistro);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    usuario = new Usuario();
                    usuario.setNombre(nombre.getText().toString().trim());
                    usuario.setApellido(apellido.getText().toString().trim());
                    usuario.setEmail(email.getText().toString().trim());
                    usuario.setTelefono(Long.parseLong(telefono.getText().toString().trim()));
                    usuario.setContraseña(contraseña.getText().toString().trim());

                    if(contraseña.getText().toString().trim().equals(contraseñaVal.getText().toString().trim())  && !(contraseña.getText().toString().isEmpty())){
                        ingreso("http://marketfnd.tk/registrousuario.php");
                    }else{
                        Toast.makeText(getApplicationContext(), "Contraseñas ingresadas no coinciden", Toast.LENGTH_SHORT).show();
                    }

                }catch(NumberFormatException a){
                    Toast.makeText(getApplicationContext(), "Tipo de dato incorrecto", Toast.LENGTH_SHORT).show();
                }
                catch (NullPointerException e){
                    Toast.makeText(getApplicationContext(), "Tipo de dato incorrecto", Toast.LENGTH_SHORT).show();
                }


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
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
            }
        } ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> parametros = new HashMap<>();
                parametros.put("nombre", usuario.getNombre());
                parametros.put("apellido", usuario.getApellido());
                parametros.put("email", usuario.getEmail());
                parametros.put("telefono",""+usuario.getTelefono());
                parametros.put("fecha", fecha);
                parametros.put("contraseña", usuario.getContraseña());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
