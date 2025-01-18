/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratesproject.utils;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import piratesproject.drawable.values.Pathes;
import piratesproject.models.RecordModel;

/**
 *
 * @author Admin
 */
public class FileHandler {

    public static void appendToFile(String text) {
        String filePath = Pathes.RECORDS_FILE_PATH;
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(text);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error while appending to file: " + e.getMessage());
        }
    }

    private static List<String> retrieveFromFile() {
        String filePath = Pathes.RECORDS_FILE_PATH;
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Error while reading from file: " + e.getMessage());
        }
        return lines;
    }
    
    public static ArrayList<RecordModel> getAllRecords(){
        ArrayList<RecordModel> records = new ArrayList();
        List<String> lines = retrieveFromFile();
        for (String line : lines) {
           // records.add(JsonUtils.jsonToRecordModel(line));
        }
        return records;
    }

}
