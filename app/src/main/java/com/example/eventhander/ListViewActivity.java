package com.example.eventhander;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.eventhander.model.ProgrammingLanguage;
import com.example.eventhander.model.ProgrammingLanguageAdapter;

public class ListViewActivity extends AppCompatActivity {
    private ListView listView;
    private ProgrammingLanguageAdapter programmingLanguageAdapter;
    private ProgrammingLanguage[] programmingLanguages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.listView);
        initData();
        programmingLanguageAdapter = new ProgrammingLanguageAdapter(this, programmingLanguages);
        listView.setAdapter(programmingLanguageAdapter);


//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String item=adapter.getItem(i);
//                Toast.makeText(ListViewActivity.this,item,Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    public void initData() {
        Integer[] imgs = {R.drawable.java, R.drawable.python, R.drawable.js, R.drawable.php, R.drawable.ruby, R.drawable.ts};
        String[] names = {"Java", "Python", "JavaScript", "PHP", "Ruby", "TypeScript"};
        String[] description = {"Java is a class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.",
                "Python is an interpreted, high-level and general-purpose programming language. Python's design philosophy emphasizes code readability with its notable use of significant indentation.",
                "JavaScript is a programming language that conforms to the ECMAScript specification. JavaScript is high-level, often just-in-time compiled, and multi-paradigm.",
                "PHP is a general-purpose scripting language geared towards web development. It was originally created by Danish-Canadian programmer Rasmus Lerdorf in 1994.",
                "Ruby is an interpreted, high-level, general-purpose programming language. It was designed and developed in the mid-1990s by Yukihiro Matz Matsumoto in Japan.",
                "TypeScript is an open-source language which builds on JavaScript, one of the world’s most used tools, by adding static type definitions."};
        programmingLanguages = new ProgrammingLanguage[6];
        for (int i = 0; i < 6; i++) {
            programmingLanguages[i] = new ProgrammingLanguage(names[i], imgs[i], description[i]);
        }
        ;
    }

}