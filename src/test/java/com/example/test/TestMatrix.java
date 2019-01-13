package com.example.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.exception.NoSquareException;
import com.example.model.*;
import com.example.service.*;


public class TestMatrix {

	@Test
	public void testTranspose() {
		double[][] data = {{0,5},{3,9}};
		double[][] dataTranspose = {{0,3},{5,9}};
		Matrix matrix = new Matrix(data);
		Matrix actualMatrix = MatrixMathematics.transpose(matrix);
		double[][] actualData = actualMatrix.getValues();
		for (int i = 0; i < actualData.length; i++) {
			for (int j = 0; j < actualData[i].length; j++) {
				assertEquals(dataTranspose[i][j],actualData[i][j],0);
			}
		}		
	}

	@Test
	public void testInverse() throws NoSquareException {
		double[][] data = {{1,2},{3,4}};
		double[][] dataInverse = {{-2,1},{1.5,-0.5}};
		Matrix matrix = new Matrix(data);
		Matrix actualMatrix = MatrixMathematics.inverse(matrix);
		double[][] actualData = actualMatrix.getValues();
		for (int i = 0; i < actualData.length; i++) {
			for (int j = 0; j < actualData[i].length; j++) {
				assertEquals(dataInverse[i][j],actualData[i][j],0);
			}
		}	
	}

	@Test
	public void testDeterminant() throws NoSquareException {
		double[][] data = {{1,2,3},{4,5,6},{7,8,10}};
		double determinant = -3;
		Matrix matrix = new Matrix(data);
		double actualDeterminant = MatrixMathematics.determinant(matrix);
		assertEquals(determinant, actualDeterminant,0);
		
	}
	
	@Test(expected = NoSquareException.class)
	public void testDeterminantException() throws NoSquareException {
		double[][] data = {{1,2,3},{4,5,6}};
		double determinant = -3;
		Matrix matrix = new Matrix(data);
		double actualDeterminant = MatrixMathematics.determinant(matrix);
		
		
	}


	@Test
	public void testCofactor() throws NoSquareException {
		double[][] data = {{1,2},{3,4}};
		double[][] dataCofactor = {{4,-3},{-2,1}};
		Matrix matrix = new Matrix(data);
		Matrix actualMatrix = MatrixMathematics.cofactor(matrix);
		double[][] actualData = actualMatrix.getValues();
		for (int i = 0; i < actualData.length; i++) {
			for (int j = 0; j <actualData[i].length; j++) {
				assertEquals(dataCofactor[i][j],actualData[i][j],0);
			}
		}	
	}

}
