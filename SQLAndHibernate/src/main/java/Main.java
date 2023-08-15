import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "testtest";
        try{
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select course_name, \n" +
                    "(count(month(subscription_date))/ max(month(subscription_date)))\n" +
                    "as avgCounts from\n" +
                    "purchaseList \n" +
                    "where year(subscription_date) = 2018\n" +
                    "group by  course_name");
            while (resultSet.next()){
                String courseName = resultSet.getString("course_name");
                Float avgCount = resultSet.getFloat("avgCounts");
                System.out.println(courseName + " - " +  avgCount);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
