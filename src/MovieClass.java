import java.sql.*;
import java.util.Scanner;

public class MovieClass {
	
	public static void main(String[] args)
	{
		try
		{
		//Creating a new Sqlite database named MovieDatabase and connecting to it
		Class.forName("org.sqlite.JDBC");
		Connection con = DriverManager.getConnection("jdbc:sqlite:MovieDatabase.db");
		
		//Creating the table Movie
		Statement s = con.createStatement();
		String sql1 = "create table Movie(Name text,Actor text,Actress text,Director text,YearOfRelease int)";
		int rn1 = s.executeUpdate(sql1);
		System.out.println(rn1);
		
		//Inserting values into Movie table
		String sql2 = "insert into Movie values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql2);
		
		Scanner sc= new Scanner(System.in);
		
		ps.setString(1, sc.next());
		ps.setString(2, sc.next());
		ps.setString(3, sc.next());
		ps.setString(4, sc.next());
		ps.setInt(5, sc.nextInt());
		
		int rn2 = ps.executeUpdate();
		//System.out.println(rn2);
		
		//Querying all the rows from Movie table
		String sql3 = "select * from Movie";
		PreparedStatement ps1 = con.prepareStatement(sql3);
		ResultSet rs = ps1.executeQuery();
		
		//Printing all the values of each row of Movie table
		System.out.println("Name\tActor\tActress\tDirector Year_Of_Release");
		while(rs.next())
		{
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
		}
		
		//Querying all the rows whose Actor is "Jake" from Movie table
		String sql4 = "select * from Movie where Actor=?";
		PreparedStatement ps2 = con.prepareStatement(sql4);
		
		
		ps2.setString(1, sc.next());
		ResultSet rs2 = ps2.executeQuery();
		
		//Printing all the values of each row of Movie table
		System.out.println("\nName\tActor\tActress\tDirector Year_Of_Release");
		while(rs2.next())
		{
			System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)+"\t"+rs2.getString(4)+"\t"+rs2.getString(5));
		}
				
		con.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
