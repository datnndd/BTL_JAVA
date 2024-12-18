package view;

import entity.Member;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;
import java.util.List;

public class GymManagerView extends JFrame implements ActionListener, ListSelectionListener {
    @Serial
    private static final long serialVersionUID = 1L;
    private JRadioButton rdbtnMan;
    private JRadioButton rdbtnWoman;
    private JPanel contentPane;
    private JComboBox<String> cbMemberCardSearch;
    private JTextField tfNameSearch;
    private JButton btnSearch;
    private JButton btnShowOriginal;
    private JTextField tfMemberID;
    private JTextField tfMemberName;
    private JTextField tfAge;
    private ButtonGroup buttonGender;
    private JTextField tfPhoneNumber;
    private JTextField tfAddress;
    private JComboBox<String> cbMemberCard;

    private String[] columnsName = new String[] {"IDMember", "Name",  "Age", "Gender", "Phone", "Address", "MemberCard"};
    private Object data = new Object[][] {};
    private JScrollPane jScrollPaneMemberTable;
    private JTable memberTable;
    private JButton btnEdit;
    private JButton btnCancel;
    private JButton btnAdd;
    private JButton btnDelete;

    public GymManagerView(){
        initComponents();
    }

    private void initComponents(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        pack();
        setBounds(100, 100, 933, 620);

        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel filterLabel = new JLabel("Member Filter");
        filterLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
        filterLabel.setBounds(10, 5, 200, 25);
        contentPane.add(filterLabel);

        JLabel idMemberLabel_search = new JLabel("Member Card:");
        idMemberLabel_search.setFont(new Font("Tahoma", Font.PLAIN, 20));
        idMemberLabel_search.setBounds(10, 40, 150, 22);
        contentPane.add(idMemberLabel_search);
        cbMemberCardSearch = new JComboBox<>();
        String[] memberCards = {"Silver", "Gold", "Premium"};
        cbMemberCardSearch.addItem("");
        for (String memberCard : memberCards) {
            cbMemberCardSearch.addItem(memberCard);
        }
        cbMemberCardSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
        cbMemberCardSearch.setBounds(150, 40, 200, 22);
        contentPane.add(cbMemberCardSearch);

        JLabel nameLabel_search = new JLabel("Name: ");
        nameLabel_search.setFont(new Font("Tahoma", Font.PLAIN, 20));
        nameLabel_search.setBounds(370, 40, 120, 22);
        contentPane.add(nameLabel_search);
        tfNameSearch = new JTextField();
        tfNameSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfNameSearch.setBounds(440, 40, 120, 22);
        tfNameSearch.setColumns(10);
        contentPane.add(tfNameSearch);

        btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnSearch.setBounds(600, 40, 100, 22);
        contentPane.add(btnSearch);

        btnShowOriginal = new JButton("Show Original");
        btnShowOriginal.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnShowOriginal.setBounds(700, 40, 180, 22);
        contentPane.add(btnShowOriginal);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 65, 898, 13);
        contentPane.add(separator);

        JLabel memberListLabel = new JLabel("Member List");
        memberListLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
        memberListLabel.setBounds(10, 80, 150, 25);
        contentPane.add(memberListLabel);

        jScrollPaneMemberTable = new JScrollPane();
        memberTable = new JTable();
        memberTable.setFont(new Font("Tahoma", Font.PLAIN, 18));
        memberTable.setModel(new DefaultTableModel((Object[][]) data, columnsName));
        memberTable.setRowHeight(25);
        jScrollPaneMemberTable.setViewportView(memberTable);
        jScrollPaneMemberTable.setBounds(10, 110, 898, 214);
        contentPane.add(jScrollPaneMemberTable);

        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(10, 340, 898, 13);
        contentPane.add(separator_2);

        JLabel informationFieldLabel = new JLabel("Member Information");
        informationFieldLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
        informationFieldLabel.setBounds(10, 350, 250, 25);
        contentPane.add(informationFieldLabel);

        JLabel lblMemberID = new JLabel("Member ID:");
        lblMemberID.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMemberID.setBounds(10, 380, 130, 22);
        contentPane.add(lblMemberID);
        tfMemberID = new JTextField();
        tfMemberID.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfMemberID.setBounds(150, 380, 130, 22);
        contentPane.add(tfMemberID);

        JLabel lblMemberName = new JLabel("Member Name:");
        lblMemberName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMemberName.setBounds(10, 410, 180, 22);
        contentPane.add(lblMemberName);
        tfMemberName = new JTextField();
        tfMemberName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfMemberName.setBounds(158, 410, 240, 22);
        contentPane.add(tfMemberName);

        JLabel lblAge = new JLabel("Age:");
        lblAge.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblAge.setBounds(10, 440, 180, 22);
        contentPane.add(lblAge);
        tfAge = new JTextField();
        tfAge.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfAge.setBounds(150, 440, 150, 22);
        contentPane.add(tfAge);

