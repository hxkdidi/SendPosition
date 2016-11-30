package com.kenos.positiondemo;

import com.amap.api.services.core.LatLonPoint;

import java.io.Serializable;

/**
 * User: hxk(huangxikang@520bangxin.cn)
 * Date: 2016-11-08
 * Time: 11:19
 * Description:
 */
public class AddressSearchTextEntity implements Serializable{
    private static final long serialVersionUID = 1334462323232323333L;
    public boolean isChoose;
    public String title;
    public String snippet;
    public LatLonPoint latLonPoint;
    public String mainAddress;

    public AddressSearchTextEntity(boolean isChoose, LatLonPoint latLonPoint, String snippet, String title) {
        this.isChoose = isChoose;
        this.latLonPoint = latLonPoint;
        this.snippet = snippet;
        this.title = title;
    }

}
