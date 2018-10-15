package com.example.improve.tasks3.inputOutput;

import com.example.improve.tasks3.model.Task;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TasksApiService
{
    //Nombre de ruta especifica "/"
    @GET("tasks")
    //Metodo que se llama en el momento de una peticion y la respuesta en GSON que obtengamos se va a parsear automaticamente con este metodo
    Call<ArrayList<Task>> getTasks();
    //Call<> ->  Es una peticion asincrona por lo que vamos a requerir un callback cuando el server haya respondido
}
