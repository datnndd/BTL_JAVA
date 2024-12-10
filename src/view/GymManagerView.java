package view;

import model.dao.GymManagerModel;
import model.entity.MembershipPlan;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Date;

public class GymManagerView extends JFrame {
    private JPanel contentPane;
    private GymManagerModel model;
    private JTextField textField_idMemberSearch;
    private JTable table;
    private JTextField textField_idMember;
    private JTextField textField_fullName;
    private JTextField textField_dateOfBirth;
    private JTextField textField_phoneNumber;
    private JTextField textField_email;
    private JTextField textField_address;
    private JTextField textField_joinDate;
    private JTextField textField_membershipPlan;
    private ButtonGroup buttonGender;
    private JRadioButton radioButton_male;
    private JRadioButton radioButton_female;
    private JComboBox comboBox_membershipPlan;

    public GymManagerView() {
        this.model = new GymManagerModel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);


    }
}
