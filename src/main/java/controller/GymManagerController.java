package controller;

import dao.MemberDao;
import entity.Member;
import view.GymManagerView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GymManagerController {
    private MemberDao memberDao;
    private GymManagerView managerView;

    public GymManagerController(GymManagerView view) {
        this.managerView = view;
        this.memberDao = new MemberDao();

        view.addAddMemberListener(new AddMemberListener());
        view.addDeleteMemberListener(new DeleteMemberListener());
        view.addEditMemberListener(new EditMemberListener());
        view.addCancelListener(new CancelMemberListener());
        view.addSearchMemberListener(new SearchMemberListener());
        view.addShowOriginalListener(new ShowOriginalListener());
        view.addListMemberSelectionListener(new ListMemberSelectionListener());
    }

    public void showMemberView(){
        List<Member> memberList = memberDao.getMemberList();
        managerView.setVisible(true);
        managerView.showListMember(memberList);
    }

    class SearchMemberListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            boolean check = managerView.isSearch();
            List<Member> memberList = memberDao.getMemberList(); // Lấy danh sách thành viên

            if (check) {
                managerView.showFilteredList(memberList); // Tìm kiếm và hiển thị danh sách phù hợp
            } else {
                managerView.showListMember(memberList); // Hiển thị toàn bộ danh sách nếu không có điều kiện tìm kiếm
            }
        }
    }

    class ShowOriginalListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            managerView.showListMember(memberDao.getMemberList());
        }
    }

    class AddMemberListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Member member = managerView.getMemberInfo();
            if (member!=null) {
                memberDao.add(member);
                managerView.showMember(member);
                managerView.showListMember(memberDao.getMemberList());
                managerView.showMessage("Add Member Success");
                managerView.clearMemberInfo();
            }
        }
    }

    class EditMemberListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Member member = managerView.getMemberInfo();
            if (member!=null) {
                int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to change information this member?",
                        "Confirm Edit",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm==JOptionPane.YES_OPTION) {
                    memberDao.edit(member);
                    managerView.showMember(member);
                    managerView.showListMember(memberDao.getMemberList());
                    managerView.showMessage("Edit Member Success");
                }
            }
        }
    }

    class DeleteMemberListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Member member = managerView.getMemberInfo();
            if (member!=null) {
                int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to delete this member?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm==JOptionPane.YES_OPTION) {
                    memberDao.delete(member);
                    managerView.clearMemberInfo();
                    managerView.showListMember(memberDao.getMemberList());
                    managerView.showMessage("Delete Member Success");
                }
            }
        }
    }

    class CancelMemberListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            managerView.clearMemberInfo();
        }
    }

    class ListMemberSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            managerView.fillMemberFromSelectedRow();
        }
    }

}
