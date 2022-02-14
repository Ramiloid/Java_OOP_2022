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
abstract class AContactAdvancedWithOrganizationAndNetwork implements IContact {
    
    String Name;
    String Number;
    String Organisation;
    Boolean hasTelegram;
    String SecondNumber;

    /**
     * Конструктор класса без аргументов,запрашивает данные у пользователя
     */
    public AContactAdvancedWithOrganizationAndNetwork() {

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
        System.out.println("Введите привязан ли к номеру телеграм: Да/Нет");
        try {
            String CheckHas = in.next();
            if (CheckHas.toLowerCase().equalsIgnoreCase("да")) {
                hasTelegram = true;
            } else {
                hasTelegram = false;
            }
        } catch (Exception e) {
            System.out.println("Неверный формат");
        }
        System.out.println("Введите альтернативный номер: ");
        try {
            SecondNumber = in.next();
        } catch (Exception e) {
            System.out.println("Неверный формат");
        }
    }

    /**
     * Конструктор класса с аргументом имени , остальные данные запрашивает у
     * пользователя
     *
     * @param Name - имя контакта
     */
    public AContactAdvancedWithOrganizationAndNetwork(String Name) {
        Scanner in = new Scanner(System.in);
        this.Name = Name;
        System.out.println("Введите номер: ");
        Number = in.next();
        System.out.println("Введите организацию: ");
        Organisation = in.next();
        System.out.println("Введите привязан ли к номеру телеграм: Да/Нет");
        String CheckHas = in.next();
        if (CheckHas.equalsIgnoreCase("Да")) {
            hasTelegram = true;
        } else if (CheckHas.equalsIgnoreCase("Нет")) {
            hasTelegram = false;
        } else {
            hasTelegram = false;
        }
        System.out.println("Введите альтернативный номер: ");
        SecondNumber = in.next(Name);

    }

    /**
     * Конструктор класса с аргументом имени и основного номера , остальные
     * данные запрашивает у пользователя
     *
     * @param Name - имя контакта
     * @param Number - основной номер контакта
     */
    public AContactAdvancedWithOrganizationAndNetwork(String Name, String Number) {
        Scanner in = new Scanner(System.in);
        this.Name = Name;
        this.Number = Number;
        System.out.println("Введите организацию: ");
        Organisation = in.next();
        System.out.println("Введите привязан ли к номеру телеграм: Да/Нет");
        String CheckHas = in.next();
        if (CheckHas.equalsIgnoreCase("Да")) {
            hasTelegram = true;
        } else if (CheckHas.equalsIgnoreCase("Нет")) {
            hasTelegram = false;
        } else {
            hasTelegram = false;
        }
        System.out.println("Введите альтернативный номер: ");
        SecondNumber = in.next(Name);
    }

    /**
     * Конструктор класса с аргументом имени,основного номера и организации ,
     * остальные данные запрашивает у пользователя
     *
     * @param Name - имя контакта
     * @param Number - основной номер контакта
     * @param Organisation - название организации
     */
    public AContactAdvancedWithOrganizationAndNetwork(String Name, String Number, String Organisation) {
        Scanner in = new Scanner(System.in);
        this.Name = Name;
        this.Number = Number;
        this.Organisation = Organisation;
        System.out.println("Введите привязан ли к номеру телеграм: Да/Нет");
        String CheckHas = in.next();
        if (CheckHas.equalsIgnoreCase("Да")) {
            hasTelegram = true;
        } else if (CheckHas.equalsIgnoreCase("Нет")) {
            hasTelegram = false;
        } else {
            hasTelegram = false;
        }
        System.out.println("Введите альтернативный номер: ");
        SecondNumber = in.next(Name);
    }

    /**
     * Конструктор класса с аргументом имени,основного номера,организации и
     * наличие телеграмма , остальные данные запрашивает у пользователя
     *
     * @param Name - имя контакта
     * @param Number - основной номер контакта
     * @param Organisation - название организации
     * @param hasTelegram - наличие телеграмма
     */
    public AContactAdvancedWithOrganizationAndNetwork(String Name, String Number, String Organisation, Boolean hasTelegram) {
        Scanner in = new Scanner(System.in);
        this.Name = Name;
        this.Number = Number;
        this.Organisation = Organisation;
        this.hasTelegram = hasTelegram;
        System.out.println("Введите альтернативный номер: ");
        SecondNumber = in.next(Name);
    }

    /**
     * Конструктор в который передаются все необходимые аргументы
     *
     * @param Name - имя контакта
     * @param Number - основной номер контакта
     * @param Organisation - название организации
     * @param hasTelegram - наличие телеграмма
     * @param SecondNumber - дополнительный номер
     */
    public AContactAdvancedWithOrganizationAndNetwork(String Name, String Number, String Organisation, Boolean hasTelegram, String SecondNumber) {
        this.Name = Name;
        this.Number = Number;
        this.SecondNumber = SecondNumber;
        this.Organisation = Organisation;
        this.hasTelegram = hasTelegram;
    }

    /**
     * Метод возвращающий Имя контакта
     * @return возвращает имя контакта
     */
    public String getName() {
        return this.Name;
    }

    /**
     * Метод возвращающий Номер контакта
     * @return возвращает основной номер контакта
     */
    public String getNumber() {
        return this.Number;
    }

    /**
     * Метод возвращающий Организацию контакта
     * @return возвращает наименование организации 
     */
    public String getOrganisation() {
        return this.Organisation;
    }

    /**
     * Метод возвращающий наличие Телеграмма у контакта
     * @return возвращает наличие телеграмма у контакта
     */
    public Boolean getTelegram() {
        return this.hasTelegram;
    }

    /**
     * Метод возвращающий Имя контакта
     * @return возвращает дополнительный номер контакта
     */
    public String getSecondNumber() {
        return this.SecondNumber;
    }

    /**
     * Метод назначает основной номер контакта
     *
     * @param Number - основной номер контакта
     */
    public void setNumber(String Number) {
        this.Number = Number;
    }

    /**
     * Метод назначает Имя контакта
     *
     * @param Name - имя контакта
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * Метод назначает организацию контакта
     *
     * @param Organisation - название организации
     */
    public void setOrganisation(String Organisation) {
        this.Organisation = Organisation;
    }

    /**
     * Метод назначает наличие телеграмма у контакта
     *
     * @param hasTelegram - наличие телеграмма
     */
    public void setTelegram(Boolean hasTelegram) {
        this.hasTelegram = hasTelegram;
    }

    /**
     * Метод назначает дополнительный номер контакта
     *
     * @param SecondNumber - дополнительный номер
     */
    public void setSecondNumber(String SecondNumber) {
        this.SecondNumber = SecondNumber;
    }

    /**
     * Абстрактный метод для реализации отправки сообщений в телеграмм
     */
    abstract void MessageToTelegram();

    /**
     * Переопределенный метод ,который выводит данные о контакте
     */
    @Override
    public String toString() {
        String telegramStatus = "Нет";
        if (this.hasTelegram == true) {
            telegramStatus = "Да";
        } else {
            telegramStatus = "Нет";
        }

        return ("Имя: " + this.Name + " " + "Tel: " + this.Number + " " + "Организация: " + this.Organisation + " " + "Наличие телеграмма: " + telegramStatus + " " + "2th Tel: " + this.SecondNumber);
    }

}
