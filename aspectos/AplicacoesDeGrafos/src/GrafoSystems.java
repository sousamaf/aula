import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;


public class GrafoSystems extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JFileChooser chooser = null;
	Leitura leitura = null;

	
	public GrafoSystems() {
		
		//janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 728);
		setUndecorated(true);
		getContentPane().setLayout(new BorderLayout(0,0));
		
		chooser = new JFileChooser("C:\\Users\\Alex Prado\\Documents");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
		chooser.setFileFilter(filter);
		
		leitura = new Leitura();
		
		
		//JPanel sentando no ContentPane
		JPanel painel = new JPanel();
		painel.setLayout(null);
		setContentPane(painel);
		//JPanel2 setando no painel
		JPanel painel2 = new JPanel();
		painel2.setBackground(new Color(0, 0, 0, 0));
		painel2.setBounds(0, 0, 1366, 728);
		painel2.setLayout(null);
		painel.add(painel2);
		
		//**botao minimizar e fechar**//
        //botao minimizar
        JButton minimizar = new JButton();
        minimizar.setIcon(new ImageIcon(getClass().getResource("imagens/minimizar1.png")));
        minimizar.setPressedIcon(new ImageIcon(getClass().getResource("imagens/minimizar2.png")));
        minimizar.setBackground(new Color(255, 140, 0));
        minimizar.setBounds(1295, 7, 24, 25);
        minimizar.setContentAreaFilled(false);//remove fundo do butao azul quando clik
        minimizar.setBorderPainted(false);
        painel.add(minimizar);
        //metodo minimizar janela
        minimizar.addActionListener(new ActionListener() { //Tratamento do Evento do bot�o.
			public void actionPerformed(ActionEvent arg0) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
        //botao fechar janela
        JButton fechar = new JButton();
        fechar.setIcon(new ImageIcon(getClass().getResource("imagens/fechar1.png")));
        fechar.setPressedIcon(new ImageIcon(getClass().getResource("imagens/fechar2.png")));
        fechar.setBackground(new Color(255, 140, 0));
        fechar.setBounds(1327, 7, 25, 25);
        fechar.setContentAreaFilled(false);//remove fundo do butao azul quando clik  
        fechar.setFocusPainted(false);
        fechar.setBorderPainted(false);
        painel.add(fechar);
        //metodo fechar janela
        fechar.addActionListener(new ActionListener() { //Tratamento do Evento do bot�o.
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
        
        //botao gerar arquivo
        JButton gerarAquivo = new JButton();
        gerarAquivo.setIcon(new ImageIcon(getClass().getResource("imagens/gerarArquivo1.png")));
        gerarAquivo.setPressedIcon(new ImageIcon(getClass().getResource("imagens/gerarArquivo2.png")));
        gerarAquivo.setBackground(new Color(255, 140, 0));
        gerarAquivo.setBounds(25, 84, 336, 40);
        gerarAquivo.setContentAreaFilled(false);//remove fundo do butao azul quando clik  
        gerarAquivo.setFocusPainted(false);
        gerarAquivo.setBorderPainted(false);
        painel.add(gerarAquivo);
        gerarAquivo.addActionListener(new ActionListener() { //Tratamento do Evento do bot�o.
			public void actionPerformed(ActionEvent arg0) {
				new GeraArquivo();
			}
		});
        
        //botao carregar arquivo
        JButton carregarAquivo = new JButton();
        carregarAquivo.setIcon(new ImageIcon(getClass().getResource("imagens/carregarArquivo1.png")));
        carregarAquivo.setPressedIcon(new ImageIcon(getClass().getResource("imagens/carregarArquivo2.png")));
        carregarAquivo.setBackground(new Color(255, 140, 0));
        carregarAquivo.setBounds(25, 130, 336, 40);
        carregarAquivo.setContentAreaFilled(false);//remove fundo do butao azul quando clik  
        carregarAquivo.setFocusPainted(false);
        carregarAquivo.setBorderPainted(false);
        painel.add(carregarAquivo);
        //metodo fechar janela
        carregarAquivo.addActionListener(new ActionListener() { //Tratamento do Evento do bot�o.
			public void actionPerformed(ActionEvent arg0) {
				int returnVal = chooser.showOpenDialog(getParent());
				if(returnVal == JFileChooser.APPROVE_OPTION)
				{
					leitura.leia(chooser.getSelectedFile().getAbsolutePath());
					new Interface(leitura.arrayVertice, leitura.arrayAdj, leitura.arrayCusto);
				}
			}
		});
        
        //botao processar
        JButton processar = new JButton();
        processar.setIcon(new ImageIcon(getClass().getResource("imagens/processar1.png")));
        processar.setPressedIcon(new ImageIcon(getClass().getResource("imagens/processar2.png")));
        processar.setBackground(new Color(255, 140, 0));
        processar.setBounds(150, 631, 200, 55);
        processar.setContentAreaFilled(false);//remove fundo do butao azul quando clik  
        processar.setFocusPainted(false);
        processar.setBorderPainted(false);
        painel.add(processar);
        //metodo fechar janela
        processar.addActionListener(new ActionListener() { //Tratamento do Evento do bot�o.
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
        
        //op��es de Busca
        JLabel jlAlgoritmo = new JLabel("Algor�tmo: ");
        jlAlgoritmo.setBounds(70, 260, 65, 14);
        jlAlgoritmo.setForeground(Color.WHITE);
        painel.add(jlAlgoritmo);
        
        JComboBox cbxAlgoritmo = new JComboBox();
        cbxAlgoritmo.setBounds(170, 257, 100, 20);
        cbxAlgoritmo.setModel(new DefaultComboBoxModel(new String[] {"-Selecione-", "Dijkstra", "Bellman-Ford"}));
        painel.add(cbxAlgoritmo);
        
        JLabel jlNos = new JLabel("N�s: ");
        jlNos.setBounds(70, 340, 65, 14);
        jlNos.setForeground(Color.WHITE);
        painel.add(jlNos);
        
        JLabel jlOrigem = new JLabel("Origem: ");
        jlOrigem.setBounds(120, 325, 65, 14);
        jlOrigem.setForeground(Color.WHITE);
        painel.add(jlOrigem);
        
        JTextField txtOrigem = new JTextField();
        txtOrigem.setBounds(170, 323, 100, 20);
        painel.add(txtOrigem);
        
        JLabel jlDestino = new JLabel("Destino: ");
        jlDestino.setBounds(119, 355, 65, 14);
        jlDestino.setForeground(Color.WHITE);
        painel.add(jlDestino);
        
        JTextField txtDestino = new JTextField();
        txtDestino.setBounds(170, 353, 100, 20);
        painel.add(txtDestino);
        
        JLabel jlMetrica = new JLabel("M�trica: ");
        jlMetrica.setBounds(70, 420, 65, 14);
        jlMetrica.setForeground(Color.WHITE);
        painel.add(jlMetrica);
        
        JComboBox cbxMetrica = new JComboBox();
        cbxMetrica.setBounds(170, 418, 100, 20);
        cbxMetrica.setModel(new DefaultComboBoxModel(new String[] {"Custo", "Saltos"}));
        painel.add(cbxMetrica);
        
        //imagem de fundo das opcoes
		Container container2 = getContentPane();
		JLabel fundoOpcoes = new JLabel();
		fundoOpcoes.setBounds(25, 190, 336, 295);
		fundoOpcoes.setIcon(new ImageIcon(getClass().getResource("imagens/fundoOpcoes.png")));
		container2.add(fundoOpcoes);
		
        //imagem de fundo da janela
		Container container = getContentPane();
		JLabel FundoImagem = new JLabel();
		FundoImagem.setBounds(0, 0, 1366, 728);
		FundoImagem.setIcon(new ImageIcon(getClass().getResource("imagens/telaFundo.png")));
		container.add(FundoImagem);
				
		
		
		setVisible(true);
				
	}

}
