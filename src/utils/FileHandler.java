package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileHandler<T> {
	public void salvarArquivo(List<T> conteudo, String nomeArquivoPredefinido) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar Arquivo");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos de Texto (.txt)", "txt"));

        fileChooser.setSelectedFile(new File(nomeArquivoPredefinido));

        int resultado = fileChooser.showSaveDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File arquivoSelecionado = fileChooser.getSelectedFile();

            if (!arquivoSelecionado.getName().toLowerCase().endsWith(".txt")) {
                arquivoSelecionado = new File(arquivoSelecionado.getAbsolutePath() + ".txt");
            }

            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoSelecionado))) {
                for (T linha : conteudo) {
                    escritor.write(linha.toString());
                    escritor.newLine();
                }
                JOptionPane.showMessageDialog(null, "Arquivo salvo com sucesso!");
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo.");
            }
        }
    }
}
