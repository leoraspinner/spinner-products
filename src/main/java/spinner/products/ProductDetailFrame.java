package spinner.products;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class ProductDetailFrame extends JFrame
{
    private Product product;

    public ProductDetailFrame(Product product) {
        this.product = product;

        setTitle(product.title);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout(10, 10));

        //image panel
        JPanel imagePanel = new JPanel(new BorderLayout());
        try {
            URL url = new URL(product.thumbnail);
            Image image = ImageIO.read(url);
            Image scaledImage = image.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
            imagePanel.add(imageLabel, BorderLayout.CENTER);
        } catch (IOException e) {
            imagePanel.add(new JLabel("Error loading image"), BorderLayout.CENTER);
        }

        //detail panel
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Title: " + product.title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel priceLabel = new JLabel(String.format("Price: $%.2f", product.price));
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel idLabel = new JLabel("Product ID: " + product.id);

        detailsPanel.add(titleLabel);
        detailsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        detailsPanel.add(priceLabel);
        detailsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        detailsPanel.add(idLabel);

        add(imagePanel, BorderLayout.CENTER);
        add(detailsPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);

        if (product.description != null && !product.description.isEmpty()) {
            JTextArea descriptionArea = new JTextArea(product.description);
            descriptionArea.setWrapStyleWord(true);
            descriptionArea.setLineWrap(true);
            descriptionArea.setEditable(false);
            descriptionArea.setBackground(detailsPanel.getBackground());
            descriptionArea.setFont(new Font("Arial", Font.PLAIN, 14));

            JScrollPane scrollPane = new JScrollPane(descriptionArea);
            scrollPane.setPreferredSize(new Dimension(600, 150));

            detailsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            detailsPanel.add(new JLabel("Description:"));
            detailsPanel.add(scrollPane);
        }
    }


}
