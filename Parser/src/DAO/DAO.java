package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DAO {

    public DAO() {
    }

    public void addDataToDocument(List<Document> documents) {

        PreparedStatement ps = null;
        Connection connection = null;

        try {

            connection = new MSSQLConnection().getMSSQLConnection();
            connection.setAutoCommit(false);

            for (int i = 0; i < documents.size(); i++) {
                ps = connection.prepareStatement("INSERT INTO Document(DocumentTitle, DocumnetAuthor, DocumentExtension, DocumentText, DocumentDate) "
                        + "VALUES( ?, ?, ?, ?, ? );");
                ps.setString(1, documents.get(i).getTitle());
                ps.setString(2, documents.get(i).getAuthor());
                ps.setString(3, documents.get(i).getExtension());
                ps.setString(4, documents.get(i).getText());
                ps.setString(5, documents.get(i).getDate());
                ps.addBatch();
                int[] updateCounts = ps.executeBatch();
            }

            connection.commit();
            connection.close();
        }
        catch (SQLException ignore) {
//            System.out.println("Connection hasn't created");
            ignore.printStackTrace();
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            }
            catch (SQLException ignore) {
                System.out.println("Connection hasn't closed");
                ignore.printStackTrace();
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            }
            catch (SQLException ignore) {
                System.out.println("PraparedStatemen hasn't completed");
                ignore.printStackTrace();
            }
        }
    }

    public void addDataToTerm(List<Term> terms) {

        PreparedStatement ps = null;
        Connection connection = null;

        try {

            connection = new MSSQLConnection().getMSSQLConnection();
            connection.setAutoCommit(false);

            for (int i = 0; i < terms.size(); i++) {
                ps = connection.prepareStatement("INSERT INTO Term(TermStem, TermDF) "
                        + "VALUES( ?, ?);");
                ps.setString(1, terms.get(i).getStem());
                ps.setInt(2, terms.get(i).getDf());
                ps.addBatch();
                int[] updateCounts = ps.executeBatch();
            }

            connection.commit();
            connection.close();
        }
        catch (SQLException ignore) {
//            System.out.println("Connection hasn't created");
            ignore.printStackTrace();
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            }
            catch (SQLException ignore) {
                System.out.println("Connection hasn't closed");
                ignore.printStackTrace();
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            }
            catch (SQLException ignore) {
                System.out.println("PraparedStatemen hasn't completed");
                ignore.printStackTrace();
            }
        }
    }

    public void addTermToTTerm(Term term) {

        PreparedStatement ps = null;
        Connection connection = null;

        try {

            connection = new MSSQLConnection().getMSSQLConnection();

            ps = connection.prepareStatement("INSERT INTO Term(TermStem, TermDF) VALUES( ?, ? );");
            ps.setString(1, term.getStem());
            ps.setInt(2, term.getDf());
            
            ps.executeUpdate();
            connection.close();
        }
        catch (SQLException ignore) {
//            System.out.println("Connection hasn't created");
            ignore.printStackTrace();
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            }
            catch (SQLException ignore) {
                System.out.println("Connection hasn't closed");
                ignore.printStackTrace();
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            }
            catch (SQLException ignore) {
                System.out.println("PraparedStatemen hasn't completed");
                ignore.printStackTrace();
            }
        }
    }

    public void addDocumentToTDocument(Document document) {

        PreparedStatement ps = null;
        Connection connection = null;

        try {

            connection = new MSSQLConnection().getMSSQLConnection();
            
            ps = connection.prepareStatement("INSERT INTO Document(DocumentTitle, DocumnetAuthor, DocumentExtension, DocumentText, DocumentDate) "
                    + "VALUES( ?, ?, ?, ?, ? );");
            ps.setString(1, document.getTitle());
            ps.setString(2, document.getAuthor());
            ps.setString(3, document.getExtension());
            ps.setString(4, document.getText());
            ps.setString(5, document.getDate());
            
            ps.executeUpdate();
            connection.close();
        }
        catch (SQLException ignore) {
//            System.out.println("Connection hasn't created");
            ignore.printStackTrace();
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            }
            catch (SQLException ignore) {
                System.out.println("Connection hasn't closed");
                ignore.printStackTrace();
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            }
            catch (SQLException ignore) {
                System.out.println("PraparedStatemen hasn't completed");
                ignore.printStackTrace();
            }
        }
    }

}
