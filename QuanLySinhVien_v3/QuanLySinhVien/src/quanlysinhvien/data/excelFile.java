/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysinhvien.data;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author myPC
 */
public class excelFile {
    String defaultPath = "C:\\";
    
    public void importExcel(JTable table) {
        File excelFile = null;
//        FileInputStream excelFIS = null;
//        BufferedInputStream excelBIS = null;

        JFileChooser excelFileChooser = new JFileChooser(defaultPath);
        excelFileChooser.setBackground(Color.WHITE);
        int excelChooser = excelFileChooser.showOpenDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            try {
                excelFile = excelFileChooser.getSelectedFile();
                defaultPath = excelFile.getAbsolutePath();

//                excelFIS = new FileInputStream(excelFile);
//                excelBIS = new BufferedInputStream(excelFIS);
                XSSFWorkbook excelJButtonImport = new XSSFWorkbook(excelFile);
                XSSFSheet excelSheet = excelJButtonImport.getSheetAt(0);

                DefaultTableModel model = (DefaultTableModel) table.getModel();

                for (int row = 1; row <= excelSheet.getLastRowNum(); row++) {

                    XSSFRow excelRow = excelSheet.getRow(row);
                    model.setRowCount(row);

                    for (int collum = 0; collum < excelRow.getLastCellNum(); collum++) {

                        XSSFCell excelCell = excelRow.getCell(collum);
                        model.setValueAt(excelCell.toString(), row - 1, collum);
                        
                        //System.out.print(excelCell);
                    }
                    //System.out.println("");
                }
            } catch (Exception ex) {
                System.out.println("Err: " + ex.getMessage());
            }
        }
    }
    public void exportExcel(JTable table) {
        JFileChooser excelFileChooser = new JFileChooser(defaultPath);
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showSaveDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            XSSFWorkbook excelJTableFWorkbook = new XSSFWorkbook();
            XSSFSheet excelSheet = excelJTableFWorkbook.createSheet("JTable Sheet");

            DefaultTableModel model = (DefaultTableModel) table.getModel();

            for (int i = 0; i < model.getRowCount(); i++) {
                XSSFRow excelRow = excelSheet.createRow(i+1);
                for (int j = 0; j < model.getColumnCount(); j++) {
                    XSSFCell excelCell = excelRow.createCell(j);
                    if (model.getValueAt(i, j) != null) {
                        excelCell.setCellValue(model.getValueAt(i, j).toString());
                    }
                }
            }

            try {
                String fileName = excelFileChooser.getSelectedFile().toString();
                if (!fileName.endsWith(".xlsx")) {
                    fileName = fileName + ".xlsx";
                }
                FileOutputStream lastFile = new FileOutputStream(fileName);
                excelJTableFWorkbook.write(lastFile);
            } catch (IOException ex) {
            }
        }

    }
    public excelFile() {
        
    }
}
