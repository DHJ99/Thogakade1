package thogakadePOS;

import model.Customer;
import java.util.*;

public class DBConnection {
    private static DBConnection instance;
    private List<Customer> connection;


    private DBConnection(){
        connection = new ArrayList<>();
    }

    public List<Customer> getConnection(){
        return connection;
    }

    public static DBConnection getInstance (){
        return null==instance?instance = new DBConnection():instance;
    }
}
