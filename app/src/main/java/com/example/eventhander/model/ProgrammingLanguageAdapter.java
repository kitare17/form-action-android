package com.example.eventhander.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.eventhander.R;

public class ProgrammingLanguageAdapter extends ArrayAdapter<ProgrammingLanguage> {
    private Context context;
    private ProgrammingLanguage[] programmingLanguages;

    public ProgrammingLanguageAdapter(@NonNull Context context, ProgrammingLanguage[] programmingLanguages) {
        super(context, R.layout.item2, programmingLanguages);
        this.programmingLanguages = programmingLanguages;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item2, null, true);
        ImageView img = view.findViewById(R.id.image_programming_language);
        TextView name = view.findViewById(R.id.language_name);
        TextView description = view.findViewById(R.id.language_description);
        ProgrammingLanguage programmingLanguage = programmingLanguages[position];
        img.setImageResource(programmingLanguage.getImg());
        name.setText(programmingLanguage.getName());
        description.setText(programmingLanguage.getDescription());
        return view;
    }

//    public ProgrammingLanguage getItem(int position) {
//    return programmingLanguages[position];
//    }
}
