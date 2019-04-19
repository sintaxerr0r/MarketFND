package ergosoft.marketfnd;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import Clases.Usuario;

public class SesionIniciadaActivity extends AppCompatActivity {
    Usuario objUsuario;
    private String[] mPlanetTitles = {"Tierra","Marte","Sol"};
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion_iniciada);
        objUsuario = getIntent().getExtras().getParcelable("objUsuario");
        Toast.makeText(this, objUsuario.getNombre(), Toast.LENGTH_SHORT).show();


        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerList = findViewById(R.id.left_drawer);

        //Set adapter
//        mDrawerList.setAdapter(new ArrayAdapter<String>
//                (this,R.layout.drawer_list_item,mPlanetTitles));
        //Set Click Listener

        // Click listener para el menu de navegacion
        // mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
    }
}
