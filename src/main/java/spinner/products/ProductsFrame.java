package spinner.products;

import javax.swing.*;
import java.awt.*;

public class ProductsFrame extends JFrame {
    //build the frame in grid layout
    private JLabel[] labels = new JLabel[9];
    private ProductsController controller;

    public ProductsFrame()
    {
        setTitle("Products");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);

        setLayout(new GridLayout(3, 3));
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
            add(labels[i]);
        }

        controller = new ProductsController(labels, new ProductsServiceFactory().create());
        controller.display();
    }


    public static void main(String[] args) {
        ProductsFrame frame = new ProductsFrame();
        frame.setVisible(true);
    }
}
