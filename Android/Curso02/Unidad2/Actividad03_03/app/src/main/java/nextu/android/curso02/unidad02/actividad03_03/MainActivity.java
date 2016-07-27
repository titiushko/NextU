package nextu.android.curso02.unidad02.actividad03_03;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ActionBar.OnNavigationListener {
    private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configurar la barra de acción para mostrar una lista desplegable.
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        // Configurar la lista desplegable de navegación en la barra de acción.
        actionBar.setListNavigationCallbacks(
                // Especificar un SpinnerAdapter para rellenar la lista desplegable.
                new ArrayAdapter<String>(
                        actionBar.getThemedContext(),
                        android.R.layout.simple_list_item_1,
                        android.R.id.text1, new String[]{
                        getString(R.string.seccion1),
                        getString(R.string.seccion2),
                        getString(R.string.seccion3),
                        getString(R.string.seccion4),
                        getString(R.string.seccion5)
                }
                ),
                this
        );
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restaurar la posición actual desplegable previamente por entregas.
        if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
            getSupportActionBar().setSelectedNavigationItem(savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Serializar la posición actual desplegable.
        outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getSupportActionBar().getSelectedNavigationIndex());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflar el menú; esto agrega elementos a la barra de acción si está presente.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Manija elemento de la barra de acción hace clic aquí.
        // La barra de acción manejará automáticamente hace clic en el botón Inicio/Arriba,
        // siempre y cuando se especifica una actividad principal en AndroidManifest.xml.
        int id = item.getItemId();

        // noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(int position, long id) {
        // Cuando se selecciona el elemento desplegable dado, mostrar su contenido en la vista de contenedor.
        getSupportFragmentManager().beginTransaction().replace(R.id.container, PlaceholderFragment.newInstance(position + 1)).commit();
        return true;
    }

    /**
     * Un fragmento de marcador de posición que contiene una vista simple.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * El argumento fragmento que representa el número de sección de este fragmento.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Devuelve una nueva instancia de este fragmento para el número de la sección determinada.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText("Contenido de la sección: " + Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }
}
