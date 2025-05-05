package ru.mirea.krasikovaaa.employeedb;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listViewHeroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewHeroes = findViewById(R.id.listViewHeroes);

        AppDatabase db = App.getInstance().getDatabase();

        // Добавление записей
        if (db.superheroDao().getAll().isEmpty()) {
            db.superheroDao().insert(new Superhero("Iron Man", "Tech Genius", "New York"));
            db.superheroDao().insert(new Superhero("Spider-Man", "Spider Sense", "Queens"));
            db.superheroDao().insert(new Superhero("Doctor Strange", "Magic", "Kamar-Taj"));
        }

        List<Superhero> heroes = db.superheroDao().getAll();
        List<String> heroDescriptions = new ArrayList<>();

        for (Superhero h : heroes) {
            heroDescriptions.add(h.name + " — " + h.superpower + " (" + h.city + ")");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                heroDescriptions
        );
        listViewHeroes.setAdapter(adapter);
    }
}
