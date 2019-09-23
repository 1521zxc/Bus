package com.example.hp.myapplication.util;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;
import static com.example.hp.myapplication.util.App.getContext;
//import static com.example.hp.myapplication.util.App.getContext;

/**
 * 项目名称：
 * 类描述：
 * 创建时间：2017/4/19 9:20
 * 修改人：Administrator
 * 修改时间：2017/4/19 9:20
 * 修改备注：
 */
public class Util {

    public static String urlHttp;
    public static String urlPort;
    private static SharedPreferences sp;

    /**
     * 描述：保存数据到SharedPreferences对象中
     *
     * @param ipUrl
     * @param ipPort
     */

    public static void saveSetting(String ipUrl, String ipPort, Context context) {
        SharedPreferences spSettingSave = context.getSharedPreferences("setting", MODE_PRIVATE);// 将需要记录的数据保存在setting.xml文件中
        SharedPreferences.Editor editor = spSettingSave.edit();
        editor.putString("ipUrl", ipUrl);
        editor.putString("ipPort", ipPort);
        editor.commit();
//        editor.apply();

    }

    /**
     * 描述：获取数据到SharedPreferences对象中
     *
     * @return
     */
    public static UrlBean loadSetting(Context context) {
        UrlBean urlBean = new UrlBean();

        SharedPreferences loadSettingLoad = context.getSharedPreferences("setting", MODE_PRIVATE);
        //这里是将setting.xml 中的数据读出来
        urlBean.setUrl(loadSettingLoad.getString("ipUrl", ""));
        urlBean.setPort(loadSettingLoad.getString("ipPort", ""));

//        String urlSetting = "http://" + urlHttp+ ":" + urlPort + "/";
        return urlBean;
    }

    public static void sp_put(String k, Object v) {
        sp = getContext().getSharedPreferences("ZNJT2019", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        if (v instanceof String) {
            edit.putString(k, (String) v);
        } else if (v instanceof Integer) {
            edit.putInt(k, (Integer) v);
        } else if (v instanceof Long) {
            edit.putLong(k, (Long) v);
        } else if (v instanceof Boolean) {
            edit.putBoolean(k, (Boolean) v);
        } else if (v instanceof Float) {
            edit.putFloat(k, (Float) v);
        } else {
            return;
        }
        edit.commit();
//        edit.apply();
    }

    public static Object sp_get(String k, Object v) {
        sp = getContext().getSharedPreferences("ZNJT2019", MODE_PRIVATE);
        if (v instanceof String) {
            return sp.getString(k, (String) v);
        } else if (v instanceof Integer) {
            return sp.getInt(k, (Integer) v);
        } else if (v instanceof Long) {
            return sp.getLong(k, (Long) v);
        } else if (v instanceof Boolean) {
            return sp.getBoolean(k, (Boolean) v);
        } else if (v instanceof Float) {
            return sp.getFloat(k, (Float) v);
        } else {
            return null;
        }
    }

    /*

    Map map = new HashMap();
      map.put("UserName", "user1");

      VolleyUtil.post("get_bus_station_info", map, new Response.Listener<JSONObject>() {
          @Override
          public void onResponse(JSONObject jsonObject) {
          Log.e("jso", jsonObject.toString());
              try {
                  if ("F".equals(jsonObject.getString("RESULT"))) {
                      Toast.makeText(App.getContext(), "网络信息错误！", Toast.LENGTH_SHORT).show();
                      return;
                  }



              } catch (JSONException e) {
                  e.printStackTrace();
              }
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError volleyError) {
              Toast.makeText(App.getContext(), "网络不通！", Toast.LENGTH_SHORT).show();
              return;
          }
      });

*/
}
