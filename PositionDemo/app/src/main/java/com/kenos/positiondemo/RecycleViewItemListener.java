package com.kenos.positiondemo;

import android.view.View;

public interface RecycleViewItemListener {

    void onItemClick(View view, int position);

    void onItemLongClick(View view, int position);

}
