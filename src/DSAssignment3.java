
import java.util.*;

import javax.imageio.ImageIO;

import java.io.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
public class DSAssignment3 extends Application{
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		launch(args);
	}


@Override
public void start(Stage stage) throws Exception {

    // this is the same as assignment 3
	Scanner input = new Scanner(new File("Pocketful of Sunshine"));
    HashMap<String, Integer> wordCounts = new HashMap<String, Integer>();
    while (input.hasNext()) {
        String next = input.next().toLowerCase();
        String clean = next.replaceAll("\\p{Punct}", "").toLowerCase();

        if (!wordCounts.containsKey(clean)) {
            wordCounts.put(clean, 1);
        } else {
            wordCounts.put(clean, wordCounts.get(clean) + 1);
        }
    }

    HashMap<String, Integer> wordCount = sortByValue(wordCounts);
    // prints frequency to a new file
    PrintStream ps=new PrintStream("OrderedDictionary");
    for (String word : wordCount.keySet()) {
        int count = wordCount.get(word);
        ps.println(count + ": " + word);
    }
	// this creates the bar chart
    stage.setTitle("Word Frequency Chart");
    CategoryAxis xAxis = new CategoryAxis();
    NumberAxis yAxis = new NumberAxis();
    BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
    bc.setTitle("Pocketful of Sunshine by Natasha Bedingfield");
    bc.setLegendVisible(false);
    xAxis.setLabel("Word");       
    yAxis.setLabel("Value");

    XYChart.Series series1 = new Series();      
    for (String word : wordCount.keySet()) {        
    	series1.getData().add(new XYChart.Data(word, wordCount.get(word)));    
    }
    Scene scene  = new Scene(bc,800,600);
    bc.getData().addAll(series1);
    stage.setScene(scene);
    stage.show();
    WritableImage snapShot = scene.snapshot(null);
    ImageIO.write(SwingFXUtils.fromFXImage(snapShot, null), "png", new File("Image3.png"));
    
    //now to create the pie chart
    Scene scene2 = new Scene(new Group());
    stage.setTitle("Word Frequency Chart");
    stage.setWidth(500);
    stage.setHeight(500);

    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();      
    for (String word : wordCount.keySet()) {        
    	pieChartData.add(new PieChart.Data(word, wordCount.get(word)));    
            };
    final PieChart chart = new PieChart(pieChartData);
    chart.setTitle("Pocketful of Sunshine by Natasha Bedingfield");

    ((Group) scene2.getRoot()).getChildren().add(chart);
    stage.setScene(scene2);
    stage.show();
    WritableImage snapShot2 = scene2.snapshot(null);
    ImageIO.write(SwingFXUtils.fromFXImage(snapShot2, null), "png", new File("Image4.png"));
}
public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
	//to sort the map by value using a List
		      //creates a list of entries from our map
		      java.util.List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

		      // Sort the list
		      Collections.sort(list, new java.util.Comparator<Map.Entry<String, Integer> >() {
		        public int compare(Map.Entry<String, Integer> o1,
		                           Map.Entry<String, Integer> o2) {
		          return (o2.getValue()).compareTo(o1.getValue());
		        }
		      });

		      // put data from sorted list to hashmap
		      HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		      for (Map.Entry<String, Integer> aa : list) {
		        temp.put(aa.getKey(), aa.getValue());
		      }
		      return temp;
		    }
}
 

