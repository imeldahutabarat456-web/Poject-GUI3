/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.KRSController;
import model.*;
import javax.swing.*;

import javax.swing.table.DefaultTableModel;
/**
 *
 * @author IMELDA
 */
public class InputNilai extends javax.swing.JFrame {
    
    private final Controller.KRSController krsController;
    private final DefaultComboBoxModel<Student> comboModelStudent = new DefaultComboBoxModel<>();  
    private final DefaultComboBoxModel<Course> comboModelCourse = new DefaultComboBoxModel<>();
    private final DefaultComboBoxModel<String> ComboModelSemester = new DefaultComboBoxModel<>();
    private final DefaultComboBoxModel<Lecturer> comboModelLecturer = new DefaultComboBoxModel<>();   
   
    // Variabel global penampung data aktif yang dipilih user
    private Student selectedStudent;
    private Course selectedCourse;
    private KRS krs;
    private Lecturer selectedLecturer;
    /**
     * Creates new form ImputNilai
     */
    public InputNilai() {
       krsController = new KRSController();
        initComponents();
        initData();
        tampilDataKeTabel();
        
    }
    

    private void initData() {
    
    // Tambahkan 2 baris ini agar NIM & Prodi tidak bisa diketik manual
    jTextField1.setEditable(false);
    jTextField6.setEditable(false);
    jTextField5.setEditable(false);

        for (int i = 1; i <= 8; i++) {
    ComboModelSemester.addElement("Semester " + i);
}
        
        // 2. Mengisi Data Tiruan Mahasiswa
        comboModelStudent.addElement(new Student("111", "2515101028","Imelda", "Ilmu Komputer"));
        comboModelStudent.addElement(new Student("112", "2511021029","Laudya" ,"Sistem Informasi"));
        
        // 3. Mengisi Data Tiruan Mata Kuliah
       comboModelCourse.addElement(new Course("MK01", "Pemrograman Objek", 3, "3"));
       comboModelCourse.addElement(new Course("MK02", "Arsitektur dan Komputer", 2, "3"));
       comboModelCourse.addElement(new Course("MK03", "Agama Kristen", 2, "1"));
       comboModelCourse.addElement(new Course("MK04", "Pancasila", 4, "3"));
       comboModelCourse.addElement(new Course("MK05", "Matematika", 3, "6"));
       comboModelCourse.addElement(new Course("MK06", "Komunikasi", 3, "4"));
       comboModelCourse.addElement(new Course("MK08", "Matematika", 3, "1"));
       comboModelCourse.addElement(new Course("MK09", "Kalkulus", 3, "2"));
        // 4. Mengisi Data Tiruan Dosenss
        comboModelLecturer.addElement(new Lecturer("D01", "Ketut Agus Seputra, M.T.", "081923", "Software Engineering"));
        comboModelLecturer.addElement(new Lecturer("D02", "wahyu a, M.T.", "081945", "Komunikasi Data"));
        
        jComboBox1.setModel(comboModelStudent);
        jComboBox2.setModel(comboModelCourse);
        jComboBox3.setModel(ComboModelSemester);
        jComboBox4.setModel(comboModelLecturer);
        
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);
        jComboBox2.addActionListener(this::jComboBox2ActionPerformed);
        jComboBox3.addActionListener(this::jComboBox3ActionPerformed);
        
