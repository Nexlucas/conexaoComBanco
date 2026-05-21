import javax.swing.*;
import java.sql.PreparedStatement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    JFrame tela = new JFrame("Tela de Cadrastro");


    tela.setSize(500, 600);
    tela.setLayout(null);

    JLabel labelnome = new JLabel("Nome");
    labelnome.setBounds(20,50,150,40);
    tela.add(labelnome);

    JTextField nome = new JTextField();
    nome.setBounds(20,80,250,40);
    tela.add(nome);

    JLabel labelidade = new JLabel("Idade");
    labelidade.setBounds(20,120,150,40);
    tela.add(labelidade);

    JTextField idade = new JTextField();
    idade.setBounds(20,150,250,40);
    tela.add(idade);

    JLabel labeltipo = new JLabel("Tipo ex(cachorro, gato, papagaio, chinchila)");
    labeltipo.setBounds(20,190,150,40);
    tela.add(labeltipo);

    JTextField tipo = new JTextField();
    tipo.setBounds(20,220,250,40);
    tela.add(tipo);

    JLabel labelraca = new JLabel("Raça");
    labelraca.setBounds(20,260,150,40);
    tela.add(labelraca);

    JTextField raca = new JTextField();
    raca.setBounds(20,290,250,40);
    tela.add(raca);

    JLabel labeltelefone = new JLabel("Telefone");
    labeltelefone.setBounds(20,330,150,40);
    tela.add(labeltelefone);

    JTextField telefone = new JTextField();
    telefone.setBounds(20,360,250,40);
    tela.add(telefone);

    JLabel labelendereco = new JLabel("Endereço");
    labelendereco.setBounds(20,400,150,40);
    tela.add(labelendereco);

    JTextField endereco = new JTextField();
    endereco.setBounds(20,430,250,40);
    tela.add(endereco);

    JButton enviar = new JButton("Enviar");
    enviar.setBounds(80,480,150,40);
    tela.add(enviar);

    enviar.addActionListener(actionEvent -> {
        String sql = "INSERT INTO adocao(nome, idade, tipo, raca, telefone, endereco) VALUES (?, ?, ?, ?, ?, ?)";
        String nomeCompleto = nome.getText();
        int idadeUsuario = Integer.parseInt(idade.getText());
        String tipoUsuario = tipo.getText();
        String racaUsuario = raca.getText();
        int telefoneUsuario = Integer.parseInt(telefone.getText());
        String enderecoUsuario = endereco.getText();

        try {

            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setString(1,nomeCompleto);
            ps.setInt(2,idadeUsuario);
            ps.setString(3,tipoUsuario);
            ps.setString(4,racaUsuario);
            ps.setInt(5,telefoneUsuario);
            ps.setString(6,enderecoUsuario);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,"Usuário calvo com sucesso!");
            ps.close();


        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    });

    tela.setVisible(true);

}
