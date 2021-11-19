package Business;
import Controller.ProdutoController;
import Model.ProdutoModel;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;


public class ProdutoBusiness {
    ProdutoController produtoController = new ProdutoController();
    private static String url = "jdbc:mysql://localhost:3306/bancodedados";
    private static String user = "root";
    private static String password = "qwe123";


    public static void main(String[] args) throws SQLException {
        //listarProdutos();
        //cadastrarProdutos();
        //listarProdutos();
        criarTabela();

    }

    public static void criarTabela(){
        String sql = "CREATE TABLE IF NOT EXISTS Usuarios(IDUsuario int,NomeUsuario varchar(255));";

        try {
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela de Usuários criada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void listarProdutos() {
        String QUERY = "SELECT * FROM produtos";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(QUERY);
            ResultSet rs = stmt.executeQuery(QUERY);


            while (rs.next()) {
                System.out.println("O produto é: " + rs.getString("Nome"));
                System.out.println("E custa: " +rs.getBigDecimal("Preço")+"\n");

            }

        }
        catch(SQLException e){

        }
        }
    public static void cadastrarProdutos() {

        Scanner sc1 = new Scanner(System.in);

                    //Tentando e falhando em receber inputs externos

       /* System.out.println("Insira o nome do produto que quer adicionar a tabela");
        produto1.setNome(sc1.nextLine());
        System.out.println("Insira o valor do produto que quer adicionar a tabela");
        produto1.setPreço(sc1.nextBigDecimal());
        String QUERY = "INSERT INTO produtos VALUES (produto1.getNome(), produto1.getPreço())";
        */

        String QUERY = "INSERT INTO produtos VALUES ('Fanta', 7.00)";

        try{
            Connection conn = DriverManager.getConnection(url,user,password);


            PreparedStatement stmt = conn.prepareStatement(QUERY);
            stmt.executeUpdate(QUERY);

            conn.close();


        }
        catch(SQLException e){
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}



