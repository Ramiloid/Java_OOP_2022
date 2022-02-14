
package ContactBook;

/**
 *
 * @author ramiloid
 */
public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Contact Ivan = new Contact();
        System.out.println(Ivan.toString());
        
        ContactAdvancedWithOrganization Alexey = new ContactAdvancedWithOrganization();
        System.out.println(Alexey.toString());
        
        ContactComplete Artem = new ContactComplete();
        System.out.println(Artem.toString());

    }
    
}
