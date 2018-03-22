package com.northeastern.msd.team102.plagiarismchecker.antlr.ast;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Jama.Matrix;

public class WeighComparators {
	private Logger logger;
	private List<ArrayList<Double>> dataX;
	private List<Double> dataY;
	private String path;
	
	WeighComparators(String path) {
		logger = Logger.getLogger(WeighComparators.class.getName());
		this.dataX = new ArrayList<>();
		this.dataY = new ArrayList<>();
		this.path = path;
	}
	
	public void readCSV() {
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(this.path))) {
            while ((line = br.readLine()) != null) {
                String[] trainRow = line.split(cvsSplitBy);
                List<Double> row = new ArrayList<>();
                for (int i = 2; i<5; i++) {
                	row.add(Double.parseDouble(trainRow[i]));
                }
                this.dataX.add((ArrayList<Double>) row);
                this.dataY.add(Double.parseDouble(trainRow[5]));
            }
        } catch (Exception e) {
        	logger.log(Level.INFO, "Exception : {0}",e);
        }    
	}
	
	public void computeMatrix() {
		double[][] dataXArr = new double[dataX.size()][dataX.get(0).size()];
		int i = 0;
		for (ArrayList<Double> d : dataX) {
			for (int j = 0; j < dataX.get(0).size(); j++) {
				dataXArr[i][j] = d.get(j);
			}
			i++;
		}
		double[][] dataYArr = new double[dataY.size()][1];
		i = 0;
		for (Double d : dataY) {
			dataYArr[i][0] = d;
			i++;
		}
		Matrix X = new Matrix(dataXArr);
		Matrix Y = new Matrix(dataYArr);
		Matrix XTranspose = X.transpose();
		Matrix XMul = XTranspose.times(X);
		Matrix XInverse = XMul.inverse();
		Matrix XMul2 = XInverse.times(XTranspose);
		Matrix wTrain = XMul2.times(Y);
//		System.out.println(A);
	}
	
	public static void main(String[] args) {
		WeighComparators w = new WeighComparators("src/main/resources/TrainingData.csv");
		w.readCSV();
		w.computeMatrix();
	}
}
