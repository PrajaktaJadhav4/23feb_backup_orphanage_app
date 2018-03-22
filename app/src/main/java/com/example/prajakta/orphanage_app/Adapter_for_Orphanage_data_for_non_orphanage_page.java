package com.example.prajakta.orphanage_app;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import com.example.prajakta.orphanage_app.R;

/**
 * Created by PRAJAKTA on 10-03-2018.
 */

public class Adapter_for_Orphanage_data_for_non_orphanage_page extends RecyclerView.Adapter<Adapter_for_Orphanage_data_for_non_orphanage_page.ViewHolder> implements Filterable
{
    @NonNull
    private ArrayList<orphanage_data_for_non_orphanages> listitems;

    private ArrayList<orphanage_data_for_non_orphanages> array_list;
    private Context context;

    public Adapter_for_Orphanage_data_for_non_orphanage_page(@NonNull ArrayList<orphanage_data_for_non_orphanages> list_items, non_orphanage_page context) {
        this.listitems = list_items;

        this.array_list = list_items;
        this.context = context;
    }


    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //LayoutInflater is used to manipulate Android screen using predefined XML layouts.
        //This class is used to instantiate layout XML file into its corresponding View objects.

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.orphanage_data_card_view,null);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final orphanage_data_for_non_orphanages listitem = listitems.get(position);
        holder.textView_o_name.setText(listitem.get_o_name());
        holder.textView_o_adrress.setText(listitem.get_o_address());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.prajakta.orphanage_app.orphanage_main_page");
                intent.putExtra("o_name",listitem.get_o_name());
                context.startActivity(intent);
            }
        });

    }




    @Override
    public int getItemCount() {
        return listitems.size();
    }



    @Override
    public Filter getFilter(){
            return new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    String charString = constraint.toString();

                    if(charString.isEmpty()){
                        listitems = array_list;
                    }
                    else {
                        ArrayList<orphanage_data_for_non_orphanages> filteredlist = new ArrayList<>();

                        for (orphanage_data_for_non_orphanages orphanage_data : array_list){
                            if (orphanage_data.get_o_name().toLowerCase().contains(charString)|| orphanage_data.get_o_address().toLowerCase().contains(charString))
                            {
                                filteredlist.add(orphanage_data);
                            }
                        }
                        listitems = filteredlist;
                    }
                    FilterResults filterResults = new FilterResults();
                    filterResults.values = listitems;
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults filterResults) {


                    listitems = (ArrayList<orphanage_data_for_non_orphanages>)filterResults.values;

                    notifyDataSetChanged();
                }
            };
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textView_o_name;
        public TextView textView_o_adrress;
        public LinearLayout linearLayout;


        public ViewHolder(View itemView) {
            super(itemView);

            textView_o_name = (TextView) itemView.findViewById(R.id.textViewName);
            textView_o_adrress = (TextView) itemView.findViewById(R.id.textViewAddress);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearlayoutcv);
        }
    }

}
