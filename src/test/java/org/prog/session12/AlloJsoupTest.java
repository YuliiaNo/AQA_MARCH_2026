package org.prog.session12;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.annotations.*;

import java.io.IOException;
import java.sql.*;

public class AlloJsoupTest {

    private Connection connection;

    @BeforeSuite
    public void beforeSuite() throws SQLException {

        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db",
                "root",
                "password"
        );

        Statement statement = connection.createStatement();

        statement.execute(
                "CREATE TABLE IF NOT EXISTS allo_ua_goods (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY," +
                        "product_code VARCHAR(255)," +
                        "product_name VARCHAR(500)" +
                        ")"
        );
    }

    @Test
    public void alloTest() throws IOException, SQLException {

        // load allo.ua
        Document document = Jsoup.connect(
                "https://allo.ua/ua/products/mobile/proizvoditel-apple/"
        ).get();

        // find products
        Elements products = document.select(".product-card");

        int limit = 3;

        for (int i = 0; i < limit; i++) {

            Element product = products.get(i);

            // get name
            String productName = product
                    .select(".product-card__title")
                    .text();

            // get product link
            String productLink = product
                    .select("a")
                    .attr("href");

            // open product page
            Document productDocument =
                    Jsoup.connect(productLink).get();

            // get product code
            String productCode = productDocument
                    .select("[itemprop=sku]")
                    .text();

            System.out.println(productName);
            System.out.println(productCode);

            // check exists
            PreparedStatement checkStatement =
                    connection.prepareStatement(
                            "SELECT COUNT(*) FROM allo_ua_goods " +
                                    "WHERE product_code=? AND product_name=?"
                    );

            checkStatement.setString(1, productCode);
            checkStatement.setString(2, productName);

            ResultSet rs = checkStatement.executeQuery();

            int count = 0;

            if (rs.next()) {
                count = rs.getInt(1);
            }

            // insert if not exists
            if (count == 0) {

                PreparedStatement insertStatement =
                        connection.prepareStatement(
                                "INSERT INTO allo_ua_goods " +
                                        "(product_code, product_name) " +
                                        "VALUES (?, ?)"
                        );

                insertStatement.setString(1, productCode);
                insertStatement.setString(2, productName);

                insertStatement.execute();

                System.out.println("Inserted");
            } else {
                System.out.println("Already exists");
            }
        }
    }

    @AfterSuite
    public void afterSuite() throws SQLException {

        connection.close();
    }
}