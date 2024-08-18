package jdbc_learning;

import org.testng.annotations.Test;

import java.sql.*;

public class Create_Table {

    @Test
    public void create_A_Table() {
        try {

//            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306", "root", "Myhusband@007");
            //here sonoo is database name, root is username and password
            System.out.println("JDBC connection is successful");
            Statement stmt = con.createStatement();
            //Creating a database
//            stmt.execute("Create database My_School;");
//            stmt.execute("Drop databse My_School;");
            stmt.execute("use employee;");
//            String sql = "CREATE TABLE QA_Table"
//                    + "(id INTEGER not NULL, "
//                    + " firstName VARCHAR(50), "
//                    + " lastName VARCHAR(50), "
//                    + " age INTEGER, "
//                    + " PRIMARY KEY ( id ))";
//
//            String tab1="CREATE TABLE Persons (\n" +
//                    "    PersonID int,\n" +
//                    "    LastName varchar(255),\n" +
//                    "    FirstName varchar(255),\n" +
//                    "    Address varchar(255),\n" +
//                    "    City varchar(255)\n" +
//                    ");";
//            stmt.executeUpdate(sql);
//            stmt.executeUpdate(tab1);
//            System.out.println("Created table in given database...");
//            stmt.close();
//            con.close();
//            System.out.println("Table is Created ...");

            Thread.sleep(5000);

// Create a Table for BANK Employees ..
            stmt.execute("create table BankEmp" +
                    "(" +
                    "EmpId int not null," +
                    "Mobile double," +
                    "FName varchar(50)," +
                    "LName varchar(50)," +
                    "Email varchar(50)," +
                    "State varchar(2)," +
                    "Doj date," +
                    "Vehicle varchar(200)" +
                    ");");

            // Insert Table Data using JDBC  ...
            stmt.execute("Insert into BankEmp(EmpId,Mobile,FName,LName,Email,State,Doj,Vehicle) values (1,6655678987,'Rik','Som','Rik@Som.com','BL','2000-01-01','Car') ,\n" +
                    "(1,6655678987,'Rik','Som','Rik@Som.com','BL','2000-01-01','Car'),\n" +
                    "(2,4445678987,'CAT','MAT','Cat@mat.com','TN','2000-01-02','Bus'),\n" +
                    "(3,6655678222,'BAT','MAN','BAT@MAN.com','PN','2000-01-03','Van'),\n" +
                    "(4,6655678333,'HE','MAN','HE@MAN.com','JK','2000-01-04','Car'),\n" +
                    "(5,6655678444,'SPIDER','MAN','SPIDER@MAN.com','WB','2000-01-05','Bus'),\n" +
                    "(6,6655678555,'TIK','TOK','TIK@TOK.com','BH','2000-01-06','Car'),\n" +
                    "(7,6655678666,'KIT','KAT','KIT@KAT.com','OR','2000-01-07','Van'),\n" +
                    "(8,6655678888,'MIT','ROT','MIT@ROY.com','KR','2000-01-08','Auto'),\n" +
                    "(9,6655699987,'JOY','TOY','Rik@JOY.TOY','JK','2000-01-09','Cat'),\n" +
                    "(10,6650008987,'SAM','Som','SAM@Som.com','KY','2000-01-10','Car');");

            System.out.println("Table Data Addition is Successfull ....");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void read_A_Table() {

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306", "root", "Myhusband@007");
            //here sonoo is database name, root is username and password
            System.out.println("JDBC connection is successful");
            Statement stmt = con.createStatement();
            stmt.execute("use employee;");
            ResultSet result = stmt.executeQuery("select Doj,Email from bankemp where empid=7;");

            while (result.next())
            {

                Date Doj=result.getDate("Doj");
                String Email= result.getString("Email");

                //int emp_ID = result.getInt("EmpId");
                //Double Mo_No = result.getDouble("Mobile");
                //String FirstName = result.getString("FName");
                // String LastName = result.getString("LName");
                // String Email_ID = result.getString("Email");

//                int emp_ID = result.getInt(1);
//                Double Mo_No = result.getDouble(2);
//                String FirstName = result.getString(3);
//                String LastName = result.getString(4);
//                String Email_ID = result.getString(5);

                System.out.println("Email id is: " +Email);
                System.out.println("Doj is: "+ Doj);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

