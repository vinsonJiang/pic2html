package io.vinson.tool.html;

import java.io.*;

/**
 * @author: jiangweixin
 * @date: 2020/4/15
 */
public class HtmlTool {

    public static final String TOP_FILE_PATH = "";
    public static final String BOTTOM_FILE_PATH = "";

    public void saveHtml(String filePath, String picText) {
        File file = new File(filePath);
        File topFile = new File(TOP_FILE_PATH);
        File bottomFile = new File(BOTTOM_FILE_PATH);
        String topText = readFile(topFile);
        String bottomText = readFile(bottomFile);
        StringBuilder result = new StringBuilder();
        result.append(topText).append(result).append(bottomText);
        writeFile(file, result.toString());
    }

    public static String readFile(File file){
        try(FileInputStream fis = new FileInputStream(file)) {
            byte[] b = new byte[(int) file.length()];
            fis.read(b);
            return new String(b, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void writeFile(File file, String text) {
        if (text == null) {
            return;
        }
        try(FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
