package application;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Button;

public class BarChartController {
	
	@FXML
	BarChart<String,Number> barChart;

	public void erstelle(int a, int b, int c, int d) {
		XYChart.Series<String,Number> dataA = new XYChart.Series<String,Number>();
		XYChart.Series<String,Number> dataB = new XYChart.Series<String,Number>();
		XYChart.Series<String,Number> dataC = new XYChart.Series<String,Number>();
		XYChart.Series<String,Number> dataD = new XYChart.Series<String,Number>();
		
		dataA.getData().add(new Data<String, Number>("", a));
		dataB.getData().add(new Data<String, Number>("", b));
		dataC.getData().add(new Data<String, Number>("", c));
		dataD.getData().add(new Data<String, Number>("", d));
		
		dataA.setName("A: " + a + "% ");
		dataB.setName("B: " + b + "% ");
		dataC.setName("C: " + c + "% ");
		dataD.setName("D: " + d + "% ");
		
		barChart.getData().addAll(dataA, dataB, dataC, dataD);
	}
}