package com.kenos.positiondemo;

import android.content.Context;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

/**
 * User: hxk(huangxikang@520bangxin.cn)
 * Date: 2016-11-08
 * Time: 10:52
 * Description:
 */
public  class AMapLocUtils implements AMapLocationListener {
    private AMapLocationClient locationClient = null;  // 定位
    private AMapLocationClientOption locationOption = null;  // 定位设置
    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        mLonLatListener.getLonLat(aMapLocation);
        locationClient.stopLocation();
        locationClient.onDestroy();
        locationClient = null;
        locationOption = null;
    }

    private LonLatListener mLonLatListener;
    public void  getLonLat(Context context, LonLatListener lonLatListener){
        locationClient = new AMapLocationClient(context);
        locationOption = new AMapLocationClientOption();
        locationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);// 设置定位模式为高精度模式
        locationClient.setLocationListener(this);// 设置定位监听
        locationOption.setOnceLocation(false); // 单次定位
        locationOption.setNeedAddress(true);//逆地理编码
        mLonLatListener = lonLatListener;//接口
        locationClient.setLocationOption(locationOption);// 设置定位参数
        locationClient.startLocation(); // 启动定位
    }
    public interface  LonLatListener{
        void getLonLat(AMapLocation aMapLocation);
    }
}
