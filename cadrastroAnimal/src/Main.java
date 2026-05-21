import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
void main() {
    JFrame tela = new JFrame("Tela de Cadrastro");


    tela.setSize(500, 600);
    tela.setLayout(null);

    JLabel labelnome = new JLabel("Nome");
    labelnome.setBounds(20,50,150,40);
    tela.add(labelnome);

    JTextField textnome = new JTextField();
    textnome.setBounds(20,80,250,40);
    tela.add(textnome);

    JLabel labelidade = new JLabel("Idade");
    labelidade.setBounds(20,120,150,40);
    tela.add(labelidade);

    JTextField textidade = new JTextField();
    textidade.setBounds(20,150,250,40);
    tela.add(textidade);


    JLabel labeltipo= new JLabel("Tipo");
    labeltipo.setBounds(20,190,150,40);
    tela.add(labeltipo);

    JComboBox<Tipo> texttipo = new JComboBox<>(Tipo.values());
    texttipo.setBounds(20,220,250,40);
    tela.add(texttipo);

    JLabel labelraca = new JLabel("Raça");
    labelraca.setBounds(20,260,150,40);
    tela.add(labelraca);

    JTextField textraca = new JTextField();
    textraca.setBounds(20,290,250,40);
    tela.add(textraca);

    JLabel labeltelefone = new JLabel("Telefone");
    labeltelefone.setBounds(20,330,150,40);
    tela.add(labeltelefone);

    JTextField texttelefone = new JTextField();
    texttelefone.setBounds(20,360,250,40);
    tela.add(texttelefone);

    JLabel labelendereco = new JLabel("Endereço");
    labelendereco.setBounds(20,400,150,40);
    tela.add(labelendereco);

    JTextField textendereco = new JTextField();
    textendereco.setBounds(20,430,250,40);
    tela.add(textendereco);

    JButton enviar = new JButton("Enviar");
    enviar.setBounds(80,480,150,40);
    tela.add(enviar);

    enviar.addActionListener(actionEvent -> {
        String nome = textnome.getText();
        String idade = textidade.getText();
        String tipo = texttipo.getSelectedItem().toString();
        String raca = textraca.getText();
        String telefone = texttelefone.getText();
        String endereco = textendereco.getText();

        String sql = "INSERT INTO animal(nome, idade, tipo, raca, telefone, endereco) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1,nome);
            ps.setString(2,idade);
            ps.setString(3, tipo);
            ps.setString(4,raca);
            ps.setString(5,telefone);
            ps.setString(6,endereco);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Usuário calvo com sucesso!");
            ps.close();
            conexao.close();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    });

    tela.setVisible(true);

}