        JLabel lblGender = new JLabel("Gender:");
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblGender.setBounds(10, 470, 180, 22);
        contentPane.add(lblGender);
        rdbtnMan = new JRadioButton("Man");
        rdbtnMan.setFont(new Font("Tahoma", Font.PLAIN, 20));
        rdbtnMan.setBounds(120, 470, 100, 22);
        contentPane.add(rdbtnMan);
        rdbtnWoman = new JRadioButton("Woman");
        rdbtnWoman.setFont(new Font("Tahoma", Font.PLAIN, 20));
        rdbtnWoman.setBounds(220, 470, 150, 22);
        contentPane.add(rdbtnWoman);
        buttonGender = new ButtonGroup();
        buttonGender.add(rdbtnMan);
        buttonGender.add(rdbtnWoman);

        JLabel lblPhoneNumber = new JLabel("Phone Number:");
        lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPhoneNumber.setBounds(479, 380, 220, 22);
        contentPane.add(lblPhoneNumber);
        tfPhoneNumber = new JTextField();
        tfPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfPhoneNumber.setBounds(642, 380, 220, 22);
        contentPane.add(tfPhoneNumber);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblAddress.setBounds(479, 410, 220, 22);
        contentPane.add(lblAddress);
        tfAddress = new JTextField();
        tfAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfAddress.setBounds(642, 410, 220, 22);
        contentPane.add(tfAddress);

        JLabel lblMemberCard = new JLabel("Member Card:");
        lblMemberCard.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMemberCard.setBounds(479, 440, 220, 22);
        contentPane.add(lblMemberCard);
        cbMemberCard = new JComboBox<>();
        cbMemberCard.addItem("");
        for (String memberCard : memberCards) {
            cbMemberCard.addItem(memberCard);
        }
        cbMemberCard.setFont(new Font("Tahoma", Font.PLAIN, 20));
        cbMemberCard.setBounds(642, 440, 220, 22);
        contentPane.add(cbMemberCard);

        JSeparator separator_3 = new JSeparator();
        separator_3.setBounds(10, 510, 898, 13);
        contentPane.add(separator_3);

        btnAdd = new JButton("ADD");
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnAdd.setBounds(235, 525, 110, 30);
        contentPane.add(btnAdd);

        btnDelete = new JButton("DELETE");
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnDelete.setBounds(360, 525, 110, 30);
        contentPane.add(btnDelete);

        btnEdit = new JButton("EDIT");
        btnEdit.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnEdit.setBounds(485, 525, 110, 30);
        contentPane.add(btnEdit);

        btnCancel = new JButton("CANCEL");
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnCancel.setBounds(610, 525, 130, 30);
        contentPane.add(btnCancel);

