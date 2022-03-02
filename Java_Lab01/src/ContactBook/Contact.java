/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContactBook;

import java.util.Scanner;

/**
 *
 * @author ramiloid
 */
public class Contact {
    String Name;
    String Number;
    
     /**
     * Конструктор класса без аргументов,запрашивает данные у пользователя
     */
    public Contact(){
        Scanner in = new Scanner(System.in, "windows-1251");
        System.out.println("Начинаем создание нового контакта" + "\n" + "Введите имя : ");
        try {

            Name = in.next();

        } catch (Exception e) {
            System.out.println("Неверный формат");
        }
        System.out.println("Введите номер: ");
        try {
            Number = in.next();

        } catch (Exception e) {
            System.out.println("Неверный формат");
        }
    }
    /**
     * Конструктор класса с именем ввиде Аргумента ,запрашивает номер у пользователя
     * @param Name - Имя контакта
     */
    public Contact(String Name){
        this.Name = Name;
        Scanner in = new Scanner(System.in, "windows-1251");
        System.out.println("Введите номер: ");
        try {
            Number = in.next();

        } catch (Exception e) {
            System.out.println("Неверный формат");
        }
        
    }
    /**
     * Конструктор класса со всеми атрибутами, не запрашивает данные у пользователя
     * @param Name - имя контакта
     * @param Number - номер контакта
     */
    public Contact(String Name, String Number){
        this.Name = Name;
        this.Number = Number;
    }
    
    /**
     * Метод запрашивает имя контакта
     * @return Возвращает имя контакта
     */
    public String getName(){
        return this.Name;
    }
    
    /**
     * Метод запрашивает номер контакта
     * @return Возвращает номер контакта
     */
    public String getNumber(){
        return this.Number;
    }
    
    /**
     * Метод задает номер контакта
     * @param Number - номер контакта
     */
    public void setNumber(String Number){
        this.Number = Number;
    }
    
    /**
     * Метод задает имя контакта
     * @param Name - имя контакта
     */
    public void setName(String Name){
        this.Name = Name;
    }
  
    /**
     * Метод возвращает имя и номер контакта
     * @return Возвращает имя и номер контакта 
     */
    @Override
    public String toString(){
        
        return ("Имя: " + this.Name + " " +"Номер: " + this.Number);
    }
    
}
