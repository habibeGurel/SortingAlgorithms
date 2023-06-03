/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.heapproject;

/**
 *
 * @author Habibe
 */
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChartExample extends JFrame {
    double[] array;
    private static final long serialVersionUID = 1L;

    public LineChartExample(String title, double[] arr) {
        super(title);
        array = arr;
        // Create dataset  
        DefaultCategoryDataset dataset = createDataset();
        // Create chart  
        JFreeChart chart = ChartFactory.createLineChart(
                "Sorting Graphs", // Chart title  
                "Sorting Types", // X-Axis Label  
                "Sorting Times", // Y-Axis Label  
                dataset
        );

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private DefaultCategoryDataset createDataset() {

        String series1 = "Time";

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(array[0], series1, "heap sort");
        dataset.addValue(array[1], series1, "bubble sort");
        dataset.addValue(array[2], series1, "insertation sort");
        dataset.addValue(array[3], series1, "selection sort");
        dataset.addValue(array[4], series1, "quick sort");
        dataset.addValue(array[5], series1, "merge sort");

        return dataset;
    }

}
