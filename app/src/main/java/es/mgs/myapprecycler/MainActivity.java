package es.mgs.myapprecycler;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import es.mgs.myapprecycler.models.Animals;
import es.mgs.myapprecycler.models.ListAnimals;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Animals> animalsList;
    protected RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final  ArrayList<Animals> animalsList;
        //1 Generar dummy de los animales en otro hilo NO LO GESTIONA BIEN HAREMOS ASYNCTASK
      /*  new Thread(new Runnable(){
            @Override
            public void run() {
                animalsList = makeAnimalsList();
            }
        });
        ArrayList<Animals> animalsList */

        //2 Referenciar el recycler view
        /*RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recycler);
        //3 Generar un Adapter
        AnimalsAdapter animalsAdapter = new AnimalsAdapter(animalsList);
        recyclerView.setAdapter(animalsAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(new LinearLayoutManager( this));*/

        // COMENTADO POR QUE DEVOLVEMOS LA LISTA POR RETROFIT
       // AsyncAnimalsList asynAnimalsList= new AsyncAnimalsList();
        //asynAnimalsList.execute();

        // 1 Constr
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://idiariosprocesosapi.worldplex.es:8186")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //2 vinculamos el objeto
        Api apiService= retrofit.create(Api.class);

        //3 Llamamos de forma asincrona a la peticion
        apiService.getListAnimals().enqueue(new Callback<ListAnimals>() {
            @Override
            public void onResponse(Call<ListAnimals> call, Response<ListAnimals> response) {
                Log.e("exito", "conectado"+response.body().getDetail().get(0).getName() );
            }

            @Override
            public void onFailure(Call<ListAnimals> call, Throwable t) {
                Log.e("error", "fallo de conexión" );
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    //LO PASAMOS AL ASYNCTASK
   /* private ArrayList<Animals> makeAnimalsList() {
        ArrayList<Animals> prueba = new ArrayList<Animals>();
        prueba.add(new Animals(R.drawable.img_oca, "Oca","Ocus","Africa"));
        prueba.add(new Animals(R.drawable.img_leon, "León","Felinus Lion","Polonia"));
        prueba.add(new Animals(R.drawable.img_mariposa, "mariposa","Mariposa vita","África"));
        prueba.add(new Animals(R.drawable.img_oso, "oso","Osus","Rusia"));
        prueba.add(new Animals(R.drawable.img_ardilla, "ardilla","Ardilla","Suecia"));
        prueba.add(new Animals(R.drawable.img_lobo, "lobo","lupus","NorteAmerica"));
        return prueba;
    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Creamos una InnerClass que herede de AsyncTask  clase abstracta que nos permite la gestión con el hilo principal
    //ultimo parametro lo que necesito para devolver

  /*  public class AsyncAnimalsList extends AsyncTask<Void,Void,ArrayList<Animals>> {

        @Override
        protected ArrayList<Animals> doInBackground(Void... voids) {
            return makeAnimalsList();
        }

        @Override
        protected void onPostExecute(ArrayList<Animals> animals) {
            super.onPostExecute(animals);
            //2 Referenciar el recycler view
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recycler);
        //3 Generar un Adapter
        AnimalsAdapter animalsAdapter = new AnimalsAdapter(animals);
        recyclerView.setAdapter(animalsAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(new LinearLayoutManager( MainActivity.this));

        }
       /* private ArrayList<Animals> makeAnimalsList() {
            ArrayList<Animals> prueba = new ArrayList<Animals>();
            prueba.add(new Animals(R.drawable.img_oca, "Oca","Ocus","Africa"));
            prueba.add(new Animals(R.drawable.img_leon, "León","Felinus Lion","Polonia"));
            prueba.add(new Animals(R.drawable.img_mariposa, "mariposa","Mariposa vita","África"));
            prueba.add(new Animals(R.drawable.img_oso, "oso","Osus","Rusia"));
            prueba.add(new Animals(R.drawable.img_ardilla, "ardilla","Ardilla","Suecia"));
            prueba.add(new Animals(R.drawable.img_lobo, "lobo","lupus","NorteAmerica"));
            return prueba;
        }
    }*/
}
