import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroAlunoGUI extends JFrame {

    private JTextField tfNome, tfEndereco, tfIdade;
    private JButton btnOk, btnLimpar, btnMostrar, btnSair;
    private List<Aluno> listaAlunos;

    public CadastroAlunoGUI() {
        super("Cadastro de Alunos");
        listaAlunos = new ArrayList<>();

        // Layout
        setLayout(new GridLayout(5, 2, 5, 5));

        // Campos
        add(new JLabel("Nome:"));
        tfNome = new JTextField();
        add(tfNome);

        add(new JLabel("Endereço:"));
        tfEndereco = new JTextField();
        add(tfEndereco);

        add(new JLabel("Idade:"));
        tfIdade = new JTextField();
        add(tfIdade);

        // Botões
        btnOk = new JButton("OK");
        btnLimpar = new JButton("Limpar");
        btnMostrar = new JButton("Mostrar");
        btnSair = new JButton("Sair");

        add(btnOk);
        add(btnLimpar);
        add(btnMostrar);
        add(btnSair);

        // Eventos
        btnOk.addActionListener(e -> adicionarAluno());
        btnLimpar.addActionListener(e -> limparCampos());
        btnMostrar.addActionListener(e -> mostrarAlunos());
        btnSair.addActionListener(e -> System.exit(0));

        // Configuração da janela
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void adicionarAluno() {
        String nome = tfNome.getText();
        String endereco = tfEndereco.getText();
        int idade;

        try {
            idade = Integer.parseInt(tfIdade.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Idade inválida!");
            return;
        }

        Aluno aluno = new Aluno(nome, endereco, idade);
        listaAlunos.add(aluno);

        JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!");
        limparCampos();
    }

    private void limparCampos() {
        tfNome.setText("");
        tfEndereco.setText("");
        tfIdade.setText("");
    }

    private void mostrarAlunos() {
        if (listaAlunos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum aluno cadastrado!");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Aluno a : listaAlunos) {
            sb.append("ID: ").append(a.getUuid())
              .append(" | Nome: ").append(a.getNome())
              .append("\n");
        }

        JOptionPane.showMessageDialog(this, sb.toString());
    }

    public static void main(String[] args) {
        new CadastroAlunoGUI();
    }
}
