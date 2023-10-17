import org.h2.util.JSR310Utils;

import java.sql.DriverManager;
import java.sql.*;

public class CRUD {

    public static final String create_table = "CREATE TABLE EMPLOYEE8(empid INTEGER, empname varchar2(50), empsalary NUMBER)";
    public static final String insert_data1 = "INSERT INTO EMPLOYEE8 VALUES(1, 'a', '100')";
    public static final String insert_data2 = "INSERT INTO EMPLOYEE8 VALUES(2, 'b', '200')";
    public static final String insert_data3 = "INSERT INTO EMPLOYEE8 VALUES(3, 'c', '300')";
    public static final String update_data = "UPDATE EMPLOYEE8 SET empname='d' WHERE empid=1";
    public static final String delete_data = "DELETE FROM EMPLOYEE8 WHERE empsalary=100";
    public static final String display_data = "SELECT * FROM EMPLOYEE8";

    public static void main(String [] args)
    {
        try(Connection conn = DriverManager.getConnection("jdbc:h2:./db", "sa", ""))
        {
            Statement st = conn.createStatement();
            st.execute(create_table);

            st.executeUpdate(insert_data1);
            st.executeUpdate(insert_data2);
            st.executeUpdate(insert_data3);

            ResultSet rs = st.executeQuery(display_data);
            int i = 0;
            while (rs.next())
            {
                System.out.println("My Emp "+ i++ +" ID:-"+rs.getInt("empId")+"\t"+"NAME:-"
                        +rs.getString(2)
                        +" salary:-"+ rs.getFloat(3));

            }

            int count = st.executeUpdate(update_data);
            System.out.println(count+"rows affected");

            ResultSet resultSet1=st.executeQuery(display_data);
            int k=1;
            while (resultSet1.next())
            {
                System.out.println("My Emp "+k++ +" ID:-"+resultSet1.getInt("empId")+"\t"+"NAME:-"
                        +resultSet1.getString(2)
                        +" salary:-"+ resultSet1.getFloat(3));

            }

            count = st.executeUpdate(delete_data);
            System.out.println(count+"rows affected");

            ResultSet resultSet2=st.executeQuery(display_data);
            int j=1;
            while (resultSet2.next())
            {
                System.out.println("My Emp "+j++ +" ID:-"+resultSet2.getInt("empId")+"\t"+"NAME:-"
                        +resultSet2.getString(2)
                        +" salary:-"+ resultSet2.getFloat(3));
            }


        }
        catch(SQLException se){
            System.out.println(se.getMessage());
        }
    }
}
