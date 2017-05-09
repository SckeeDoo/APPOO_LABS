package com.jsonfile.json;

import com.jsonfile.json.entities.SampleEntity;
import com.jsonfile.json.util.CorrelationCalculation;
import com.jsonfile.json.util.Reader;
import org.apache.commons.math3.linear.RealMatrix;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by schiduvasile on 3/23/17.
 */

public class Main {


    public static void main(String[] args ) {

        Reader reader = new Reader();
        reader.jsonParser();

        CorrelationCalculation correlationCalculation = new CorrelationCalculation();

        List<SampleEntity> list = reader.getList();

        correlationCalculation.convertListToRealMatrix(list);
        correlationCalculation.computeCorrelationMatrix();
        RealMatrix outMatrix = correlationCalculation.getOutMatrix();

        for(int i = 0; i < outMatrix.getRowDimension(); i++) {
            for(int j = 0; j < outMatrix.getColumnDimension(); j++) {
                System.out.print((new DecimalFormat("##.####").format(outMatrix.getEntry(i, j))) + "\t");
            }
            System.out.println();

        }

    }




}
