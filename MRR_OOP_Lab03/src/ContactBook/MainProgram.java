
package ContactBook;

import ContactBook.ContactComplete.Organisation;

/**
 *
 * @author ramiloid
 */
public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
           
           ContactComplete MyContact = new ContactComplete();
           
           ContactComplete.Organisation org = MyContact.new Organisation();
           
           org.setOrganisation();
           org.setdirectorsNubmer();
           System.out.println(org.getOrganisation());
           System.out.println(org.getdirectorsNumber());
        
        
        
          /*ContactBook Contacts = new ContactBook();
          Contacts.AddContactInfo();
          Contacts.PrintContactMap();
          Contacts.PrintContactList();
          Contacts.PrintContactSet();
          Contacts.DoTask();
          Contacts.PrintContactMap();
          Contacts.PrintContactList();
          Contacts.PrintContactSet();
          */    


    }
    
}
