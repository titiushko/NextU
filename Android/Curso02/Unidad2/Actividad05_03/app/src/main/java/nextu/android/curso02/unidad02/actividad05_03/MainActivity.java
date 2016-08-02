package nextu.android.curso02.unidad02.actividad05_03;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Crear el adaptador que devolverá un fragmento para cada una de las secciones principales de la actividad.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Configurar el ViewPager con el adaptador secciones.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
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

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem está llamado a crear una instancia del fragmento de la página en cuestión.
            // Devolución de un PlaceholderFragment (definida como una clase interna estática a continuación).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0: return getString(R.string.title_section1).toUpperCase(l);
                case 1: return getString(R.string.title_section2).toUpperCase(l);
                case 2: return getString(R.string.title_section3).toUpperCase(l);
                case 3: return getString(R.string.title_section4).toUpperCase(l);
                case 4: return getString(R.string.title_section5).toUpperCase(l);
            }
            return null;
        }
    }

    // Un fragmento de marcador de posición que contiene una vista simple.
    public static class PlaceholderFragment extends Fragment {
        // El argumento fragmento que representa el número de sección de este fragmento.
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() { }

        // Devuelve una nueva instancia de este fragmento para el número de la sección determinada.
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
            TextView textView = (TextView) rootView.findViewById(R.id.section_main);
            textView.setText("Contenido de la sección: " + Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }
}
