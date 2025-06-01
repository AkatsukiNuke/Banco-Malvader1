package Main;

import util.DataBaseConnection;
import java.sql.Connection;
import javax.swing.JOptionPane;
import view.AutentificacaoView;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Estabelecendo a conexão com o banco de dados
            conn = DataBaseConnection.getConnection();
            if (conn != null) {
                JOptionPane.showMessageDialog(null, "Conexão bem-sucedida com o banco de dados!");

                // Inicia a tela de autenticação após a conexão bem-sucedida
                AutentificacaoView autenticacaoView = new AutentificacaoView()  ;
                autenticacaoView.setVisible(true);  // Torna a tela visível para o usuário
            } else {
                JOptionPane.showMessageDialog(null, "Falha na conexão com o banco de dados.");
            }
        } finally {
            // Usando o método desconectar da classe DataBaseConnection para fechar a conexão
            DataBaseConnection.desconectar(conn);
        }
    }
}
