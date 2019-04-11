package BL;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

public class UserModel extends AbstractListModel{

    private ArrayList<User> users = new ArrayList<>();
    
    @Override
    public int getSize() {
        return users.size();
    }

    @Override
    public Object getElementAt(int idx) {
        return users.get(idx);
    }
    
    public void add(User user){
        users.add(user);
        fireIntervalAdded(this, users.size()-1, users.size()-1);
    }
   

}
