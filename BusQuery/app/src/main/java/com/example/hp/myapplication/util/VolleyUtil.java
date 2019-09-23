//package com.example.hp.myapplication.util;
//
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonObjectRequest;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.Map;
//
//public class VolleyUtil {
//
//    public static final String objUrl = "http://" + Util.loadSetting(App.getContext()).getUrl() + ":" + Util.loadSetting(App.getContext()).getPort() + "/api/v2/";
//
//    public static void post(String url, Map<String, String> map, Response.Listener<JSONObject> ok, Response.ErrorListener er) {
//        try {
//            JSONObject object = new JSONObject();
//            if (map != null) {
//                for (String key : map.keySet()) {
//                    object.put(key,map.get(key));
//                }
//            }
//
//            if (ok == null) {
//                ok = new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject jsonObject) {
//
//                    }
//                };
//            }
//
//            if (er == null) {
//                er = new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError volleyError) {
//
//                    }
//                };
//            }
//
//            App.getRequestQueue().add(new JsonObjectRequest(objUrl + url, object, ok, er));
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//}
