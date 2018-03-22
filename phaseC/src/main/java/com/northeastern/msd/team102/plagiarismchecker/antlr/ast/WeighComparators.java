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
	private double weights[];
	private double YPredicted[];
	private int noOfComparators;
	
	WeighComparators(String path) {
		logger = Logger.getLogger(WeighComparators.class.getName());
		this.dataX = new ArrayList<>();
		this.dataY = new ArrayList<>();
		this.path = path;
		this.noOfComparators = 0;
		readCSV();
		computeMatrix();
		getPredictedOutput();
	}
	
	public void readCSV() {
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(this.path))) {
            while ((line = br.readLine()) != null) {
                String[] trainRow = line.split(cvsSplitBy);
                this.noOfComparators = trainRow.length-3;
                List<Double> row = new ArrayList<>();
                for (int i = 2; i<trainRow.length-1; i++) {
                	row.add(Double.parseDouble(trainRow[i]));
                }
                this.dataX.add((ArrayList<Double>) row);
                this.dataY.add(Double.parseDouble(trainRow[trainRow.length-1]));
            }
        } catch (Exception e) {
        	logger.log(Level.INFO, "Exception : {0}",e);
        } 
        this.weights = new double[noOfComparators];
        this.YPredicted = new double[dataY.size()];
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
		double[][] w = wTrain.getArray();
		for (int p = 0; p< w.length; p++) {
			this.weights[p] = w[p][0];
		}
	}
	
	public void getPredictedOutput() {
		int i = 0;
		for (ArrayList<Double> d : dataX) {
			this.YPredicted[i] = 0;
			for (int j = 0; j < dataX.get(0).size(); j++) {
				this.YPredicted[i] += d.get(j)*this.weights[j];
			}
			System.out.println(this.YPredicted[i]);
			i++;
		}
	}
	
	public static void main(String[] args) {
		WeighComparators w = new WeighComparators("src/main/resources/TrainingData.csv");
	}
}
