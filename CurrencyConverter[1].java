import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrencyConverter extends JFrame implements ActionListener {
    private JTextField t1, t2;
    private JComboBox<String> fromCurrency, toCurrency;
    private JButton convertButton;

    public CurrencyConverter() {
        // Frame settings
        setTitle("Currency Converter");
        setSize(600, 400);
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null); // Center on screen

        // Title
        JLabel titleLabel = new JLabel("Currency Converter");
        titleLabel.setFont(new Font("Roboto", Font.BOLD, 36));
        addComponent(titleLabel, 0, 0, 2, 1, GridBagConstraints.CENTER);

        // From Currency
        fromCurrency = new JComboBox<>(new String[]{"USD", "INR", "EUR", "GBP","KWD","AUD","CAD","NZD","HKD","CHF"});
        addComponent(new JLabel("From:"), 0, 1, 1, 1, GridBagConstraints.WEST);
        addComponent(fromCurrency, 1, 1, 1, 1, GridBagConstraints.EAST);

        // Amount
        t1 = new JTextField(10);
        addComponent(new JLabel("Amount:"), 0, 2, 1, 1, GridBagConstraints.WEST);
        addComponent(t1, 1, 2, 1, 1, GridBagConstraints.EAST);

        // To Currency
        toCurrency = new JComboBox<>(new String[]{"USD", "INR", "EUR", "GBP","KWD","AUD","CAD","NZD","HKD","CHF"});
        addComponent(new JLabel("To:"), 0, 3, 1, 1, GridBagConstraints.WEST);
        addComponent(toCurrency, 1, 3, 1, 1, GridBagConstraints.EAST);

        // Converted Amount
        t2 = new JTextField(10);
        t2.setEditable(false);
        addComponent(new JLabel("Converted Amount:"), 0, 4, 1, 1, GridBagConstraints.WEST);
        addComponent(t2, 1, 4, 1, 1, GridBagConstraints.EAST);

        // Convert Button
        convertButton = new JButton("Convert");
        convertButton.addActionListener(this);
        addComponent(convertButton, 0, 5, 2, 1, GridBagConstraints.CENTER);

        setVisible(true);
    }

    private void addComponent(Component component, int gridx, int gridy, int gridwidth, int gridheight, int anchor) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = anchor;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(component, gbc);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double amount = Double.parseDouble(t1.getText());
            String from = (String) fromCurrency.getSelectedItem();
            String to = (String) toCurrency.getSelectedItem();
            double convertedAmount = convertCurrency(amount, from, to);
            t2.setText(String.format("%.4f", convertedAmount)); // Format to 2 decimal places
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input, please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public double convertCurrency(double amount, String from, String to) {
        double rate = 1.0;

        // Currency conversion rates
        if (from.equals("USD")) 
        {
            if (to.equals("INR")) rate = 83.62;
            else if (to.equals("EUR")) rate = 0.90;
            else if (to.equals("GBP")) rate = 0.75;
            else if (to.equals("KWD")) rate = 0.30;
            else if (to.equals("AUD")) rate = 1.47;
            else if (to.equals("CAD")) rate = 1.34;
            else if (to.equals("NZD")) rate = 1.57;
            else if (to.equals("HKD")) rate = 7.82;
            else if (to.equals("CHF")) rate = 0.89;
        } 
        else if (from.equals("INR")) 
        {
            if (to.equals("USD")) rate = 0.012;
            else if (to.equals("EUR")) rate = 0.011;
            else if (to.equals("GBP")) rate = 0.009;
            else if (to.equals("KWD")) rate = 0.0036;
            else if (to.equals("AUD")) rate = 0.017;
            else if (to.equals("CAD")) rate = 0.016;
            else if (to.equals("NZD")) rate = 0.019;
            else if (to.equals("HKD")) rate = 0.13;
            else if (to.equals("CHF")) rate = 0.011;
        }
         else if (from.equals("EUR"))
        {
            if (to.equals("USD")) rate = 1.12;
            else if (to.equals("INR")) rate = 93.30;
            else if (to.equals("GBP")) rate = 0.84;
            else if (to.equals("KWD")) rate = 0.34;
            else if (to.equals("AUD")) rate = 1.64;
            else if (to.equals("CAD")) rate = 1.45;
            else if (to.equals("NZD")) rate = 1.76;
            else if (to.equals("HKD")) rate = 8.75;
            else if (to.equals("CHF")) rate = 0.96;
        }
         else if (from.equals("GBP"))
        {
            if (to.equals("USD")) rate = 1.33;
            else if (to.equals("INR")) rate = 111.03;
            else if (to.equals("EUR")) rate = 1.19;
            else if (to.equals("KWD")) rate = 0.40;
            else if (to.equals("AUD")) rate = 1.95;
            else if (to.equals("CAD")) rate = 1.70;
            else if (to.equals("NZD")) rate = 2.05;
            else if (to.equals("HKD")) rate = 10.38;
            else if (to.equals("CHF")) rate = 1.10;
        }
        else if (from.equals("KWD"))
          {
            if (to.equals("USD")) rate = 3.28;
            else if (to.equals("INR")) rate = 274.07;
            else if (to.equals("EUR")) rate = 2.94;
            else if (to.equals("GBP")) rate = 2.47;
            else if (to.equals("AUD")) rate = 4.80;
            else if (to.equals("CAD")) rate = 4.42;
            else if (to.equals("NZD")) rate = 5.16;
            else if (to.equals("HKD")) rate = 25.63;
            else if (to.equals("CHF")) rate = 2.92;
          }
          else if (from.equals("AUD"))
        {
            if (to.equals("USD")) rate = 0.68;
            else if (to.equals("INR")) rate = 57.05;
            else if (to.equals("EUR")) rate = 0.61;
            else if (to.equals("KWD")) rate = 0.21;
            else if (to.equals("GBP")) rate = 0.51;
            else if (to.equals("CAD")) rate = 0.90;
            else if (to.equals("NZD")) rate = 1.07;
            else if (to.equals("HKD")) rate = 5.31;
            else if (to.equals("CHF")) rate = 0.60;
        }
        else if (from.equals("CAD"))
        {
            if (to.equals("USD")) rate = 0.75;
            else if (to.equals("INR")) rate = 61.71;
            else if (to.equals("EUR")) rate = 0.66;
            else if (to.equals("KWD")) rate = 0.22;
            else if (to.equals("AUD")) rate = 1.08;
            else if (to.equals("GBP")) rate = 0.56;
            else if (to.equals("NZD")) rate = 1.17;
            else if (to.equals("HKD")) rate = 5.82;
            else if (to.equals("CHF")) rate = 0.67;
        }
        else if (from.equals("NZD"))
        {
            if (to.equals("USD")) rate = 0.60;
            else if (to.equals("INR")) rate = 52.25;
            else if (to.equals("EUR")) rate = 0.56;
            else if (to.equals("KWD")) rate = 0.19;
            else if (to.equals("AUD")) rate = 0.92;
            else if (to.equals("CAD")) rate = 0.90;
            else if (to.equals("GBP")) rate = 0.47;
            else if (to.equals("HKD")) rate = 5.31;
            else if (to.equals("CHF")) rate = 0.60;
        }
        else if (from.equals("HKD"))
        {
            if (to.equals("USD")) rate = 0.13;
            else if (to.equals("INR")) rate = 10.73;
            else if (to.equals("EUR")) rate = 0.11;
            else if (to.equals("KWD")) rate = 0.039;
            else if (to.equals("AUD")) rate = 0.19;
            else if (to.equals("CAD")) rate = 0.17;
            else if (to.equals("NZD")) rate = 0.19;
            else if (to.equals("GBP")) rate = 0.097;
            else if (to.equals("CHF")) rate = 0.11;
        }
        else if (from.equals("CHF"))
        {
            if (to.equals("USD")) rate = 1.12;
            else if (to.equals("INR")) rate = 98.68;
            else if (to.equals("EUR")) rate = 1.06;
            else if (to.equals("KWD")) rate = 0.36;
            else if (to.equals("AUD")) rate = 1.73;
            else if (to.equals("CAD")) rate = 1.45;
            else if (to.equals("NZD")) rate = 1.76;
            else if (to.equals("HKD")) rate = 8.75;
            else if (to.equals("GBP")) rate = 0.89;
        }


        return amount * rate;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CurrencyConverter::new);
    }
}