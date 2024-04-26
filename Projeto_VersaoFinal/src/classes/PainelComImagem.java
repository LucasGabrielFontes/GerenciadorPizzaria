package classes;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PainelComImagem extends JPanel {
    
    private Image imagemDeFundo;

    public PainelComImagem(String caminhoDaImagem) {
        try {
            imagemDeFundo = ImageIO.read(new File(caminhoDaImagem));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagemDeFundo, 0, 0, this);
    }
    
}
