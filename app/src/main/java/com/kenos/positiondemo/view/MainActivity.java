package com.kenos.positiondemo.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.kenos.positiondemo.utils.AMapLocUtils;
import com.kenos.positiondemo.R;

public class MainActivity extends AppCompatActivity {

    private TextView mTvResult;
    private TextView mTvSendLoc;
    private double mLongitude;
    private double mLatitude;
    private String cityCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvResult = (TextView) findViewById(R.id.mTvResult);
        mTvSendLoc = (TextView) findViewById(R.id.mTvSendLoc);
        mTvSendLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openSend = new Intent(MainActivity.this,ShareLocationActivity.class);
                openSend.putExtra("lon",mLongitude);
                openSend.putExtra("lat",mLatitude);
                openSend.putExtra("cityCode",cityCode);
                startActivity(openSend);
            }
        });
        new AMapLocUtils().getLonLat(this, new AMapLocUtils.LonLatListener() {
            @Override
            public void getLonLat(AMapLocation aMapLocation) {
                mTvResult.setText("当前经度"+aMapLocation.getLongitude()+
                        "\n当前纬度："+aMapLocation.getLatitude()+
                        "\n当前城市："+aMapLocation.getProvince()+aMapLocation.getCity()+
                        aMapLocation.getAddress());
                mLongitude = aMapLocation.getLongitude();
                mLatitude = aMapLocation.getLatitude();
                cityCode = aMapLocation.getCityCode();
                mTvSendLoc.setVisibility(View.VISIBLE);
            }
        });
    }
}
