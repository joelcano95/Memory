package org.joelcano.projectes.memory.controllers;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import org.joelcano.projectes.memory.R;
import org.joelcano.projectes.memory.llogica.Partida;

public class ImageAdapter extends BaseAdapter {


    public Context mContext;
    WindowManager windowManager;
    Display display;
    DisplayMetrics displayMetrics;
    Partida partida;


    public int calculaWidth(){
        return (int)((displayMetrics.widthPixels /4) * 0.75);
    }

    public int calculaHeight(){
        return (int)(displayMetrics.heightPixels*0.75 /(4));
    }

    public ImageAdapter(Context c, Partida partida) {
        mContext = c;
        windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
        displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        Log.i("width", ":" + displayMetrics.widthPixels);
        this.partida = partida;
    }

    public int getCount() {
        return partida.getnCartes();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams( calculaWidth(), calculaHeight()));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(20, 20, 20, 20);
        } else {
            imageView = (ImageView) convertView;
        }
        if (partida.getCartas()[position].getEstat() == 0)
            imageView.setImageResource(R.drawable.dorso);
        else
            imageView.setImageResource(partida.getCartas()[position].getValor());
        return imageView;
    }


    public void prova(int position){
        //Toast.makeText(mContext, "hola "+ position, Toast.LENGTH_SHORT).show();
        notifyDataSetChanged();
    }

}
