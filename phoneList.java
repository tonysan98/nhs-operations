import java.io.*;
import java.util.ArrayList;

public class phoneList {
    public static void main(String[] args) {
        //create an array to hold the csv data
        ArrayList<String[]> dataList = new ArrayList<>();

        //open csv and append to arraylist
        try(BufferedReader br = new BufferedReader(new FileReader("phoneData.csv"))){
            String line;
            while((line = br.readLine()) !=null){
                String[] data = line.split(",");
                dataList.add(data);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        generateHTML(dataList);
    }

    // method to create html list from the arrayList
    public static void generateHTML(ArrayList<String[]> dataList){
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("< !DOCTYPE html>\n<html>\n<head>\n<style>\n/* Your CSS styles here " +
                "\n</style>\n</head>\n<body>\n<div class=\"list-container\">\n<ul class=\"nice-list\">\n");

        for(String[] data : dataList){
            String name = data[0];
            String title = data[1];
            String classroom = data[2];
            String extension = data[3];
            String listItem = String.format("<li class=\"nice-list-item\"><span class=" +
                    "\"item-name\">%s</span><span class=\"item-details\">%s | %s | %s</span></li>\n",
                    name, title, classroom, extension);
            htmlContent.append(listItem);
        }

        htmlContent.append("</ul>\n</div>\n</body>\n</html>");

        // Write the HTML content to a file (e.g., output.html)
        try (FileWriter writer = new FileWriter("phoneList2.html")) {
            writer.write(htmlContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
