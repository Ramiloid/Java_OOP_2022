/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mrr_javaoop_04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Properties;
/**
 *
 * @author ADMIN
 */
public class MRR_JavaOOP_04 {

    /**
     * Главный класс отсюда начинается исполнение программы
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int r = 4; final int c = 5; 
        int m[][] = new int[r][c]; int k;

        // Вывод данных о задании на экран
        System.out.println("Laboratory work");
        System.out.println("Task: 3VAR Count a negative numbers after add a count value to min and max values of table");

        try {
            // Определяем текущий каталог с именем файла
            String FileName = new File(".").getAbsoluteFile().getParentFile().getAbsolutePath()
                    + System.getProperty("file.separator") + "rmm_data.xml";
            Properties p = new Properties(); // Переменная для хранения xml-данных
            File f = new File(FileName); // Переменная для доступа к файлам

            if (f.exists() == false) { // Если файл не существует, то
                f.createNewFile(); // Создаем пустой файл для дальнейшего сохранения в него данных xml
                // Создаем случайные данные для xml
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        k = (int) Math.round(Math.random() * 9);
                        p.put("m" + i + j, String.valueOf(k));
                    }
                }
                // Сохранение обработанных данных массива в XML-файл
                p.storeToXML(new FileOutputStream(FileName), new Date().toString());
            } else { // Если файл существует, то
                // Загружаем xml-данные из файла в переменную p для сохранения существующих значений
                p.loadFromXML(new FileInputStream(FileName)); 
            }

            System.out.println("Matrix:");

            // Считывание данных из XML-файла
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    k = Integer.valueOf(p.getProperty("m" + i + j, "0"));
                    m[i][j] = k;
                    System.out.print(k + " ");
                }
                System.out.println("");
            }

            // Реализация алгоритма варианта задания 
           int NegativenNumberCount = 0;
            int min = m[0][0], max = m[0][0], maxi = 0, maxj = 0, mini = 0, minj = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    
                    k = m[i][j];
                    if (k < 0){NegativenNumberCount+=1;}
                    if (k > max) { max = k; maxi = i; maxj = j; }
                    if (k < min) { min = k; mini = i; minj = j; }
                }
            }
            m[maxi][maxj] += NegativenNumberCount;
            m[mini][minj] += NegativenNumberCount;
            

            // Сохраняем данные итогового массива в перемменную XML-файла
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    // Сохраняем данные в переменную, хранящую данные xml
                    p.put("m" + i + j, String.valueOf(m[i][j]));
                }
            }
            // Сохранение обработанных данных массива в XML-файл
            p.storeToXML(new FileOutputStream(FileName), new Date().toString());

            // Считывание обработанных данных из XML-файла
            System.out.println("New matrix:");
            System.out.println(NegativenNumberCount);
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(p.getProperty("m" + i + j, "?") + " ");
                }
                System.out.println("");
            }

        } catch (Exception e) {
            System.err.println("Error working with XML-file!"); // Вывести сообщение об ошибке            
        }
    }
}
    

