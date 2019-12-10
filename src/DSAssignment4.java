
import java.util.List;
import java.io.*;
import java.awt.*;

import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.CircleBackground;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.palette.ColorPalette;
import com.kennycason.kumo.palette.LinearGradientColorPalette;

public class DSAssignment4 {
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub		
		        //This assignment builds on Assignment 3 and assumes that I already created a text file of organized Word frequency called OrderedDictionary
		        FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
		        List<WordFrequency> wordFrequencies = frequencyAnalyzer.load("OrderedDictionary");
		        Dimension dimension = new Dimension(600, 600);
		        WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
		        wordCloud.setPadding(2);
		        wordCloud.setBackground(new CircleBackground(300));
		        wordCloud.setColorPalette(new ColorPalette(new Color(0x4055F1), new Color(0x408DF1), new Color(0x40AAF1), new Color(0x40C5F1), new Color(0x40D3F1), new Color(0xFFFFFF)));
		        wordCloud.setFontScalar(new SqrtFontScalar(10, 40));
		        wordCloud.build(wordFrequencies);
		        wordCloud.writeToFile("Image.png");

		        frequencyAnalyzer.setWordFrequenciesToReturn(500); 
		        wordCloud.setPadding(2);
		        wordCloud.setBackground(new CircleBackground(300));
		        // colors followed by and steps between
		        wordCloud.setColorPalette(new LinearGradientColorPalette(Color.RED, Color.BLUE, Color.GREEN, 30, 30));
		        wordCloud.setFontScalar( new SqrtFontScalar(10, 40));
		        wordCloud.build(wordFrequencies);
		        wordCloud.writeToFile("Image2.png");
		        


	}
}
