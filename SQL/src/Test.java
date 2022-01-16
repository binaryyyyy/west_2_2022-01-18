import java.sql.*;

public class Test {

    private static String url="jdbc:mysql://localhost:3306/goods";
    private static String user="root";
    private static String password="root";

    public static void main(String[] args) {
        Order_ order_ = new Order_(10004,1004,"earplug",4399,"2021-12-25 15:15:15");
        /*
        select();
        order_.setOrder_id(10004);
        delete(order_);
        insert(order_);
        */
        update(order_);
    }

    //SELECT
    public static void select(){
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        //获取连接
        try {
            conn = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM order_";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);

            //遍历结果集
            while(rs.next()) {
                String order_id = rs.getString("order_id");
                String id = rs.getString("id");
                String name = rs.getString("name");
                String price = rs.getString("price");
                String time = rs.getString("time");
                Order_ order = new Order_(Integer.parseInt(order_id), Integer.parseInt(id), name, Integer.parseInt(price), time);
                System.out.println(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭conn
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //关闭stat
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //关闭rs
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //DELETE
    public static void delete(Order_ order_){
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        PreparedStatement ps = null;
        //获取连接
        try {
            conn = DriverManager.getConnection(url, user, password);
            String sql = "DELETE FROM order_ WHERE order_id=?;";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, order_.getOrder_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭conn
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //关闭ps
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //INSERT
    public static void insert(Order_ order_){
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        PreparedStatement ps = null;
        //获取连接
        try {
            conn = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO `order_`(order_id,id,name,price,time) VALUE(?,?,?,?,?);";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, order_.getOrder_id());
            ps.setInt(2,order_.getId());
            ps.setString(3,order_.getName());
            ps.setInt(4,order_.getPrice());
            ps.setString(5,order_.getTime());
            ps.executeUpdate();
            sql = "INSERT INTO `goods_`(id,name,price) VALUE(?,?,?);";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,order_.getId());
            ps.setString(2,order_.getName());
            ps.setInt(3,order_.getPrice());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭conn
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //关闭ps
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //UPDATE
    public static void update(Order_ order_){
        //加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //获取数据库连接
        Connection conn = null;
        PreparedStatement stat = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            //操作数据库
            String sql = "update order_ set order_id=?,name=?,price=?,time=? where id=?";
            stat = conn.prepareStatement(sql);
            stat.setInt(1, order_.getOrder_id());
            stat.setString(2, order_.getName());
            stat.setInt(3, order_.getPrice());
            stat.setString(4, order_.getTime());
            stat.setInt(5,order_.getId());
            stat.executeUpdate();
            sql = "update goods_ set name=?,price=? where id=?";
            stat = conn.prepareStatement(sql);
            stat.setString(1, order_.getName());
            stat.setInt(2, order_.getPrice());
            stat.setInt(3,order_.getId());
            stat.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            if(stat!=null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            //关闭连接
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
