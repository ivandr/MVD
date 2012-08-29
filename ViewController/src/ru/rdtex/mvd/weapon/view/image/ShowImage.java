package ru.rdtex.mvd.weapon.view.image;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.sql.Blob;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.servlet.*;
import javax.servlet.http.*;

import javax.sql.DataSource;

public class ShowImage extends HttpServlet {
    private static final String CONTENT_TYPE = "image/gif; charset=utf-8";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException,
                                                           IOException {
        

        response.setContentType(CONTENT_TYPE);
        String imageId = request.getParameter("id");
        OutputStream os = response.getOutputStream();
        Connection conn = null;
        try {
            Context ctx = new InitialContext();            
            conn = getOracleConnection();
            PreparedStatement statement =
                conn.prepareStatement("SELECT ep_id,photo " +
                                      "FROM ent_photo " +
                                      "WHERE ep_id = ?");
            statement.setInt(1, new Integer(imageId));
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                Blob blob = rs.getBlob("PHOTO");                
                BufferedInputStream in = new BufferedInputStream(blob.getBinaryStream());
                int b;
                byte[] buffer = new byte[10240];
                while ((b = in.read(buffer, 0, 10240)) != -1) {
                    os.write(buffer, 0, b);
                }
                os.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException sqle) {
                System.out.println("SQLException error");
            }
        }
    }
    public static Connection getOracleConnection() throws Exception {
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@d1601.rdtex.msk.ru:1521:LRR";
      String username = "lrr";
      String password = "lrr";

      Class.forName(driver); // load Oracle driver
      Connection conn = DriverManager.getConnection(url, username, password);
      return conn;
    }

}
