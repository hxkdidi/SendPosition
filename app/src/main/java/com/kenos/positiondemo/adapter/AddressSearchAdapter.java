package com.kenos.positiondemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kenos.positiondemo.R;
import com.kenos.positiondemo.model.AddressEntity;

import java.util.ArrayList;
import java.util.List;

public class AddressSearchAdapter extends BaseRecycleViewAdapter<AddressEntity,AddressSearchAdapter.AddressViewHolder>{

    private final LayoutInflater inflater;
    private Context mContext;
    private List<AddressEntity> datas;

    public AddressSearchAdapter(Context context, ArrayList<AddressEntity> datas) {
        this.mContext=context;
        this.datas=datas;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public AddressViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.item_address, null);
        AddressViewHolder addressViewHolder = new AddressViewHolder(inflate);
        return addressViewHolder;
    }

    @Override
    public void onBindViewHolder(final AddressViewHolder holder, final int position) {
        final AddressEntity addressEntity = datas.get(position);
        holder.tv_name.setText(addressEntity.title);
        holder.tv_address.setText(addressEntity.snippet);
        holder.ll_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemListener!=null){
                    itemListener.onItemClick(holder.ll_root,position);
                    itemListener.onItemLongClick(holder.ll_root,position);
                }
            }
        });
        if(addressEntity.isChoose){
            holder.iv_select.setImageResource(R.mipmap.ic_arrow_check);
        }else {
            holder.iv_select.setImageBitmap(null);
        }
    }

    @Override
    public int getItemCount() {
        return datas==null?0:datas.size();
    }


    public static class AddressViewHolder extends RecyclerView.ViewHolder{

        private  TextView tv_name;
        private  TextView tv_address;
        private ImageView iv_select;
        private LinearLayout ll_root;

        public AddressViewHolder(final View itemView) {
            super(itemView);
            ll_root = (LinearLayout) itemView.findViewById(R.id.ll_root);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_address = (TextView) itemView.findViewById(R.id.tv_address);
            iv_select = (ImageView) itemView.findViewById(R.id.iv_select);
        }
    }
}
