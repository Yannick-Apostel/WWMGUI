package application;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

public class BarChartController {
	@FXML
	private BarChart<String, Integer> barChart;

	public void erstelle(int a, int b, int c, int d) {
		XYChart.Series<String, Integer> data = new XYChart.Series<String, Integer>();
		data.setName("Auswertung des Publikumsjoker");
		data.getData().add(new XYChart.Data("A", a));
		data.getData().add(new XYChart.Data("B", b));
		data.getData().add(new XYChart.Data("C", c));
		data.getData().add(new XYChart.Data("D", d));
		barChart.getData().addAll(data);
	}
		
	}
