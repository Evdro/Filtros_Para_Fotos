package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main extends JFrame implements ActionListener{


    JButton btnImagen, btnHsv, btnHsl;
    JTextField hue, saturacion, valor;
    JTextField matiz, saturation, brillo;

    //Botones Rgb
    JButton btnRojo, btnVerde, btnAzul;
    //Botones Cmy
    JButton btnCyan, btnMagenta, btnAmarillo;

    JLabel Imagen,rgb,cmy,hsv,hsl;
    panelBotonesPrincipal panelbotonesP = new panelBotonesPrincipal(this);
    panelBotonesRgb panelbotonesS = new panelBotonesRgb(this);
    ImagenEditar imageneditar = new ImagenEditar();

    panelHSV panelhsv = new panelHSV(this);
    panelHsl panelhsl = new panelHsl(this);

    Main() {
        super("Formatos de color");
        setBounds(600, 600, 600, 600);
        setVisible(true);
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);

        Container contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelSuperior.add(panelbotonesP);

        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new BorderLayout());
        panelCentro.add(imageneditar, BorderLayout.CENTER);
        contenedor.add(panelSuperior, BorderLayout.NORTH);
        contenedor.add(panelCentro, BorderLayout.CENTER);

        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelIzquierdo.add(panelbotonesS);

        panelBotonesCmy panelbotonescmy = new panelBotonesCmy(this);
        panelIzquierdo.add(panelbotonescmy);
        contenedor.add(panelIzquierdo, BorderLayout.EAST);

        panelHSV panelhsv = new panelHSV(this);
        panelIzquierdo.add(panelhsv);
        contenedor.add(panelIzquierdo, BorderLayout.EAST);

        panelHsl panelhsl = new panelHsl(this);
        panelIzquierdo.add(panelhsl);
        contenedor.add(panelIzquierdo, BorderLayout.EAST);

    }

    public static void main(String[] args) {
        Main ventana = new Main();

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnImagen) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                JOptionPane.showMessageDialog(null, "archivo seleccionado" + selectedFile.getAbsolutePath());
                ImageIcon imagen = new ImageIcon(selectedFile.getAbsolutePath());
                Imagen.setIcon(imagen);
            }
        } else if (e.getSource() == btnRojo) {
            Icon icon = Imagen.getIcon();
            if (icon instanceof ImageIcon) {
                Image img = ((ImageIcon) icon).getImage();
                BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = bufferedImage.createGraphics();
                g2d.drawImage(img, 0, 0, null);
                g2d.dispose();

                int filtroRojo = 100; // intensidad de color rojo

                for (int y = 0; y < bufferedImage.getHeight(); y++) {
                    for (int x = 0; x < bufferedImage.getWidth(); x++) {
                        int rgb = bufferedImage.getRGB(x, y);
                        int r = (rgb >> 16) & 0xFF; // Componente rojo
                        int g = (rgb >> 8) & 0xFF;  // Componente verde
                        int b = rgb & 0xFF;         // Componente azul

                        r = Math.min(255, r + filtroRojo);

                        int nuevoRgb = (r << 16) | (g << 8) | b;
                        bufferedImage.setRGB(x, y, nuevoRgb);
                    }
                }

                ImageIcon modifiedIcon = new ImageIcon(bufferedImage);
                Imagen.setIcon(modifiedIcon);
            }

        } else if (e.getSource() == btnVerde) {
            Icon icon = Imagen.getIcon();
            if (icon instanceof ImageIcon) {
                Image img = ((ImageIcon) icon).getImage();
                BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = bufferedImage.createGraphics();
                g2d.drawImage(img, 0, 0, null);
                g2d.dispose();

                int filtroVerde = 100; // intensidad de color verde

                for (int y = 0; y < bufferedImage.getHeight(); y++) {
                    for (int x = 0; x < bufferedImage.getWidth(); x++) {
                        int rgb = bufferedImage.getRGB(x, y);
                        int r = (rgb >> 16) & 0xFF; // Componente rojo
                        int g = (rgb >> 8) & 0xFF;  // Componente verde
                        int b = rgb & 0xFF;         // Componente azul

                        g = Math.min(255, g + filtroVerde);

                        int nuevoRgb = (r << 16) | (g << 8) | b;
                        bufferedImage.setRGB(x, y, nuevoRgb);
                    }
                }

                ImageIcon modifiedIcon = new ImageIcon(bufferedImage);
                Imagen.setIcon(modifiedIcon);
            }

        } else if (e.getSource() == btnAzul) {
            Icon icon = Imagen.getIcon();
            if (icon instanceof ImageIcon) {
                Image img = ((ImageIcon) icon).getImage();
                BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = bufferedImage.createGraphics();
                g2d.drawImage(img, 0, 0, null);
                g2d.dispose();

                int filtroAzul = 100; // Intensidad de color azul

                for (int y = 0; y < bufferedImage.getHeight(); y++) {
                    for (int x = 0; x < bufferedImage.getWidth(); x++) {
                        int rgb = bufferedImage.getRGB(x, y);
                        int r = (rgb >> 16) & 0xFF; // Componente rojo
                        int g = (rgb >> 8) & 0xFF;  // Componente verde
                        int b = rgb & 0xFF;         // Componente azul

                        b = Math.min(255, b + filtroAzul);

                        int nuevoRgb = (r << 16) | (g << 8) | b;
                        bufferedImage.setRGB(x, y, nuevoRgb);
                    }
                }

                ImageIcon modifiedIcon = new ImageIcon(bufferedImage);
                Imagen.setIcon(modifiedIcon);
            }
        } else if (e.getSource() == btnCyan) {
            Icon icon = Imagen.getIcon();
            if (icon instanceof ImageIcon) {
                Image img = ((ImageIcon) icon).getImage();
                BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = bufferedImage.createGraphics();
                g2d.drawImage(img, 0, 0, null);
                g2d.dispose();

                int filtroCyan = 100; //Intensidad de color cyan

                for (int y = 0; y < bufferedImage.getHeight(); y++) {
                    for (int x = 0; x < bufferedImage.getWidth(); x++) {
                        int rgb = bufferedImage.getRGB(x, y);
                        int r = (rgb >> 16) & 0xFF; // Componente rojo
                        int g = (rgb >> 8) & 0xFF;  // Componente verde
                        int b = rgb & 0xFF;         // Componente azul

                        r = Math.min(255, r - filtroCyan);

                        int nuevoRgb = (r << 16) | (g << 8) | b;
                        bufferedImage.setRGB(x, y, nuevoRgb);
                    }
                }
                ImageIcon modifiedIcon = new ImageIcon(bufferedImage);
                Imagen.setIcon(modifiedIcon);
            }
        } else if (e.getSource() == btnMagenta) {
            Icon icon = Imagen.getIcon();
            if (icon instanceof ImageIcon) {
                Image img = ((ImageIcon) icon).getImage();
                BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = bufferedImage.createGraphics();
                g2d.drawImage(img, 0, 0, null);
                g2d.dispose();

                int filtroMagenta = 100; //intensidad de magenta

                for (int y = 0; y < bufferedImage.getHeight(); y++) {
                    for (int x = 0; x < bufferedImage.getWidth(); x++) {
                        int rgb = bufferedImage.getRGB(x, y);
                        int r = (rgb >> 16) & 0xFF; // Componente rojo
                        int g = (rgb >> 8) & 0xFF;  // Componente verde
                        int b = rgb & 0xFF;         // Componente azul

                        g = Math.min(255, g - filtroMagenta);

                        int nuevoRgb = (r << 16) | (g << 8) | b;
                        bufferedImage.setRGB(x, y, nuevoRgb);
                    }
                }

                ImageIcon modifiedIcon = new ImageIcon(bufferedImage);
                Imagen.setIcon(modifiedIcon);
            }
        }else if (e.getSource() == btnAmarillo) {
            Icon icon = Imagen.getIcon();
            if (icon instanceof ImageIcon) {
                Image img = ((ImageIcon) icon).getImage();
                BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = bufferedImage.createGraphics();
                g2d.drawImage(img, 0, 0, null);
                g2d.dispose();

                int filtroAmarillo = 100; // Define la intensidad del filtro amarillo

                for (int y = 0; y < bufferedImage.getHeight(); y++) {
                    for (int x = 0; x < bufferedImage.getWidth(); x++) {
                        int rgb = bufferedImage.getRGB(x, y);
                        int r = (rgb >> 16) & 0xFF; // Componente rojo
                        int g = (rgb >> 8) & 0xFF;  // Componente verde
                        int b = rgb & 0xFF;         // Componente azul

                        b = Math.min(255, b - filtroAmarillo);

                        int nuevoRgb = (r << 16) | (g << 8) | b;
                        bufferedImage.setRGB(x, y, nuevoRgb);
                    }
                }
                ImageIcon modifiedIcon = new ImageIcon(bufferedImage);
                Imagen.setIcon(modifiedIcon);
            }
        } else if (e.getSource() == btnHsv) {
            float Hue = Float.parseFloat(hue.getText());
            float Sat = Float.parseFloat(saturacion.getText());
            float val = Float.parseFloat(valor.getText());

            aplicarFiltroHSV(Hue,Sat,val);

        } else if (e.getSource() == btnHsl) {
            float mat = Float.parseFloat(matiz.getText());
            float sat = Float.parseFloat(saturation.getText());
            float bri = Float.parseFloat(brillo.getText());

            aplicarFiltroHSL(mat,sat,bri);
        }
    }


    public class panelBotonesPrincipal extends JPanel {
        public panelBotonesPrincipal(Main ventanaPrincipal) {
            setLayout(new FlowLayout(FlowLayout.LEFT, 10, 30));

            btnImagen = new JButton("Seleccionar imagen");

            btnImagen.addActionListener(ventanaPrincipal);

            add(btnImagen);

        }
    }

    public class panelBotonesRgb extends JPanel {
        public panelBotonesRgb(Main main) {
            setLayout(new GridLayout(5,1));

            btnRojo = new JButton("Rojo");
            btnVerde = new JButton("Verde");
            btnAzul = new JButton("Azul");
            rgb = new JLabel("Rgb");

            btnRojo.addActionListener(main);
            btnVerde.addActionListener(main);
            btnAzul.addActionListener(main);

            add(rgb);
            add(btnRojo);
            add(btnAzul);
            add(btnVerde);
        }


    }
    public class panelBotonesCmy extends JPanel{
        public panelBotonesCmy(Main main){
            setLayout(new GridLayout(5,1));

            btnCyan = new JButton("Cyan");
            btnMagenta = new JButton("Magenta");
            btnAmarillo = new JButton("Amarillo");
            cmy = new JLabel("Cmy");

            btnCyan.addActionListener(main);
            btnMagenta.addActionListener(main);
            btnAmarillo.addActionListener(main);

            add(cmy);
            add(btnCyan);
            add(btnMagenta);
            add(btnAmarillo);
        }
    }

    public class panelHSV extends JPanel{
        public panelHSV(Main main){
            setLayout(new GridLayout(5,1));

            btnHsv = new JButton("Filtro HSV");
            hsv = new JLabel("Hsv");
            hue = new JTextField("valor hue");
            saturacion = new JTextField("Valor saturacion");
            valor = new JTextField("Ingresa brillo");

            btnHsv.addActionListener(main);

            add(hsv);
            add(hue);
            add(saturacion);
            add(valor);
            add(btnHsv);
        }
    }

    public class panelHsl extends JPanel {
        public panelHsl(Main main){
            setLayout(new GridLayout(5,1));

            btnHsl = new JButton("Filtro Hsl");
            matiz = new JTextField("Valor matiz");
            saturation = new JTextField("Valor saturacion");
            brillo = new JTextField("Valor brillo");
            hsl = new JLabel("Hsl");

            btnHsl.addActionListener(main);

            add(hsl);
            add(matiz);
            add(saturation);
            add(brillo);
            add(btnHsl);
        }
    }
    public class ImagenEditar extends JPanel {
        public ImagenEditar() {
            setBackground(Color.gray);
            setLayout(new BorderLayout());
            Imagen = new JLabel();
            add(Imagen, BorderLayout.CENTER);
        }
    }

    private void aplicarFiltroHSV(float hue, float saturation, float value) {
        Icon icon = Imagen.getIcon();
        if (icon instanceof ImageIcon) {
            Image img = ((ImageIcon) icon).getImage();
            BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = bufferedImage.createGraphics();
            g2d.drawImage(img, 0, 0, null);
            g2d.dispose();

            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                for (int x = 0; x < bufferedImage.getWidth(); x++) {
                    int rgb = bufferedImage.getRGB(x, y);
                    Color colorRGB = new Color(rgb);
                    float[] hsv = new float[3];
                    Color.RGBtoHSB(colorRGB.getRed(), colorRGB.getGreen(), colorRGB.getBlue(), hsv);
                    hsv[0] = hue; // Cambiar el tono
                    hsv[1] = saturation / 100; // Cambiar la saturación
                    hsv[2] = value / 100; // Cambiar el brillo
                    int nuevoRgb = Color.HSBtoRGB(hsv[0], hsv[1], hsv[2]);
                    bufferedImage.setRGB(x, y, nuevoRgb);
                }
            }

            ImageIcon modifiedIcon = new ImageIcon(bufferedImage);
            Imagen.setIcon(modifiedIcon);
        }
    }

    private void aplicarFiltroHSL(float hue, float saturation, float lightness) {
        Icon icon = Imagen.getIcon();
        if (icon instanceof ImageIcon) {
            Image img = ((ImageIcon) icon).getImage();
            BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = bufferedImage.createGraphics();
            g2d.drawImage(img, 0, 0, null);
            g2d.dispose();

            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                for (int x = 0; x < bufferedImage.getWidth(); x++) {
                    int rgb = bufferedImage.getRGB(x, y);
                    Color colorRGB = new Color(rgb);
                    float[] hsl = new float[3];
                    Color.RGBtoHSB(colorRGB.getRed(), colorRGB.getGreen(), colorRGB.getBlue(), hsl);
                    hsl[0] = hue; // Cambiar el matiz
                    hsl[1] = saturation / 100.0f; // Cambiar la saturación
                    hsl[2] = lightness / 100.0f; // Cambiar la luminosidad
                    int nuevoRgb = Color.HSBtoRGB(hsl[0], hsl[1], hsl[2]);
                    bufferedImage.setRGB(x, y, nuevoRgb);
                }
            }

            ImageIcon modifiedIcon = new ImageIcon(bufferedImage);
            Imagen.setIcon(modifiedIcon);
        }
    }
}
