/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg123230027_if.a_latihankuispbo;

import javax.swing.*;
import java.awt.event.*;

public class Pembayaran extends JFrame implements ActionListener {

    JLabel title = new JLabel("Halaman Pembelian");
    JLabel textKategori = new JLabel("Kategori");
    JLabel textjenisDVD = new JLabel();
    JLabel textHarga = new JLabel("Harga");
    JLabel textHargaDVD = new JLabel();
    JLabel textJumlah = new JLabel("Jumlah");
    JFormattedTextField inputJumlah = new JFormattedTextField();
    JButton beli = new JButton("Beli");
    JLabel titleTotalPembelian = new JLabel("Total Pembelian");
    JLabel textHargaSatuan = new JLabel("Harga Satuan");
    JLabel hargaSatuan = new JLabel();
    JLabel textJumlahTotal = new JLabel("Jumlah");
    JLabel jumlahTotal = new JLabel();
    JLabel textPPN = new JLabel("PPN (11%)");
    JLabel PPN = new JLabel();
    JLabel textTotalHarga = new JLabel("Total Harga");
    JLabel totalHarga = new JLabel();
    JButton kembali = new JButton("Kembali");

    private double harga;
    public String Username;

    public Pembayaran (String jenisDVD, double harga, String username) {
        this.harga = harga;
        this.Username = username;

        setVisible(true);
        setSize(720, 600);
        setTitle ("Selamat Datang di Pembelian " + jenisDVD);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setLayout(null);

        add(title);
        add(textKategori);
        add(textjenisDVD);
        textjenisDVD.setText(jenisDVD);
        add(textHarga);
        add(textHargaDVD);
        textHargaDVD.setText("Rp" + harga +"/pcs");
        add(textJumlah);
        add(inputJumlah);
        add(beli);
        add(titleTotalPembelian);
        add(textHargaSatuan);
        add(hargaSatuan);
        add(textJumlahTotal);
        add(jumlahTotal);
        add(textPPN);
        add(PPN);
        add(textTotalHarga);
        add(totalHarga);
        add(kembali);

        title.setBounds(300, 30, 280, 40);

        textKategori.setBounds(200, 90, 100, 30);
        textjenisDVD.setBounds(310, 90, 200, 30);

        textHarga.setBounds(200, 130, 100, 30);
        textHargaDVD.setBounds(310, 130, 200, 30);

        textJumlah.setBounds(200, 170, 100, 30);
        inputJumlah.setBounds(310, 170, 200, 30);

        beli.setBounds(200, 210, 310, 40);

        titleTotalPembelian.setBounds(200, 260, 300, 40);

        textHargaSatuan.setBounds(200, 300, 100, 30);
        hargaSatuan.setBounds(310, 300, 200, 30);
        hargaSatuan.setText("Rp" + harga);

        textJumlahTotal.setBounds(200, 340, 100, 30);
        jumlahTotal.setBounds(310, 340, 200, 30);

        textPPN.setBounds(200, 380, 100, 30);
        PPN.setBounds(310, 380, 200, 30);

        textTotalHarga.setBounds(200, 420, 100, 30);
        totalHarga.setBounds(310, 420, 200, 30);

        kembali.setBounds(200, 460, 310, 40);

        beli.addActionListener(this);
        kembali.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == beli) {
                double jumlah
                        = Double.parseDouble(inputJumlah.getText());

                double totalHarganya = harga * jumlah;
                double pajak = totalHarganya * 0.11;
                double hargaSetelahPajak = totalHarganya
                        + pajak;

                jumlahTotal.setText(jumlah + " pcs");
                PPN.setText("Rp " + pajak);
                totalHarga.setText("Rp "
                        + hargaSetelahPajak);
            } else if (e.getSource() == kembali) {
                new Home(Username);
                this.dispose();
            }

        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Inputjumlah tidak valid!", "Error",JOptionPane.ERROR_MESSAGE);
 }
 }
}
