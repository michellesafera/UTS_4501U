package com.example.michelle.chat;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michelle on 11/3/2017.
 */

public class MyOwnAdapter extends RecyclerView.Adapter<MyOwnAdapter.MAdapter> {

    List<JSONObject> dataJson = new ArrayList<>();
    JSONArray arrayJson;

    public MyOwnAdapter(JSONArray jason){
        arrayJson = jason;
        for (int i=0;i<this.arrayJson.length();i++)
            try {
                dataJson.add(this.arrayJson.getJSONObject(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
    }

    @Override
    public MAdapter onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listpesan,parent,false);
        return new MAdapter(view);
    }

    @Override
    public void onBindViewHolder(MAdapter holder, int position){
        JSONObject jsonObject = dataJson.get(position);
        try {
            holder.gambar.setImageResource(jsonObject.getInt("foto"));
            holder.nama.setText(jsonObject.getString("nama"));
            holder.pesan.setText(jsonObject.getString("pesan"));
            holder.waktu.setText(jsonObject.getString("waktu"));
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount(){
        return dataJson.size();
    }

    public class MAdapter extends RecyclerView.ViewHolder{
        ImageView gambar;
        TextView nama, pesan, waktu;

        public MAdapter(View itemView) {
            super(itemView);
            gambar = (ImageView)itemView.findViewById(R.id.foto);
            nama = (TextView)itemView.findViewById(R.id.pengirim);
            pesan = (TextView)itemView.findViewById(R.id.konten);
            waktu = (TextView)itemView.findViewById(R.id.tgl);
        }
    }
}