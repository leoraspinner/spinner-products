package spinner.products;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

public class ProductsController {
    //takes array of JLabels
    private JLabel [] imagesLabels;
    private ProductsService service;
    private Product[] products;


    public ProductsController(JLabel[] imagesLabels, ProductsService service)
    {
        this.imagesLabels = imagesLabels;
        this.service = service;
    }

    public void display()
    {
        ProductsResponse productsResponse = service.getProducts()
                .blockingGet();
        this.products = productsResponse.products;

        for (int i = 0; i < imagesLabels.length; i++) {
            Product product = products[i];
            try {
                URL url = new URL(product.thumbnail);
                Image image = ImageIO.read(url);
                ImageIcon imageIcon = new ImageIcon(image);
                imagesLabels[i].setIcon(imageIcon);

                //to handle the clicks
                final int index = i;
                imagesLabels[i].addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e)
                    {
                        openProductDetail(products[index]);
                    }
                });

                imagesLabels[i].setCursor(new Cursor(Cursor.HAND_CURSOR));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void openProductDetail(Product product)
    {
        ProductDetailFrame productDetailFrame = new ProductDetailFrame(product);
        productDetailFrame.setVisible(true);
    }


}
