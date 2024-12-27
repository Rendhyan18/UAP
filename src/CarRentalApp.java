import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class CarRentalApp {
    private final JFrame frame;
    private final JTable carTable;
    private final DefaultTableModel tableModel;
    private final List<Car> carList = new ArrayList<>();

    public CarRentalApp() {
        // Initialize GUI components
        frame = new JFrame("Car Rental Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Panel for table
        JPanel tablePanel = new JPanel(new BorderLayout());

        // Table model and table
        tableModel = new DefaultTableModel(new Object[]{"ID", "Brand", "Model", "Price", "Image"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        carTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(carTable);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("Add Car");
        JButton updateButton = new JButton("Update Car");
        JButton deleteButton = new JButton("Delete Car");
        JButton viewButton = new JButton("View Image");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(viewButton);

        // Add panels to frame
        frame.add(tablePanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCar();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCar();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCar();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewImage();
            }
        });

        frame.setVisible(true);
    }

    private void addCar() { //CRUD (Menambahkan Mobil)
        JTextField idField = new JTextField();
        JTextField brandField = new JTextField();
        JTextField modelField = new JTextField();
        JTextField priceField = new JTextField();
        JFileChooser fileChooser = new JFileChooser();

        int option = JOptionPane.showConfirmDialog(frame, new Object[]{"ID:", idField, "Brand:", brandField, "Model:", modelField, "Price:", priceField, "Select Image:", fileChooser},
                "Add Car", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            try { //Exception Handling
                String id = idField.getText();
                String brand = brandField.getText();
                String model = modelField.getText();
                double price = Double.parseDouble(priceField.getText());
                File selectedFile = fileChooser.getSelectedFile();
                ImageIcon image = new ImageIcon(selectedFile.getAbsolutePath());

                Car car = new Car(brand, model, price, image);
                carList.add(car);
                tableModel.addRow(new Object[]{id, brand, model, price, "Image Added"});
            } catch (NumberFormatException ex) {
                //Menangani Kesalahan jika menginput harga bukan angka
                JOptionPane.showMessageDialog(frame, "Price must be a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                //Menangani Kesalahan lain yang tidak terduga
                JOptionPane.showMessageDialog(frame, "Failed to add car: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateCar() { //CRUD (MengUpdate Mobil)
        int selectedRow = carTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(frame, "Select a car to update", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Car car = carList.get(selectedRow);

        JTextField brandField = new JTextField(car.getBrand());
        JTextField modelField = new JTextField(car.getModel());
        JTextField priceField = new JTextField(String.valueOf(car.getPrice()));
        JFileChooser fileChooser = new JFileChooser();

        int option = JOptionPane.showConfirmDialog(frame, new Object[]{"Brand:", brandField, "Model:", modelField, "Price:", priceField, "Update Image:", fileChooser},
                "Update Car", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            try { //Exception Handling
                car.setBrand(brandField.getText());
                car.setModel(modelField.getText());
                car.setPrice(Double.parseDouble(priceField.getText()));
                File selectedFile = fileChooser.getSelectedFile();
                if (selectedFile != null) {
                    car.setImage(new ImageIcon(selectedFile.getAbsolutePath()));
                }
                //Memperbarui Tabel
                tableModel.setValueAt(car.getBrand(), selectedRow, 1);
                tableModel.setValueAt(car.getModel(), selectedRow, 2);
                tableModel.setValueAt(car.getPrice(), selectedRow, 3);
            } catch (NumberFormatException ex) {
                //Menangani Kesalahan jika harga bukan angka
                JOptionPane.showMessageDialog(frame, "Price must be a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                //Menangani kesalahan lain yang tidak terduga
                JOptionPane.showMessageDialog(frame, "Failed to update car: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void deleteCar() { //CRUD (Menghapus Mobil)
        int selectedRow = carTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(frame, "Select a car to delete", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int option = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this car?", "Confirm Delete", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            carList.remove(selectedRow);
            tableModel.removeRow(selectedRow);
        }
    }

    private void viewImage() { //CRUD (Melihat Gambar Mobil)
        int selectedRow = carTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(frame, "Select a car to view image", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Car car = carList.get(selectedRow);
        JLabel imageLabel = new JLabel(car.getImage());
        JOptionPane.showMessageDialog(frame, imageLabel, "Car Image", JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CarRentalApp::new);
    }
}