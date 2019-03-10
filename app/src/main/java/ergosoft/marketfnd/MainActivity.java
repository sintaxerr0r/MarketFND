package ergosoft.marketfnd;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button enlaceregistro;
    private Button inicioSesion;
    private EditText usuario;
    private EditText password;
    private Long id_usuario;
    private String nombre;
    private String apellido;

    private RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = findViewById(R.id.txtusuario);
        password = findViewById(R.id.txtcontraseña);

        inicioSesion = findViewById(R.id.btniniciosesion);
        enlaceregistro = findViewById(R.id.btnenlaceregistro);

        inicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login("http://marketfnd.tk/login.php?user="+usuario.getText().toString().trim()+"&password="+password.getText().toString().trim());
            }
        });

        enlaceregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intregistro = new Intent(getApplicationContext(),RegistroUsuarioActivity.class);
                startActivity(intregistro);
            }
        });

        };

    private void login(String URL){
        String URLT = URL;
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        id_usuario = Long.parseLong(jsonObject.getString("id_usuario"));
                        nombre = jsonObject.getString("nombre");
                        apellido = jsonObject.getString("apellido");

                        //REEMPLAZAR POR UN PROGRESS BAR DE INICIO DE SESION
                        if(id_usuario != 0 ){
                            Toast.makeText(MainActivity.this, "Correcto"+nombre+id_usuario, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),SesionIniciadaActivity.class);
                            intent.putExtra("id",id_usuario);
                            intent.putExtra("nombre",nombre);
                            intent.putExtra("apellido",apellido);
                            startActivity(intent);
                        }

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Datos de inicio incorrectos o no se encuentra registrado", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        }
        );

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);


//        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
//
//            @Override
//            public void onResponse(String response) {
//                Toast.makeText(getApplicationContext(), "OPERACION EXITOSA", Toast.LENGTH_LONG).show();
//            }
//
//        }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
//                }
//            }
//        )
//        {
//             protected Map<String, String> getParams() throws AuthFailureError {
//                 Map<String, String> parametros = new HashMap<>();
//                parametros.put("user",usuario.getText().toString().trim());
//                parametros.put("password",password.getText().toString().trim());
//                return parametros;
//             }
//        };
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(stringRequest);
    }

    }

