package com.crimeconnections.crime.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crimeconnections.crime.CrimePojos.Attributes;
import com.crimeconnections.crimeconnections.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CrimeDetailAdapter extends RecyclerView.Adapter<CrimeDetailAdapter.ViewHolder> {
    ArrayList<Attributes> attributesArrayList;
    Context context;

    public CrimeDetailAdapter(ArrayList<Attributes> attributesArrayList, Context context) {
        this.attributesArrayList = attributesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CrimeDetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.adapter_crime_detail, parent, false);
        CrimeDetailAdapter.ViewHolder viewHolder = new CrimeDetailAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CrimeDetailAdapter.ViewHolder holder, int position) {
        Date date = new Date(attributesArrayList.get(position).getOccDt());
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String d = sdf.format(date);
        holder.occDate.setText(d);
        holder.occAddress.setText(attributesArrayList.get(position).getObfAddress());
        if (attributesArrayList.get(position).getPlaceName() != null)
            holder.occPlaceName.setText(attributesArrayList.get(position).getPlaceName().toString());
        else
            holder.occPlaceName.setVisibility(View.GONE);
        holder.occType.setText(attributesArrayList.get(position).getCFSType());

    }

    public void update(ArrayList<Attributes> attributesArrayList) {
        this.attributesArrayList = attributesArrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return attributesArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView occDate, occAddress, occPlaceName, occType;

        public ViewHolder(View itemView) {
            super(itemView);
            occDate = itemView.findViewById(R.id.occurence_date);
            occAddress = itemView.findViewById(R.id.occurence_address);
            occPlaceName = itemView.findViewById(R.id.occurence_place_name);
            occType = itemView.findViewById(R.id.occurence_type);
        }
    }
}
