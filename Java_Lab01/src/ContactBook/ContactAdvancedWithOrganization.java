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
public class ContactAdvancedWithOrganization {
    String Name;
    String Number;
    String Organisation;
    
     /**
     * Конструктор класса без аргументов,запрашивает данные у пользователя
     */
    public ContactAdvancedWithOrganization(){
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
        System.out.println("Введите организацию: ");
        try {
            Organisation = in.next();
        } catch (Exception e) {
            System.out.println("Неверный формат");
        }
       
    }
    /**
     * Конструктор в который передаются Имя как аргумент , все остальное заполняет пользователь
     *
     * @param Name - имя контакта
     */
    public ContactAdvancedWithOrganization(String Name){
        this.Name = Name;
          Scanner in = new Scanner(System.in, "windows-1251");
        System.out.println("Введите номер: ");
        try {
            Number = in.next();

        } catch (Exception e) {
            System.out.println("Неверный формат");
        }
        System.out.println("Введите организацию: ");
        try {
            Organisation = in.next();
        } catch (Exception e) {
            System.out.println("Неверный формат");
        }
    }
    /**
     * Конструктор в который передаются Имя,Номер контакта как аргумент , все остальное заполняет пользователь
     *
     * @param Name - имя контакта
     * @param Number - номер контакта
     */
    public ContactAdvancedWithOrganization(String Name, String Number){
        this.Name = Name;
        this.Number = Number;
        Scanner in = new Scanner(System.in, "windows-1251");
        System.out.println("Введите организацию: ");
        try {
            Organisation = in.next();
        } catch (Exception e) {
            System.out.println("Неверный формат");
        }
    }
    /**
     * Конструктор в который передаются Имя,Номер контакта как аргумент , все остальное заполняет пользователь
     *
     * @param Name - имя контакта
     * @param Number - номер контакта
     * @param Organisation - организация контакта
     */
     public ContactAdvancedWithOrganization(String Name, String Number,String Organisation){
        this.Name = Name;
        this.Number = Number;
        this.Organisation = Organisation;
        
    }

    /**
     * Метод возвращающий Имя контакта
     * @return возвращает имя контакта
     */
    public String getName(){
        return this.Name;
    }
    /**
     * Метод возвращающий Номер контакта
     * @return возвращает основной номер контакта
     */
    public String getNumber(){
        return this.Number;
    }
    /**
     * Метод возвращающий Организацию контакта
     * @return возвращает наименование организации 
     */
    public String getOrganisation(){
        return this.Organisation;
    }
    /**
     * Метод назначает основной номер контакта
     *
     * @param Number - основной номер контакта
     */
    public void setNumber(String Number){
        this.Number = Number;
    }
    /**
     * Метод назначает Имя контакта
     *
     * @param Name - имя контакта
     */
    public void setName(String Name){
        this.Name = Name;
    }
    /**
     * Метод назначает организацию контакта
     *
     * @param Organisation - название организации
     */
    public void setOrganisation(String Organisation){
        this.Organisation = Organisation;
    }
    
   
  
    /**
     * Переопределенный метод ,который выводит данные о контакте
     * @return возвращает данные о контакте
     */
    @Override
    public String toString(){
        
        return ("Имя: " + this.Name + " " + "Tel: " + this.Number + " " + "Организация: " + this.Organisation);
    }
    
}
