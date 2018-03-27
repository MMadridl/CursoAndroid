package es.mgs.myapprecycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import es.mgs.myapprecycler.models.Animals;

/**
 * Created by android on 15/03/2018.
 */

public class AnimalsAdapter  extends RecyclerView.Adapter<AnimalsAdapter.ViewHolder>{
    private final ArrayList<Animals> items;

    public AnimalsAdapter(ArrayList<Animals> animalsList) {
        this.items= animalsList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_animals,null);
    return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.img.setImageResource(items.get(position).getImg());
        holder.textName.setText(items.get(position).getCientificname());
        holder.nombre.setText(items.get(position).getName());
        holder.textPosition.setText(items.get(position).getUbicacion());

    }

    @Override
    public int getItemCount() {

        return items!=null? items.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final Button btnMasInfo;
        private final TextView textPosition;
        private final TextView textName;
        private final TextView nombre;
        private final ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            img= (ImageView) itemView.findViewById(R.id.item_layout_img);
            nombre= (TextView) itemView.findViewById(R.id.item_layout_name);
            textName=(TextView) itemView.findViewById(R.id.item_layout_textname);
            textPosition=(TextView) itemView.findViewById(R.id.item_layout_position_name);
            btnMasInfo=(Button) itemView.findViewById(R.id.item_layout_button_text);
        }
    }
}
