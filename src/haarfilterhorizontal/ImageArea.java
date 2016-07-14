/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haarfilterhorizontal;

/**
 *
 * @author user
 */
public class ImageArea {

    public int[] CalculateArea(int winWidth, int winHeight, int sliderPosCol, int sliderPosRow, int count) {

        int[][] integralValues = new int[5][5];
        int[] featureValues = new int[90];
        int[] rectValues = new int[4];

        int btmRgtX, btmRgtY, btmLftX, btmLftY, topRgtX, topRgtY, topLftX, topLftY, a, b, c, d;

        IntegralImage integralImage = new IntegralImage();
        integralValues = integralImage.Integral();

        if (sliderPosCol == 1 || sliderPosRow == 1) {
            /**
             * Ignoring extreme left and extreme top values as they hold little
             * information when this is applied to image processing applications
             */

        } else {
            /**
             * My window width value is the 'i' from features which starts from
             * 1 hence, -1 for adjusting width since for window width 1, the
             * window itself should be considered or for window width 2 only one
             * step to move Another -1 since the integral values array starts
             * form 0 - the desired value so subtraction of one more one to
             * chose the desired value
             */
            btmRgtX = sliderPosCol + winWidth - 2;
            btmRgtY = sliderPosRow + winHeight - 2;

            btmLftX = sliderPosCol - 2;
            btmLftY = sliderPosRow + winHeight - 2;

            topRgtX = sliderPosCol + winWidth - 2;
            topRgtY = sliderPosRow - 2;

            topLftX = sliderPosCol - 2;
            topLftY = sliderPosRow - 2;

            if (btmRgtX >= 0 && btmRgtY >= 0) {
                a = integralValues[btmRgtY][btmRgtX];
            } else {
                a = 0;
            }

            if (topLftX >= 0 && topLftY >= 0) {
                b = integralValues[topLftY][topLftX];
            } else {
                b = 0;
            }

            if (btmLftX >= 0 && btmLftY >= 0) {
                c = integralValues[btmLftY][btmLftX];
            } else {
                c = 0;
            }

            if (topRgtX >= 0 && topRgtY >= 0) {
                d = integralValues[topRgtY][topRgtX];
            } else {
                d = 0;
            }
            System.out.println("COUNT = " + count);
            System.out.println("btmRT " + a);
            System.out.println("topLFT " + b);
            System.out.println("btmLFT " + c);
            System.out.println("topRGT " + d);

            featureValues[count] = ((a + b) - (c + d));

            System.out.println("feature at column: " + sliderPosCol + " row: " + sliderPosRow);
            System.out.println("window width= " + winWidth + " window height= " + winHeight + " IS " + (featureValues[count]));
            System.out.println("");
            /**
             * Ultimately another portion will be chosen with respect to the
             * above window and then their values will be subtracted to get the
             * actual features of the image This is one HAAR like filter, at
             * least two more might be needed for proper recognition
             */
        }
        return rectValues;
    }
}