        selectedStudent = (Student) jComboBox1.getSelectedItem();

if(selectedStudent != null){
    jTextField1.setText(selectedStudent.getNim());
    jTextField6.setText(selectedStudent.getProdi());
}
}
  
        

    // Fungsi membaca data dari MySQL database dan menampilkannya ke JTable visual
 private void tampilDataKeTabel() {
     DefaultTableModel model = (DefaultTableModel) tableNilai.getModel();
        model.setRowCount(0);
       var listKrs = krsController.getKrsDao().ambilSemua();
    if (listKrs != null) {
        for (KRS k : listKrs) {
         Object[] rowData = new Object[5];


        rowData[0] = k.getStudent().getNama();
        rowData[1] = k.getCourse().getNamaMK();
        rowData[2] = k.getSemester();
        rowData[3] = k.getNilaiAkhir();
        rowData[4] = k.getNilaiHuruf();
        model.addRow(rowData);
        }
    }
    
}
    private void hitungKRS() {
        try {
            double sikap = Double.parseDouble(jTextField2.getText().isEmpty() ? "0" : jTextField2.getText());
            double uts = Double.parseDouble(jTextField3.getText().isEmpty() ? "0" : jTextField3.getText());
            double uas = Double.parseDouble(jTextField4.getText().isEmpty() ? "0" : jTextField4.getText());
            
            String semester = (String) jComboBox3.getSelectedItem();
            selectedStudent = (Student) jComboBox1.getSelectedItem();
            selectedCourse = (Course) jComboBox2.getSelectedItem();
           
            if (selectedStudent != null && selectedCourse != null) {
                // Rumus kalkulasi otomatis objek model KRS
                this.krs = new KRS(selectedStudent, selectedCourse, semester, sikap, uts, uas);
                jTextField5.setText(krs.getNilaiHuruf());
            }
        } catch (NumberFormatException e) {
            jTextField5.setText("-");
          
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableNilai = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Form Informasi Mahasiswa");

        jLabel2.setText("Identitas Mahasiswa");

        jLabel3.setText("Nama");

        jLabel4.setText("NIM");

        jComboBox1.setModel(comboModelStudent);

        jTextField1.addActionListener(this::jTextField1ActionPerformed);

        jLabel14.setText("Prodi");

        jTextField6.addActionListener(this::jTextField6ActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel14))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField6)
                            .addComponent(jTextField1)
                            .addComponent(jComboBox1, 0, 123, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel5.setText("Informasi Mahasiswa");

        jLabel6.setText("MataKuliah");

        jLabel7.setText("Kode dan SKS");

        jLabel8.setText("Semester");

        jLabel9.setText("Dosen");

        jLabel10.setText("Nilai");

        jTextField2.addActionListener(this::jTextField2ActionPerformed);

        jLabel13.setText("Nilai Huruf");

        jTextField3.addActionListener(this::jTextField3ActionPerformed);

        jTextField5.addActionListener(this::jTextField5ActionPerformed);

        jComboBox2.setModel(comboModelCourse);

        jComboBox3.setModel(ComboModelSemester);

        jComboBox4.setModel(comboModelLecturer);
        jComboBox4.addActionListener(this::jComboBox4ActionPerformed);

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(this::btnSimpanActionPerformed);

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(this::btnUbahActionPerformed);

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(this::btnHapusActionPerformed);

        btnBatal.setText("Batal");
        btnBatal.addActionListener(this::btnBatalActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(75, 75, 75)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(131, 131, 131)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(143, 143, 143)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox3, 0, 116, Short.MAX_VALUE)
                            .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnSimpan)
                        .addGap(31, 31, 31)
                        .addComponent(btnUbah)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBatal))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal))
                .addGap(51, 51, 51))
        );

        tableNilai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mahasiswa", "MataKuliah", "Semester", "Nilai Akhir", "Huruf"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableNilai);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(216, 216, 216))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jComboBox1ActionPerformed(
            java.awt.event.ActionEvent evt) {

    selectedStudent =
            (Student) jComboBox1.getSelectedItem();

   if(selectedStudent != null){
        System.out.println(selectedStudent.getNim());
        System.out.println(selectedStudent.getProdi());

        jTextField1.setText(selectedStudent.getNim());
        jTextField6.setText(selectedStudent.getProdi());
    }
}
    

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
      selectedCourse = (Course) jComboBox2.getSelectedItem();
        if (selectedCourse != null) {
            jLabel7.setText("Kode: " + selectedCourse.getKode() + " | SKS: " + selectedCourse.getSks());
        }  // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed


    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        selectedCourse = (Course) jComboBox2.getSelectedItem();
        if (selectedCourse != null) {
            jLabel7.setText("Kode: " + selectedCourse.getKode() + " | SKS: " + selectedCourse.getSks());
            hitungKRS();
        }
    }
    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt ) {                                           
        hitungKRS();
    }                                          
    
    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
hitungKRS(); // Hitung ulang memastikan data tersinkronisasi
       
    // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
hitungKRS();
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
     hitungKRS();
     if (krs != null) {
        System.out.println("===== DATA YANG AKAN DISIMPAN =====");
        System.out.println("NIM       : " + krs.getStudent().getNim());
        System.out.println("Nama      : " + krs.getStudent().getNama());
        System.out.println("Kode MK   : " + krs.getCourse().getKode());
        System.out.println("MK        : " + krs.getCourse().getNamaMK());
        System.out.println("Semester  : " + krs.getSemester());
        System.out.println("Nilai     : " + krs.getNilaiAkhir());
        System.out.println("Huruf     : " + krs.getNilaiHuruf());
        System.out.println("===============================");

         boolean sukses = krsController.simpanDataNilai(this, this.krs);
        
        if (sukses) {
            // 3. Refresh tabel agar data baru muncul
            tampilDataKeTabel();
            // 4. Bersihkan form agar siap untuk input berikutnya
            bersihkanForm();
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke database!");
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan ke database.");
        }
         System.out.println(krs.getNilaiAkhir());
    System.out.println(krs.getNilaiHuruf());
    }
       
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
    selectedLecturer = (Lecturer) jComboBox4.getSelectedItem();
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
      int row = tableNilai.getSelectedRow();
    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Pilih baris di tabel untuk menghapus!");
        return;
    }
    var listKrs = krsController.getKrsDao().ambilSemua(); 
    KRS dataTerpilih = listKrs.get(row);
    
    String nim = dataTerpilih.getStudent().getNim();
    String kodeMk = dataTerpilih.getCourse().getKode();
    
    int confirm = JOptionPane.showConfirmDialog(this, "Hapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {
        // Pastikan controller Anda menerima parameter yang sesuai (NIM dan Kode MK)
        if (krsController.hapusDataNilai(nim, kodeMk)) {
            tampilDataKeTabel();
            bersihkanForm();
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menghapus data!");
        }
    }
    
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
      jTextField2.setText(""); jTextField3.setText("");
        jTextField4.setText(""); jTextField5.setText(""); 
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        int row = tableNilai.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang akan diubah!");
            return;
        }
        
        hitungKRS(); // Hitung ulang data dari input form
        if (krs != null) {
            // Pastikan method updateDataNilai ada di KRSController Anda
            if (krsController.updateDataNilai(this, this.krs)) {
                tampilDataKeTabel();
                bersihkanForm();
                JOptionPane.showMessageDialog(this, "Data berhasil diubah!");
            }
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    public static void main(String args[]) {
      
    java.awt.EventQueue.invokeLater(() -> {
        new InputNilai().setVisible(true);
    });
} 
    private void bersihkanForm() {
    jTextField2.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
    jTextField5.setText("");
    tableNilai.clearSelection();
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<Student> jComboBox1;
    private javax.swing.JComboBox<Course> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<Lecturer> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTable tableNilai;
    // End of variables declaration//GEN-END:variables
}