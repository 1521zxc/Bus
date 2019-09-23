package com.example.hp.myapplication.frament;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hp.myapplication.R;
import com.example.hp.myapplication.bean.TwoBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BusSecondfunciton extends Fragment {
    @BindView(R.id.two_busImg)
    ImageView twoBusImg;
    @BindView(R.id.two_busMsg)
    TextView twoBusMsg;
    @BindView(R.id.two_busTimer)
    TextView twoBusTimer;
    @BindView(R.id.two_busPerson)
    TextView twoBusPerson;
    @BindView(R.id.two_listview)
    ListView two_listview;
    Unbinder unbinder;
    @BindView(R.id.two_busSpinner)
    Spinner twoBusSpinner;
    @BindView(R.id.iv_man)
    ImageView ivMan;
    @BindView(R.id.iv_woman)
    ImageView ivWoman;
    private Timer timer;
    List<TwoBean> list;
    private Handler handler1;
    private Handler handler2;
    private boolean flag;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bus_two, container, false);
        unbinder = ButterKnife.bind(this, view);
        flag = true;
        handler1 =new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what==0 && flag==true){
                    ivMan.setBackgroundResource(R.mipmap.jiaojing1_1);
                    handler1.sendEmptyMessageDelayed(1,1000);
                }else if(msg.what==1 && flag==true){
                    ivMan.setBackgroundResource(R.mipmap.jiaojing1_2);
                    handler1.sendEmptyMessageDelayed(0,1000);
                }
            }
        };
        handler1.sendEmptyMessage(0);  //先为轮播图片发一个空消息，加载第一张图


        handler2 =new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what==0 && flag==true){
                    ivWoman.setBackgroundResource(R.mipmap.jiaojing2_1);
                    handler2.sendEmptyMessageDelayed(1,1000);
                }else if(msg.what==1 && flag==true){
                    ivWoman.setBackgroundResource(R.mipmap.jiaojing2_2);
                    handler2.sendEmptyMessageDelayed(0,1000);
                }
            }
        };
        handler2.sendEmptyMessage(0);  //先为轮播图片发一个空消息，加载第一张图

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
      newTime();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        twoBusSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int item, long l) {
                if (item == 0) {
                    Exclusive(R.mipmap.ic_bus, "起点站首末车时间:06:30-19:10;\n" +
                            "终点站首末车时间:06:30-19:10;", "发车间隔:5分钟;", 5000);
                } else if (item == 1) {
                    Exclusive(R.mipmap.ic_bus, "起点站首末车时间:06:30-19:20;\n" +
                            "终点站首末车时间:06:30-19:20;", "发车间隔:5分钟;", 5000);
                } else if (item == 2) {
                    Exclusive(R.mipmap.ic_bus, "起点站首末车时间:06:30-19:20;\n" +
                            "终点站首末车时间:06:30-19:20;", "发车间隔:5分钟;", 5000);
                } else if (item == 3) {
                    Exclusive(R.mipmap.ic_bus, "起点站首末车时间:07:00-19:00;\n" +
                            "终点站首末车时间:07:00-19:00;", "发车间隔:5分钟;", 5000);
                } else if (item == 4) {
                    Exclusive(R.mipmap.ic_bus, "起点站首末车时间:06:30-18:30;\n" +
                            "终点站首末车时间:06:30-19:20;", "发车间隔:5分钟;", 5000);
                } else if (item == 5) {
                    Exclusive(R.mipmap.ic_bus, "起点站首末车时间:06:00-18:30;\n" +
                            "终点站首末车时间:06:00-18:30;", "发车间隔:5分钟;", 5000);
                } else if (item == 6) {
                    Exclusive(R.mipmap.ic_bus, "起点站首末车时间:06:30-19:00;\n" +
                            "终点站首末车时间:06:30-19:00;", "发车间隔:5分钟;", 5000);
                } else if (item == 7) {
                    Exclusive(R.mipmap.ic_bus, "起点站首末车时间:06:30-19:00;\n" +
                            "终点站首末车时间:06:30-19:00;", "发车间隔:7分钟;", 5000);
                } else if (item == 8) {
                    Exclusive(R.mipmap.ic_bus, "起点站首末车时间:06:30-18:00;\n" +
                            "终点站首末车时间:06:30-18:00;", "发车间隔:5分钟;", 5000);
                } else if (item == 9) {
                    Exclusive(R.mipmap.ic_bus, "起点站首末车时间:06:30-19:00;\n" +
                            "终点站首末车时间:06:30-19:30;", "发车间隔:7分钟;", 5000);
                } else if (item == 10) {
                    Exclusive(R.mipmap.ic_bus, "起点站首末车时间:07:00-18:00;\n" +
                            "终点站首末车时间:07:00-18:00;", "发车间隔:5分钟;", 5000);
                } else if (item == 11) {
                    Exclusive(R.mipmap.ic_bus, "起点站首末车时间:06:30-18:00;\n" +
                            "终点站首末车时间:06:30-18:00;", "发车间隔:5分钟;", 5000);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        newTime();

    }

    private void newTime() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int item = (int) twoBusSpinner.getSelectedItemId();
                        if (item == 0) {
                            Exclusive(R.drawable.ic_launcher_background, "起点站首末车时间:06:30-19:10;\n" +
                                    "终点站首末车时间:06:30-19:10;", "发车间隔:5分钟;", 5000);
                        } else if (item == 1) {
                            Exclusive(R.drawable.ic_launcher_background, "起点站首末车时间:06:30-19:20;\n" +
                                    "终点站首末车时间:06:30-19:20;", "发车间隔:5分钟;", 5000);
                        } else if (item == 2) {
                            Exclusive(R.drawable.ic_launcher_background, "起点站首末车时间:06:30-19:20;\n" +
                                    "终点站首末车时间:06:30-19:20;", "发车间隔:5分钟;", 5000);
                        } else if (item == 3) {
                            Exclusive(R.drawable.ic_launcher_background, "起点站首末车时间:07:00-19:00;\n" +
                                    "终点站首末车时间:07:00-19:00;", "发车间隔:5分钟;", 5000);
                        } else if (item == 4) {
                            Exclusive(R.drawable.ic_launcher_background, "起点站首末车时间:06:30-18:30;\n" +
                                    "终点站首末车时间:06:30-19:20;", "发车间隔:5分钟;", 5000);
                        } else if (item == 5) {
                            Exclusive(R.drawable.ic_launcher_background, "起点站首末车时间:06:00-18:30;\n" +
                                    "终点站首末车时间:06:00-18:30;", "发车间隔:5分钟;", 5000);
                        } else if (item == 6) {
                            Exclusive(R.drawable.ic_launcher_background, "起点站首末车时间:06:30-19:00;\n" +
                                    "终点站首末车时间:06:30-19:00;", "发车间隔:5分钟;", 5000);
                        } else if (item == 7) {
                            Exclusive(R.drawable.ic_launcher_background, "起点站首末车时间:06:30-19:00;\n" +
                                    "终点站首末车时间:06:30-19:00;", "发车间隔:7分钟;", 5000);
                        } else if (item == 8) {
                            Exclusive(R.drawable.ic_launcher_background, "起点站首末车时间:06:30-18:00;\n" +
                                    "终点站首末车时间:06:30-18:00;", "发车间隔:5分钟;", 5000);
                        } else if (item == 9) {
                            Exclusive(R.drawable.ic_launcher_background, "起点站首末车时间:06:30-19:00;\n" +
                                    "终点站首末车时间:06:30-19:30;", "发车间隔:7分钟;", 5000);
                        } else if (item == 10) {
                            Exclusive(R.drawable.ic_launcher_background, "起点站首末车时间:07:00-18:00;\n" +
                                    "终点站首末车时间:07:00-18:00;", "发车间隔:5分钟;", 5000);
                        } else if (item == 11) {
                            Exclusive(R.drawable.ic_launcher_background, "起点站首末车时间:06:30-18:00;\n" +
                                    "终点站首末车时间:06:30-18:00;", "发车间隔:5分钟;", 5000);
                        }
                    }
                });
            }
        }, 100, 3000);

    }

    private void Exclusive(int image, String busMsg, String Timer, int distances) {
        twoBusImg.setImageResource(image);
        twoBusMsg.setText(busMsg);
        twoBusTimer.setText(Timer);
        list = new ArrayList<>();
        int person = new Random().nextInt(50) + 1;
        twoBusPerson.setText("人数：" + person + "人");
        for (int j = 1; j < 10; j++) {
            int distance = new Random().nextInt(distances) + 1;
            list.add(new TwoBean("距离" + j + "站台" + distance + "米", distance / (20000 / 60) + "分钟到达"));
        }
        MyAdapter adapter = new MyAdapter(list);
        two_listview.setAdapter(adapter);
    }

    private class MyAdapter extends BaseAdapter {
        private List<TwoBean> list;

        public MyAdapter(List<TwoBean> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder;
            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.two_adapter, viewGroup, false);
                holder = new ViewHolder(view);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            holder.twoAdaDistance.setText(list.get(i).getDistance() + "");
            holder.twoAdaTimer.setText(list.get(i).getTimer() + "");
            return view;
        }

    }

    static class ViewHolder {
        @BindView(R.id.two_ada_distance)
        TextView twoAdaDistance;
        @BindView(R.id.two_ada_timer)
        TextView twoAdaTimer;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onStop() {
        super.onStop();
        timer.purge();
        timer.cancel();
//        timer = null;
    }

}
