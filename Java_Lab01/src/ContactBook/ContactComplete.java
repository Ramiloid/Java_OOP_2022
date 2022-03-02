/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContactBook;

/**
 *
 * @author ramiloid
 * Класс содержит в себе реализацию абстрактных методов , а также является самым полным на данный момент для объекта типа Контакт
 */
public class ContactComplete extends AContactAdvancedWithOrganizationAndNetwork {

    
    
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
    }

    /**
     * Перезаписанный метод, для возвращение двух контактов вместо одного
     * @return Возвращает строку с двумя номерами
     */
    @Override
    public String getNumber(){
        String Numbers = "Первый номер: " + this.Number + "\n" + "Второй номер: " + this.SecondNumber;
        return Numbers;
    }
    
    /**
     * Метод для переопределения основного номера контакта
     * @param Number - главный номер контакта
     * @param SecondNumber - второстепенный номер
     */
    public void switchNumbers(String Number, String SecondNumber){
        this.SecondNumber = Number;
        this.Number = SecondNumber;
        
    }
    
    
}
