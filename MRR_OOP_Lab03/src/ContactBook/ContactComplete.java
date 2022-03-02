/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContactBook;


import java.util.Scanner;

/**
 *
 * @author ramiloid Класс содержит в себе реализацию абстрактных методов , а
 * также является самым полным на данный момент для объекта типа Контакт
 */
public class ContactComplete extends AContactAdvancedWithOrganizationAndNetwork {

    /**
     * Конструктор контакта
     */
    public ContactComplete() {
        super();
    }

    /**
     *
     * @param Name - имя контакта
     * @param Number - номер контакта
     * @param Organisation - организация контакта
     * @param hasTelegram - наличие телеграмма
     * @param SecondNumber - дополнительный номер
     * 
     */
    public ContactComplete(String Name, String Number, String Organisation, boolean hasTelegram, String SecondNumber) {
        super(Name, Number, Organisation, hasTelegram, SecondNumber);
    }
////////////////////////////////////////////////////////////////////////////////////////////////
  

    /**
     * Класс Organisation - вложенный класс, содержит в себе дополнительные методы и поле номер директора
     */

    public class Organisation {

        String organisation;
        String directorsNumber;
        /**
         *
         * Конструктор без аргументов
         */
        public Organisation() {
            Scanner nc = new Scanner(System.in);
            System.out.println("Введите организацию");
            if (nc.hasNext()) {
                organisation = nc.next();

            }
            System.out.println("Введите номер директора");
            if (nc.hasNext()) {
                directorsNumber = nc.next();
            }
        }

        /**
         *
         * @param принимает значение огранизации
         */
        public Organisation(String organisation) {
            ContactComplete.super.Organisation = organisation;
            Scanner nc = new Scanner(System.in);
            System.out.println("Введите номер директора");
            if (nc.hasNext()) {
                directorsNumber = nc.next();
            }
        }
        /**
         *
         * @param принимает значение огранизации и номер директора
         * 
         */
        public Organisation(String organisation, String directorsNumber) {
            ContactComplete.super.Organisation = organisation;
            this.directorsNumber = directorsNumber;
        }

        /**
         *
         * @return возвращает текущую организацию
         */
        public String getOrganisation() {
            String retString = "Organisation is = " + ContactComplete.super.Organisation;
                    return retString;
        }

        /**
         *
         * @return возвращает номер директора
         */
        public String getdirectorsNumber() {
            String retString = "Nubmer of directro is = " + directorsNumber;
            return retString;
        }

        /**
         *  устанавливает текущую организацию
         */
        public void setOrganisation() {
            Scanner nc = new Scanner(System.in);
            System.out.println("Set an Organisation name");
            if (nc.hasNext()) {
                ContactComplete.super.Organisation = nc.next();
            }
        }

        /**
         * устанавливает текущий номер директора
         */
        public void setdirectorsNubmer() {
            Scanner nc = new Scanner(System.in);
            System.out.println("Set a Number of director");
            if (nc.hasNext()) {
                ContactComplete.super.Organisation = nc.next();
            }
        }

    }
/////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Класс TelegramBot - вложеннный статический класс, содержит статические методы для оплаты квитанций
     */
        static class TelegramBot{
            int pokaz = 0;
            int pokazBefore = 0;
            static int tax = 10;
            int value = 1000;
            
            /**
            * возвращает текущий статус по счету и предлагает варианты действий
            */
            void getInfo(){
                Scanner nc = new Scanner(System.in);
                System.out.println("Your balance is =" + value + "tenge");
                System.out.println("What do you want to do?");
                System.out.println("1 - send info ; 2 - how many to pay");
                if(nc.hasNextInt()){
                    int temp = nc.nextInt();
                    switch(temp){
                        case 1:
                            
                            SendInfo();
                            break;
                        case 2:
                            Payment();
                            break;
                        default:
                            System.out.println("You must be choose one");
                            break;
                    
                }
                }
                
            }
             /*
            * Метод отправляет информацию о показаниях по счетчику
            */
            void SendInfo(){
                System.out.println("Please send your pokaz now");
                Scanner nc = new Scanner(System.in);
                pokazBefore = pokaz;
                pokaz = nc.nextInt();
                
                
            }
            /*
            * Метод оплаты
            */
            void Payment(){
                System.out.println("Your current value is " + value);
                value = value - (tax*(pokaz - pokazBefore));
                System.out.println("Current tax is " + tax*(pokaz - pokazBefore));
                System.out.println("******************PAYMENT ACCEPTED *******************");
                System.out.println("Current value is " + value);
                

            }
        }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    /**
     * Абстрактный метод , который отвечает за отправку сообщений в телеграмм
     */
    @Override
    void MessageToTelegram() {
        System.out.println("Me: Hello!");
        System.out.println(this.Name + ": Hello!");
    }

    /**
     * Абстрактный метод, который удаляет данные о контакте
     */
    @Override
    public void deleteContact() {
        this.Name = null;
        this.Number = null;
        this.Organisation = null;
        this.hasTelegram = null;
        this.SecondNumber = null;
    }

    /**
     * Перезаписанный метод, для возвращение двух контактов вместо одного
     *
     * @return Возвращает строку с двумя номерами
     */
    @Override
    public String getNumber() {
        String Numbers = "Первый номер: " + this.Number + "\n" + "Второй номер: " + this.SecondNumber;
        return Numbers;
    }

    /**
     * Метод для переопределения основного номера контакта
     *
     * @param Number - главный номер контакта
     * @param SecondNumber - второстепенный номер
     */
    public void switchNumbers(String Number, String SecondNumber) {
        this.SecondNumber = Number;
        this.Number = SecondNumber;

    }

}
