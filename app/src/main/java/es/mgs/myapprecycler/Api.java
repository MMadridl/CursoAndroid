package es.mgs.myapprecycler;

import es.mgs.myapprecycler.models.ListAnimals;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by android on 26/03/2018.
 */

public interface Api {
    /**
     * Llamada a Personas  de tipo GET
     *
     */

    //Endpoint ( url del servicio)
    @GET("Listado/")
    Call<ListAnimals> getListAnimals();

}
