package com.example.datavisualizationapp

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.github.mikephil.charting.charts.*
import com.github.mikephil.charting.data.*

class MainActivity : AppCompatActivity() {

    private lateinit var lineChart: LineChart
    private lateinit var radarChart: RadarChart
    private lateinit var horizontalBarChart: HorizontalBarChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 🔹 Force Light Mode (White Background)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        setContentView(R.layout.activity_main)

        lineChart = findViewById(R.id.lineChart)
        radarChart = findViewById(R.id.radarChart)
        horizontalBarChart = findViewById(R.id.horizontalBarChart)

        // 🔹 Set White Background for Charts
        lineChart.setBackgroundColor(Color.WHITE)
        radarChart.setBackgroundColor(Color.WHITE)
        horizontalBarChart.setBackgroundColor(Color.WHITE)

        setupLineChart()
        setupRadarChart()
        setupHorizontalBarChart()
    }

    private fun setupLineChart() {
        val entries = ArrayList<Entry>()
        entries.add(Entry(1f, 120f))
        entries.add(Entry(2f, 150f))
        entries.add(Entry(3f, 170f))
        entries.add(Entry(4f, 200f))

        val dataSet = LineDataSet(entries, "Monthly Sales Trend")
        dataSet.color = Color.BLUE
        dataSet.valueTextSize = 12f
        dataSet.lineWidth = 3f

        val lineData = LineData(dataSet)
        lineChart.data = lineData
        lineChart.description.text = "Line Chart"
        lineChart.invalidate()
    }

    private fun setupRadarChart() {
        val entries = ArrayList<RadarEntry>()
        entries.add(RadarEntry(80f))
        entries.add(RadarEntry(90f))
        entries.add(RadarEntry(75f))
        entries.add(RadarEntry(85f))

        val dataSet = RadarDataSet(entries, "Performance")
        dataSet.color = Color.RED
        dataSet.fillColor = Color.RED
        dataSet.setDrawFilled(true)
        dataSet.valueTextSize = 12f

        val radarData = RadarData(dataSet)
        radarChart.data = radarData
        radarChart.description.text = "Radar Chart"
        radarChart.invalidate()
    }

    private fun setupHorizontalBarChart() {
        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(1f, 100f))
        entries.add(BarEntry(2f, 140f))
        entries.add(BarEntry(3f, 180f))
        entries.add(BarEntry(4f, 160f))

        val dataSet = BarDataSet(entries, "Quarter Sales")
        dataSet.color = Color.GREEN
        dataSet.valueTextSize = 12f

        val barData = BarData(dataSet)
        horizontalBarChart.data = barData
        horizontalBarChart.description.text = "Horizontal Bar Chart"
        horizontalBarChart.invalidate()
    }
}