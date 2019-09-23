package com.example.hp.myapplication.frament;

import android.graphics.Color;
import android.os.Bundle;

import android.text.Spannable;
import android.text.method.MovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hp.myapplication.BusMainActivity;
import com.example.hp.myapplication.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BusFirstfunciton extends Fragment {

    @BindView(R.id.bus_fir_max_temp)
    TextView busFirMaxTemp;
    @BindView(R.id.bus_fir_min_temp)
    TextView busFirMinTemp;
    @BindView(R.id.bus_fir_Pm)
    TextView busFirPm;
    @BindView(R.id.bus_fir_air)
    TextView busFirAir;
    @BindView(R.id.bus_fir_wea_chart)
    LineChart busFirWeaChart;
    @BindView(R.id.bus_fir_pm_chart)
    PieChart busFirPmChart;
    private DecimalFormat format = new DecimalFormat("###,###,###,##0.00");
    Unbinder unbinder;
    private int airpm;
    private Timer timer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bus_first, container,false);
        unbinder = ButterKnife.bind(this, view);
        initDate();
        return view;
    }

    @Override
    public void onResume() {
        airPM();
        super.onResume();
    }

    private void initDate() {
        airPM();
        showTempLineChart();
    }

    private void airPM() {
        final int airTempMin = new Random().nextInt(10) + 15;
        final int airTempMax = new Random().nextInt(10) + 30;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        airpm = new Random().nextInt(200) + 1;

                        if (airpm < 50) {
                            busFirAir.setText("空气污染状态：优");
                        } else if (airpm > 50 && airpm <= 100) {
                            busFirAir.setText("空气污染状态：良");
                        } else if (airpm > 100 && airpm <= 150) {
                            busFirAir.setText("空气污染状态：较差");
                        } else {
                            busFirAir.setText("空气污染状态：差");
                        }
                        busFirPm.setText("PM2.5 ：" + airpm);
                        busFirMaxTemp.setText("最低温度 ：" + airTempMax);
                        busFirMinTemp.setText("最高温度 ： " + airTempMin);
                        showPmPieChart();

                    }


                });
            }
        }, 500, 100000);

    }

    private void showPmPieChart() {
        String[] titles = {"明天", "后天", "周三", "周四", "周五", "周六", "周日"};
        busFirPmChart.setDescription("");
        busFirPmChart.setUsePercentValues(true);
        busFirPmChart.setDrawHoleEnabled(false);
        busFirPmChart.animateXY(1000, 1000, Easing.EasingOption.Linear, Easing.EasingOption.Linear);

        Legend legend = busFirPmChart.getLegend();
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);
        legend.setTextSize(10f);
        legend.setFormSize(10f);

//        busFirPmChart.getLegend().setEnabled(false);
//busFirPmChart.setRotationEnabled(false);//关闭旋转

        List<String> xVals = new ArrayList<>();
        List<Entry> yVlas1 = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < titles.length; i++) {
            int airTempMin = random.nextInt(200) + 1;
            yVlas1.add(new Entry(airTempMin, i));
            xVals.add(titles[i]);
        }

        PieDataSet dataSet = new PieDataSet(yVlas1, "");
        dataSet.setValueTextSize(8f);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        dataSet.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float v, Entry entry, int i, ViewPortHandler viewPortHandler) {
                return format.format(v) + "%";
            }
        });

        PieData pieData = new PieData(xVals, dataSet);
        busFirPmChart.setData(pieData);
        busFirPmChart.invalidate();
    }

    private void showTempLineChart() {
        String[] titles = {"明天", "后天", "周三", "周四", "周五", "周六", "周日"};
        busFirWeaChart.setDescription("");
        busFirWeaChart.setDrawGridBackground(false);
        busFirWeaChart.setScaleEnabled(false);
        busFirWeaChart.animateXY(1000, 1000, Easing.EasingOption.Linear, Easing.EasingOption.Linear);
        busFirWeaChart.setExtraOffsets(10, 10, 20, 10);

        XAxis xAxis = busFirWeaChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(14f);
        xAxis.setDrawGridLines(false);
        xAxis.setTextColor(Color.GRAY);

        YAxis axisLeft = busFirWeaChart.getAxisLeft();
        axisLeft.setTextSize(13f);
        axisLeft.setDrawGridLines(false);
        axisLeft.setTextColor(Color.GRAY);
        axisLeft.setStartAtZero(true);

        busFirWeaChart.getAxisRight().setEnabled(false);
        busFirWeaChart.getLegend().setEnabled(false);

        List<String> xVals = new ArrayList<>();
        List<Entry> yVlas1 = new ArrayList<>();
        List<Entry> yVlas2 = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < titles.length; i++) {
            int airTempMin = random.nextInt(10) + 15;
            int airTempMax = random.nextInt(10) + 30;
            yVlas1.add(new Entry(airTempMin, i));
            yVlas2.add(new Entry(airTempMax, i));
            xVals.add(titles[i]);
        }

        List<LineDataSet> lineDataSets = new ArrayList<>();
        LineDataSet dataSet = new LineDataSet(yVlas1, "");
        dataSet.setLineWidth(2f);
        dataSet.setCircleSize(4f);
        dataSet.setDrawCircles(true);
        dataSet.setValueTextColor(Color.parseColor("#49b2e7"));
        dataSet.setColor(Color.parseColor("#49b2e7"));
        dataSet.setCircleColor(Color.parseColor("#49b2e7"));
        dataSet.setValueTextSize(12f);
        dataSet.setDrawCubic(true);

        LineDataSet dataSet1 = new LineDataSet(yVlas2, "");
        dataSet1.setLineWidth(2f);
        dataSet1.setCircleSize(4f);
        dataSet1.setDrawCircles(true);
        dataSet1.setColor(Color.parseColor("#ef5d5d"));
        dataSet1.setCircleColor(Color.parseColor("#ef5d5d"));
        dataSet1.setValueTextColor(Color.parseColor("#ef5d5d"));
        dataSet1.setValueTextSize(12f);
        dataSet1.setDrawCubic(true);

        lineDataSets.add(dataSet);
        lineDataSets.add(dataSet1);
        LineData data = new LineData(xVals, lineDataSets);
        busFirWeaChart.setData(data);
        busFirWeaChart.invalidate();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }

    @Override
    public void onStop() {
        super.onStop();
        if (timer!=null){
            timer.purge();
timer.cancel();
        }
    }
}
