package com.jsonfile.json.util;

import com.jsonfile.json.entities.SampleEntity;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.BlockRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.regression.SimpleRegression;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by schiduvasile on 5/9/17.
 */
public class CorrelationCalculation {

    private RealMatrix matrix;
    private RealMatrix outMatrix;
    private static final int DIMENSION = 6;
    private List<SampleEntity> outList = new LinkedList<>();



    public void convertListToRealMatrix(List<SampleEntity> list) {

        matrix = new BlockRealMatrix(list.size(), DIMENSION); // DIMENSION in our case is 8 (values in model)
        int i = 0;

        /**
         * Iterate through list and assign values the the BlockRealMatrix
         * In the end we obtain a Matrix with 8 columns and list.size() rows
         */
        for(SampleEntity element : list) {
            matrix.setEntry(i, 0, element.getAa_kids());
            matrix.setEntry(i, 1, element.getCf_adults());
            matrix.setEntry(i, 2, element.getCf_kids());
            matrix.setEntry(i, 3, element.getCw_adults());
            matrix.setEntry(i, 4, element.getMc_kids());
            matrix.setEntry(i, 5, element.getMc_total());
            i++;
        }
    }

    public void computeCorrelationMatrix() {
        int nVars = matrix.getColumnDimension(); // The matrix that was obtained from List<HealthModel>
        outMatrix = new BlockRealMatrix(nVars, nVars); // where the result will be stored, with the correlations
        for (int i = 0; i < nVars; i++) {
            for (int j = 0; j < i; j++) {

                double corr = correlation(matrix.getColumn(i), matrix.getColumn(j));
                outMatrix.setEntry(i, j, corr);
                outMatrix.setEntry(j, i, corr);
            }
            outMatrix.setEntry(i, i, 1d);
        }
    }

    public RealMatrix getOutMatrix() {
        return outMatrix;
    }

    /**
     *  This method was taken from the official source code of Apache Commons Math for calculation
     *  of correlation
     * @param xArray
     * @param yArray
     * @return double value that represents the correlation between to columns
     */
    private double correlation(final double[] xArray, final double[] yArray) {
        SimpleRegression regression = new SimpleRegression();
        if (xArray.length != yArray.length) {
            throw new DimensionMismatchException(xArray.length, yArray.length);
        } else if (xArray.length < 2) {
            throw new MathIllegalArgumentException(LocalizedFormats.INSUFFICIENT_DIMENSION,
                    xArray.length, 2);
        } else {
            for(int i=0; i<xArray.length; i++) {
                regression.addData(xArray[i], yArray[i]);
            }
            return regression.getR();
        }
    }



}
