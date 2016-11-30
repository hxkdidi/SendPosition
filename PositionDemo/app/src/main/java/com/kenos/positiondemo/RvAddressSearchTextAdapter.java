package com.kenos.positiondemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * User: hxk(huangxikang@520bangxin.cn)
 * Date: 2016-11-08
 * Time: 11:19
 * Description:
 */
public class RvAddressSearchTextAdapter extends BaseRecycleViewAdapter<AddressSearchTextEntity,RvAddressSearchTextAdapter.AddressViewHolder>{

    private final LayoutInflater inflater;
    private Context mContext;
    private List<AddressSearchTextEntity> datas;

    public RvAddressSearchTextAdapter(Context context, ArrayList<AddressSearchTextEntity> datas) {
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
    public void onBindViewHolder(AddressViewHolder holder, int position) {
        AddressSearchTextEntity addressSearchTextEntity = datas.get(position);
        holder.tv_name.setText(addressSearchTextEntity.title);
        holder.tv_address.setText(addressSearchTextEntity.snippet);
        holder.cb_select.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                ToastUtil.show(mContext,"选中了");
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas==null?0:datas.size();
    }

    public static class AddressViewHolder extends RecyclerView.ViewHolder{

        private  TextView tv_name;
        private  TextView tv_address;
        private  CheckBox cb_select;

        public AddressViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_address = (TextView) itemView.findViewById(R.id.tv_address);
            cb_select = (CheckBox) itemView.findViewById(R.id.cb_select);
        }
    }
}
