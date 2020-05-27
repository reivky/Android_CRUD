package com.reivart.training.activity.ui.training;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.reivart.training.R;
import com.reivart.training.adapter.TrainingAdapter;
import com.reivart.training.model.TrainingModel;

import java.util.ArrayList;
import java.util.List;

public class TrainingFragment extends Fragment {

    private String TAG = "mvvm";
    private RecyclerView rv;
    private TrainingAdapter trainingAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_training, container, false);
        List<TrainingModel> trainingModels = new ArrayList<>();
        rv = root.findViewById(R.id.rv);
        rv.setAdapter(trainingAdapter);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        TrainingViewModel trainingViewModel = ViewModelProviders.of(this).get(TrainingViewModel.class);
        trainingViewModel.getTraining().observe(this, trainingModels1 -> {
            trainingAdapter = new TrainingAdapter(getActivity(), trainingModels1);
            rv.setAdapter(trainingAdapter);
        });
        return root;
    }
}