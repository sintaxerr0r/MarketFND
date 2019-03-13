/**
 * @authors Bastián Vidal & Leandro Valenzuela
 * @version 10-03-2019
 */

package ergosoft.marketfnd;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 *  Modulo encargado de despliegue de la pantalla de inicio de sesión, con opciones de registro
 */
public class MainActivity extends AppCompatActivity {
    /* Declaración de variables privadas de la clase */
    private Button enlaceregistro;
    private Button inicioSesion;
    private EditText usuario;
    private EditText password;
    private Long id_usuario;
    private String nombre;
    private String apellido;
    private boolean valido;
    private RequestQueue requestQueue;


    /**
     * Metodo por defecto onCreate
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* Instanciación de clases de XML a objetos JAVA*/
        usuario = findViewById(R.id.txtusuario);
        password = findViewById(R.id.txtcontraseña);

        inicioSesion = findViewById(R.id.btniniciosesion);
        enlaceregistro = findViewById(R.id.btnenlaceregistro);


        /**
         *  Método de escucha del botón de inicio de sesión
         */
        inicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarUsuario("http://marketfnd.tk/comprobarRegistro.php?user="+usuario.getText().toString().trim());

                if(valido){
                    login("http://marketfnd.tk/login.php?user="+usuario.getText().toString().trim()+"&password="+password.getText().toString().trim());
                }else{
                    Toast.makeText(getApplicationContext(), "El usuario ingresado no se encuentra registrado", Toast.LENGTH_SHORT).show();
                }
            }
        });


        /**
         *  Método de escucha del enlace al activity de registro de usuario
         */
        enlaceregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intregistro = new Intent(getApplicationContext(),RegistroUsuarioActivity.class);
                startActivity(intregistro);
            }
        });

        };

    /**
     * Método encargado de verificar si la cuenta de usuario ingresada se encuentra registrada
     * @param URL Url al archivo php del servidor web que realiza de intermediador con la base de datos
     */
    private void comprobarUsuario(String URL){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        id_usuario = Long.parseLong(jsonObject.getString("id_usuario"));

                        if (id_usuario == 0) {
                            valido = false;
                        } else {
                            valido = true;
                        }
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), "Ha ocurrido un error de JSON, Contacte al administador", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(getApplicationContext(), "Usuario ingresado no se encuentra registrado", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        }
        );
    }

    /**
     * Método encargado de validación de datos de inicio de sesión mediante el uso de la plataforma web
     * @param URL Url al archivo php del servidor web que realiza de intermediador con la base de datos
     */
    private void login(String URL){

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

                        //REEMPLAZAR POR UN PROGRESS BAR DE INICIO DE SESION****************************
                        if(id_usuario != 0 ){
                            Toast.makeText(MainActivity.this, "Correcto"+nombre+id_usuario, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),SesionIniciadaActivity.class);
                            intent.putExtra("id",id_usuario);
                            intent.putExtra("nombre",nombre);
                            intent.putExtra("apellido",apellido);
                            startActivity(intent);
                        }//Fin IF

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }//Fin Try-Catch
                }//Fin For
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Datos de inicio incorrectos", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        }
        );

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);

    }//Fin login()


}//Fin Clase

