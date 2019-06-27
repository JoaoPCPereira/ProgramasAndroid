package com.example.programamagia.Adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.programamagia.Comandos_SQL.Entidades.Sub_Capitulo;
import com.example.programamagia.R;

import java.util.ArrayList;

public class Adapter_Edittxt extends BaseAdapter {
    private Context context;
    private static ArrayList<Sub_Capitulo> editModelArrayList;

    public Adapter_Edittxt(Context context, ArrayList<Sub_Capitulo> editModelArrayList) {

        this.context = context;
        this.setEditModelArrayList(editModelArrayList);
    }

    public static ArrayList<Sub_Capitulo> getEditModelArrayList() {
        return editModelArrayList;
    }

    public static void setEditModelArrayList(ArrayList<Sub_Capitulo> editModelArrayList) {
        Adapter_Edittxt.editModelArrayList = editModelArrayList;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }
    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public int getCount() {
        return getEditModelArrayList().size();
    }

    @Override
    public Object getItem(int position) {
        return getEditModelArrayList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lista_valores_layout, null, true);

            holder.editText=((EditText) convertView.findViewById(R.id.editText_valor));
            holder.textView=((TextView) convertView.findViewById(R.id.textView_valor));



            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.editText.setText(getEditModelArrayList().get(position).getObs());
        holder.textView.setText(getEditModelArrayList().get(position).getNome());

        holder.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                getEditModelArrayList().get(position).setObs(holder.editText.getText().toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return convertView;
    }



    private class ViewHolder {

        protected EditText editText;
        protected TextView textView;


    }




}