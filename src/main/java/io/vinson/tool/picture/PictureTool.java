package io.vinson.tool.picture;

import java.util.Arrays;

/**
 * @author: jiangweixin
 * @date: 2020/4/13
 */
public class PictureTool {

    public static void main(String[] args) {
        PictureTool tool = new PictureTool();
        System.out.println(tool.hex(5));
    }


    private String hex(int num) {
        Byte[] temp = new Byte[16];

        int counter = 0;

        while(num > 0) {
            byte n = (byte)(num & 0xF);

            if(n < 10) {
                temp[15 - counter] = (byte)((byte)('0') + n);
            } else {
                temp[15 - counter] = (byte)(55 + n);
            }
            num = num >> 4;
            counter++;
        }
        if(counter == 0) {
            return "";
        }
        if((counter & 1) != 0) {
            return "0" + Arrays.asList(temp).subList(16 - counter, temp.length - 1);
        }
        return "" + Arrays.asList(temp).subList(16 - counter, temp.length - 1);
    }

    public byte gray(byte r, byte g, byte b) {
        return (byte)(r / 5 + (Integer.valueOf(g) * 7 / 10) + b / 10);
    }

    public void grayScale() {

    }
}