        this.setTitle("Gym Manager");

        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);

        btnAdd.setEnabled(true);

    }

    public void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    // Hiển thị danh sách thành viên vào bảng
    public void showListMember(List<Member> list) {
        Object[][] members = mapMembersToTableData(list);
        memberTable.setModel(new DefaultTableModel(members, columnsName));
    }

    // Tìm kiếm và hiển thị danh sách thành viên
    public void showFilteredList(List<Member> list) {
        String name = tfNameSearch.getText().trim();
        String memberCard = cbMemberCardSearch.getSelectedItem().toString().trim();

        List<Member> filteredList = list.stream()
                .filter(member -> isMatch(member, name, memberCard))
                .toList();

        showListMember(filteredList);
    }

    // Kiểm tra điều kiện khớp
    private boolean isMatch(Member member, String name, String memberCard) {
        boolean matchName = name.isEmpty() || member.getFullName().contains(name);
        boolean matchMemberCard = memberCard.isEmpty() || memberCard.equals(member.getMemberCard());
        return matchName && matchMemberCard;
    }

    // Phương thức ánh xạ danh sách Member sang mảng dữ liệu hiển thị
    private Object[][] mapMembersToTableData(List<Member> list) {
        int size = list.size();
        Object[][] members = new Object[size][7];
        for (int i = 0; i < size; i++) {
            Member member = list.get(i);
            members[i] = new Object[]{
                    member.getIdMember(),
                    member.getFullName(),
                    member.getAge(),
                    member.isGender() ? "Man" : "Woman",
                    member.getPhoneNumber(),
                    member.getAddress(),
                    member.getMemberCard()
            };
        }
        return members;
    }

    public boolean isSearch() {
        String memberCard = cbMemberCardSearch.getSelectedItem().toString().trim();
        String memberName = tfNameSearch.getText().trim();

        if (memberCard.isEmpty() && memberName.isEmpty()) {
            return false;
        }else return true;
    }


    // Lay thong tin dong duoc chon tu memberTable
    public void fillMemberFromSelectedRow(){
        int row = memberTable.getSelectedRow();
        if (row >= 0){
            tfMemberID.setText(memberTable.getModel().getValueAt(row, 0).toString());
            tfMemberName.setText(memberTable.getModel().getValueAt(row, 1).toString());
            tfAge.setText(memberTable.getModel().getValueAt(row, 2).toString());
            if (memberTable.getModel().getValueAt(row, 3).equals("Man")){
                rdbtnMan.setSelected(true);
            }else if (memberTable.getModel().getValueAt(row, 3).equals("Woman")){
                rdbtnWoman.setSelected(true);
            }
            tfPhoneNumber.setText(memberTable.getModel().getValueAt(row, 4).toString());
            tfAddress.setText(memberTable.getModel().getValueAt(row, 5).toString());
            cbMemberCard.setSelectedItem(memberTable.getModel().getValueAt(row, 6).toString());

            btnEdit.setEnabled(true);
            btnDelete.setEnabled(true);

            btnAdd.setEnabled(false);
        }
    }

    // xoa thong tin
    public void clearMemberInfo(){
        tfMemberID.setText("");
        tfMemberName.setText("");
        tfAge.setText("");
        buttonGender.clearSelection();
        tfPhoneNumber.setText("");
        tfAddress.setText("");
        cbMemberCard.setSelectedIndex(0);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
        btnAdd.setEnabled(true);
    }

    // hien thi thong tin member
    public void showMember(Member member){
        tfMemberID.setText(member.getIdMember()+"");
        tfMemberName.setText(member.getFullName());
        tfAge.setText(member.getAge()+"");
        if (member.isGender()){
            rdbtnMan.setSelected(true);
        }else {
            rdbtnWoman.setSelected(true);
        }
        tfPhoneNumber.setText(member.getPhoneNumber());
        tfAddress.setText(member.getAddress());
        cbMemberCard.setSelectedItem(member.getMemberCard());
        btnEdit.setEnabled(true);
        btnDelete.setEnabled(true);
        btnAdd.setEnabled(false);
    }

    //lay thong tin member
    public Member getMemberInfo(){
        if (!validateName() || !validateAge() || !validateGender()|| !validatePhoneNumber() ||!validateAddress() || !validateMemberCard()) {
            return null;
        }
        try {
            Member member = new Member();
            if (tfMemberID.getText() != null && !tfMemberID.getText().isEmpty()) {
                member.setIdMember(Integer.parseInt(tfMemberID.getText()));
            }
            member.setFullName(tfMemberName.getText().trim());
            member.setAge(Integer.parseInt(tfAge.getText()));
            if (rdbtnMan.isSelected()) {
                member.setGender(true);
            }else if (rdbtnWoman.isSelected()) {
                member.setGender(false);
            }
            member.setPhoneNumber(tfPhoneNumber.getText().trim());
            member.setAddress(tfAddress.getText().trim());
            member.setMemberCard(cbMemberCard.getSelectedItem().toString());
            return member;
        } catch (Exception e){
            showMessage(e.getMessage());
        }
        return null;
    }

    private boolean validateName(){
        String name = tfMemberName.getText().trim();
        if (name.isEmpty()) {
            tfMemberName.requestFocus();
            showMessage("Name cannot be empty");
            return false;
        }
        return true;
    }

    private boolean validateGender(){
        if (!rdbtnMan.isSelected() && !rdbtnWoman.isSelected()) {
            rdbtnMan.requestFocus();
            showMessage("Gender cannot be empty");
            return false;
        }
        return true;
    }

    private boolean validateMemberCard(){
        String memberCard = cbMemberCard.getSelectedItem().toString();
        if (memberCard.isEmpty()) {
            cbMemberCard.requestFocus();
            showMessage("MemberCard cannot be empty");
            return false;
        }
        return true;
    }

    private boolean validatePhoneNumber(){
        String phoneNumber = tfPhoneNumber.getText().trim();
        if (phoneNumber.length() != 10) {
            tfPhoneNumber.requestFocus();
            showMessage("Phone Number must be 10 digits");
            return false;
        }
        return true;
    }

    private boolean validateAddress(){
        String name = tfAddress.getText().trim();
        if (name.isEmpty()) {
            tfAddress.requestFocus();
            showMessage("Address cannot be empty");
            return false;
        }
        return true;
    }

    private boolean validateAge(){
        try {
            Byte age = Byte.parseByte(tfAge.getText().trim());
            if(age<0||age>100){
                tfAge.requestFocus();
                showMessage("Age must be between 0 and 100");
                return false;
            }
        } catch (Exception e){
            tfAge.requestFocus();
            showMessage("Age is not valid");
            return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

    public void addSearchMemberListener(ActionListener l){
        btnSearch.addActionListener(l);
    }

    public void addShowOriginalListener(ActionListener l){
        btnShowOriginal.addActionListener(l);
    }

    public void addAddMemberListener(ActionListener l) {
        btnAdd.addActionListener(l);
    }

    public void addDeleteMemberListener(ActionListener l) {
        btnDelete.addActionListener(l);
    }

    public void addEditMemberListener(ActionListener l) {
        btnEdit.addActionListener(l);
    }

    public void addCancelListener(ActionListener l) {
        btnCancel.addActionListener(l);
    }

    public void addListMemberSelectionListener(ListSelectionListener l) {
        memberTable.getSelectionModel().addListSelectionListener(l);
    }

}