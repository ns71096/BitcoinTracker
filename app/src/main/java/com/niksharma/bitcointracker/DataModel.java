package com.niksharma.bitcointracker;

import org.json.JSONException;
import org.json.JSONObject;

public class DataModel {
    private String updatedDate;
    private String code;
    private String price;

    public static DataModel toData(String response) throws JSONException {
        JSONObject obj=new JSONObject(response);
        DataModel temp=new DataModel();
        temp.updatedDate=obj.getJSONObject("time").getString("updated");
        temp.code=obj.getJSONObject("bpi").getJSONObject("USD").getString("code");
        temp.price=String.valueOf(obj.getJSONObject("bpi").getJSONObject("USD").getDouble("rate_float"));
        temp.price+="$";
        
        return temp;

    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
