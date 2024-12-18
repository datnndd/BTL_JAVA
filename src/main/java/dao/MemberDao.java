package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Member;
import entity.MemberXML;
import utils.FileUtils;

public class MemberDao {
    private static final String MEMBER_FILE_NAME = "member.xml";
    private List<Member> memberList;

    public MemberDao() {
        this.memberList = readListMembers();
        if (memberList == null) {
            memberList = new ArrayList<Member>();
        }
    }

    // Lưu các đối tượng vào file member.xml
    public void writeListMembers(List<Member> members) {
        MemberXML memberXML = new MemberXML();
        memberXML.setMembers(members);
        FileUtils.writeXMLtoFile(MEMBER_FILE_NAME, memberXML);
    }

    // Doc các đối tượng tu file member.xml
    public List<Member> readListMembers() {
        List<Member> list = new ArrayList<>();
        MemberXML memberXML = (MemberXML) FileUtils.readXMLFile(
                MEMBER_FILE_NAME, MemberXML.class);
        if (memberXML != null) {
            list = memberXML.getMembers();
        }
        return list;
    }

    //thêm member vào list và lưu list vào file
    public void add(Member member) {
        int id = 1;
        if (memberList != null && !memberList.isEmpty()) {
            id = memberList.size() + 1;
        }
        member.setIdMember(id);
        memberList.add(member);
        writeListMembers(memberList);
    }

    //cap nhat member vào list và lưu list vào file
    public void edit(Member member) {
        int size = memberList.size();
        for (int i = 0; i < size; i++) {
            if (memberList.get(i).getIdMember() == member.getIdMember()) {
                memberList.get(i).setFullName(member.getFullName());
                memberList.get(i).setAge(member.getAge());
                memberList.get(i).setGender(member.isGender());
                memberList.get(i).setPhoneNumber(member.getPhoneNumber());
                memberList.get(i).setAddress(member.getAddress());
                memberList.get(i).setMemberCard(member.getMemberCard());
                writeListMembers(memberList);
                break;
            }
        }
    }

    //xoa member tu list và lưu list vào file
    public boolean delete(Member member) {
        boolean isFound = false;
        int size = memberList.size();
        for (int i = 0; i < size; i++) {
            if (memberList.get(i).getIdMember() == member.getIdMember()) {
                member = memberList.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            memberList.remove(member);
            writeListMembers(memberList);
            return true;
        }
        return false;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }
}