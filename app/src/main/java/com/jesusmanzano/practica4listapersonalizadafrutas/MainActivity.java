package com.jesusmanzano.practica4listapersonalizadafrutas;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ImageView imageView;
    private TextView descripcionesTextView; // Agrega esta línea

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.List);
        imageView = findViewById(R.id.image);
        descripcionesTextView = findViewById(R.id.Descripcion); // Asigna el TextView desde tu diseño XML

        String[] nombres = {"Natsumi", "Origami", "Yoshino", "Tohka", "Kurumi"};
        String[] precios = {"$4,019.00", "$10,190.00", "$1,582.53", "2,983.03", "2,500.00"};
        Integer[] idimage = {R.drawable.natsumi, R.drawable.origami, R.drawable.yoshino, R.drawable.tohka, R.drawable.kurumi};
        String[] descripciones = {
                "Figura de Natsumi Kyono",
                "Figura de Origami Tobichi",
                "Figura de Yoshino",
                "Figura de Tokhka Yathogami",
                "Figura de Kurumi Tokisaki"

        };
        final String[] descripciones2 = {
                "Descripcion\n" +
                        "Origen：Date A Live: Seirei Sairin\n" +
                        "Personaje：Kyouno Natsumi\n" +
                        "Empresa：Apex Innovation como fabricante\n" +
                        "Versión: Xinchun Qipao Ver.\n" +
                        "Lanzamientos: 12/2022\n" +
                        "Materiales: ABS, PVC.\n" +
                        "Dimensiones: 1/7 L = 290 mm (11,31 pulg.) H = 160 mm (6,24 pulg., 1:1 = 1,12 m)",

                "Descripción\n" +
                        "Origen：Date A Live II\n" +
                        "Personaje: Tobichi Origami\n" +
                        "Empresa：Pulchra como fabricante\n" +
                        "Artista：Moineau como escultor\n" +
                        "Versión: versión invertida.\n" +
                        "Lanzamientos：30/03/2019\n" +
                        "Materiales: ABS, PVC.\n" +
                        "Dimensiones: 1/7 H = 250 mm (9,75 pulgadas, 1: 1 = 1,75 m)",

                "Descripción\n" +
                        "Origen：Date A Live II\n" +
                        "Personaje: Himekawa Yoshino\n" +
                        "Empresa：Pulchra como fabricante\n" +
                        "Artista：Moineau como escultor\n" +
                        "Versión: versión Astral.\n" +
                        "Lanzamientos：20/02/2019\n" +
                        "Materiales: ABS, PVC.\n" +
                        "Dimensiones: 1/7 H = 250 mm (9,75 pulgadas, 1: 1 = 1,75 m)",

                "Descripción\n" +
                        "Origen：Date A Live II\n" +
                        "Personaje: Yatogami Tohka\n" +
                        "Empresa：Pulchra como fabricante\n" +
                        "Artista：Moineau como escultor\n" +
                        "Versión: versión invertida.\n" +
                        "Lanzamientos：30/01/2019\n" +
                        "Materiales: ABS, PVC.\n" +
                        "Dimensiones: 1/7 H = 250 mm (9,75 pulgadas, 1: 1 = 1,75 m)",

                "Descripcion\n" +
                        "Clasificación: Figura Shibuya Scramble\n" +
                        "Origen: Cita con una bala\n" +
                        "Personaje: Tokisaki Kurumi.\n" +
                        "Empresas: Alpha Satellite como fabricante\n" +
                        "Artistas: Diseño Coco como escultor.\n" +
                        "Versión: vestido de rubí con sangre de paloma Ver.\n" +
                        "Lanzamientos: 07/2023\n" +
                        "Materiales: ABS, PVC\n" +
                        "Dimensiones: 1/7 A = 291 mm (11,35 pulg.) L = 215 mm (8,39 pulg.) A = 331 mm (12,91 pulg., 1:1 = 2,32 m)"


        };

        AdapterList adapter = new AdapterList(this, nombres, precios, idimage, descripciones);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Obtén la imagen correspondiente al elemento seleccionado
                int imagenResId = idimage[position];

                imageView.setImageResource(imagenResId);
                descripcionesTextView.setText(descripciones2[position]); // Muestra la descripción

                // Muestra un mensaje de confirmación
                Toast.makeText(getApplicationContext(), "Seleccionaste el elemento: " + nombres[position], Toast.LENGTH_LONG).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Seleccionaste: " + nombres[position] + " con precio de $" + precios[position], Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }
}
