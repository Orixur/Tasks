package com.example.improve.tasks3.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.improve.tasks3.R;
import com.example.improve.tasks3.model.Task;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    private ArrayList<Task> mDataSet;

    // Obtener referencias de los componentes visuales para cada elemento
    // Es decir, referencias de los EditText, TextViews, Buttons
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Todas las referencias de los apartados visuales que quiera actualizar deberan estar en este apartado
        public TextView tvTaskName;
        public TextView tvTaskDescription;

        public ViewHolder(View v) {
            super(v);

            tvTaskName = (TextView) v.findViewById(R.id.tvTaskName);
            tvTaskDescription = (TextView) v.findViewById(R.id.tvTaskDescription);
        }
    }

    // Este es nuestro constructor (puede variar según lo que queremos mostrar)
    public TaskAdapter() {
        mDataSet = new ArrayList<>();
    }

    public void setDataSet(ArrayList<Task> dataSet)
    {
        mDataSet = dataSet;
        notifyDataSetChanged();
    }

    // El layout manager invoca este método
    // para renderizar cada elemento del RecyclerView
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // Creamos una nueva vista
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_card, parent, false);

        // Aquí podemos definir tamaños, márgenes, paddings
        // ...

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Este método reemplaza el contenido de cada view,
    // para cada elemento de la lista (nótese el argumento position)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - obtenemos un elemento del dataset según su posición
        // - reemplazamos el contenido de los views según tales datos

        holder.tvTaskName.setText(mDataSet.get(position).getName());
        holder.tvTaskDescription.setText(mDataSet.get(position).getDetails());
    }

    // Método que define la cantidad de elementos del RecyclerView
    // Puede ser más complejo en RecyclerViews que implementar filtros o búsquedas
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}