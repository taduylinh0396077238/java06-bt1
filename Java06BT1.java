import java.sql.*;

public class Java06BT1 {
    public static void main(String[] args) {
        // Bước 1 : Allocate a database 'Connection' object ::: Phân bổ đối tượng 'Kết nối' cơ sở dữ liệu
        // Bước 2: Phân bổ đối tượng 'Statement' trong Connection
        // Bước 3 & 4: Thực thi câu lệnh SQL INSERT | DELETE thông qua executeUpdate (),
        // trả về một int cho biết số hàng bị ảnh hưởng.
        // XÓA các bản ghi có id> = 3000 và id <4000
        // INSERT a record : CHÈN bản ghi
        // INSERT multiple records : chèn nhiều bản ghi
        // INSERT a partial record : chèn 1 phần bản ghi
        // Issue a SELECT to check the changes : Đưa ra một CHỌN để kiểm tra các thay đổi


try(
        //Bước 1 : Phân bổ dối tượng kết nối
        Connection bt = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");
        // Bước 2: Phân bổ đối tượng 'Statement' trong Connection
        Statement stml = bt.createStatement();
        ) {
        //Bước 3-4 Thực Thi câu lệnh INSERT \ DELETE thông qua executeUpdate()
        // trả về một int cho biết số hàng bị ảnh hưởng.

//        Xóa bản ghi có id > 8000

        String sqlDelete = "delete  from books where id >8000";
        System.out.println("The SQL stametn" + sqlDelete + "\n");
        int countDelete = stml.executeUpdate(sqlDelete);
        System.out.println(countDelete + "hồ sơ bị xóa" + "\n");

//        Thêm 2 bản ghi

        String sqlInsert = "insert  into  books value" + "(8001,'Java Core ', 'Dang Kim Thi',15.55,55)," + "(8002,'Java Advanced', 'Duy Linh',25.55,55)";
        System.out.println("The SQL stament " + sqlInsert + "\n");
        int countInsert = stml.executeUpdate(sqlInsert);
        System.out.println(countInsert + "hồ sơ đc thêm ");

//        Thêm 1 cuốn thông tin
        sqlInsert = "insert into books (id , title, author) value  (2001,'Java JDBC MYSQL  ', 'ThiDH')";
        System.out.println("The SQL stament" + sqlInsert + "\n");
        countInsert = stml.executeUpdate(sqlInsert);
        System.out.println(countInsert + "hồ sơ đc thêm ");

//    4 xóa cuốn sách có id do người dùng nhập vào

        sqlDelete = "delete from books where  id = 2001 ";
        System.out.println("The SQL stament " + sqlDelete + "\n");
        countDelete = stml.executeUpdate(sqlDelete);
        System.out.println(countDelete + "xóa hồ sơ" + "\n");



    String slect = "select * from books";
    System.out.println("The SQL stament" + slect + "\n");
    ResultSet rset = stml.executeQuery(slect);

    while (rset.next()){
        System.out.println( rset.getString("id") + ","
                + rset.getString("author") + ","
                + rset.getString("title") + ","
                + rset.getDouble("price") + ","
                + rset.getInt("qty")
        );
    }




} catch (SQLException e) {
    e.printStackTrace();
}
    }
}
