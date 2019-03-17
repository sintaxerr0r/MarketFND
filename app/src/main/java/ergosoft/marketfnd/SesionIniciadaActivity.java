package ergosoft.marketfnd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import Clases.Usuario;

public class SesionIniciadaActivity extends AppCompatActivity {
    Usuario objUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion_iniciada);
        objUsuario = getIntent().getExtras().getParcelable("objUsuario");
        Toast.makeText(this, objUsuario.getNombre(), Toast.LENGTH_SHORT).show();
    }
}
