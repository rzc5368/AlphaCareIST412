package alphacare;

/**
 *
 * @author Rodrigo
 */
public class hcControl { 

    private final hcView healthCareUI;
    final hcModel dataListModel;   
         

    public hcControl() {

        dataListModel = new hcModel();
        healthCareUI = new hcView(this);
        healthCareUI.setVisible(true);
 
    }
}
