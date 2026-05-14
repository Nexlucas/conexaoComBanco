import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JFrame tela = new JFrame("Tela de Cadrastro");

        tela.setSize(500, 400);
        tela.setLayout(null);

        JLabel labelnome = new JLabel("Nome");
        labelnome.setBounds(20,50,150,40);
        tela.add(labelnome);

        JTextField nome = new JTextField();
        nome.setBounds(20,80,250,40);
        tela.add(nome);

        JLabel labelemail = new JLabel("E-mail");
        labelemail.setBounds(20,120,150,40);
        tela.add(labelemail);

        JTextField email = new JTextField();
        email.setBounds(20,150,250,40);
        tela.add(email);

        JButton enviar = new JButton("Enviar");
        enviar.setBounds(80,200,150,40);
        tela.add(enviar);

        enviar.addActionListener(actionEvent -> {
            String sql = "INSERT INTO usuario(nome, email) VALUES (?, ?)";
            String nomeCompleto = nome.getText();
            String emailUsuario = email.getText();

            try {

                PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
                ps.setString(1,nomeCompleto);
                ps.setString(2,emailUsuario);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null,"Usuário calvo com sucesso!");
                ps.close();


            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        tela.setVisible(true);
    }
}