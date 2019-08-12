package com.example.livedateprac;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GobolClickListener {

    private GobolViewModel mGobolViewModel;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GobolAdapter adapter = new GobolAdapter(this, this);

        setupViewModal(getInitialGobolada(), adapter);
        setupRecyclerView(adapter);


        FloatingActionButton fab = findViewById(R.id.add_gobol_btn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGobolViewModel.InsertGobol(new Gobol(4, "Shabeela Hoose", new Date()));
                mGobolViewModel.InsertGobol(new Gobol(1, "Nugaal", new Date()));
            }
        });
    }

    private List<Gobol> getInitialGobolada() {
        List<Gobol> gobols;
        gobols = new ArrayList<>();
        gobols.add(new Gobol(1, "Benadir", new Date()));
        gobols.add(new Gobol(1, "Bari", new Date()));
        gobols.add(new Gobol(1, "Mudug", new Date()));
        gobols.add(new Gobol(1, "Gedo", new Date()));
        return gobols;
    }

    private void setupViewModal(List<Gobol> gobols, GobolAdapter adapter) {
        final GobolAdapter  gobolAdapter  = adapter;
        mGobolViewModel = ViewModelProviders.of(this).get(GobolViewModel.class);
        mGobolViewModel.setGobols(gobols);
        mGobolViewModel.getGobolada().removeObservers(this);
        mGobolViewModel.getGobolada().observe(this, new Observer<List<Gobol>>() {
            @Override
            public void onChanged(List<Gobol> gobols) {
                gobolAdapter.setGobolo(gobols);
            }
        });
    }

    private void setupRecyclerView(GobolAdapter adapter) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        Swiper swiper = new Swiper();
        ItemTouchHelper touchHelper = new ItemTouchHelper(swiper);
        recyclerView = findViewById(R.id.gobolada_rv);
        touchHelper.attachToRecyclerView(recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnClick(String gobolName) {
        Toast.makeText(getApplicationContext(), "Clicked On " + gobolName, Toast.LENGTH_LONG).show();
    }
}
