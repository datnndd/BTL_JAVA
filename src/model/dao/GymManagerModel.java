package model.dao;

import java.lang.reflect.Array;
import java.lang.reflect.Member;
import java.util.ArrayList;

public class GymManagerModel {
    private ArrayList<Member> memberArrayList;
    public GymManagerModel() {
        this.memberArrayList = new ArrayList<Member>();
    }

    public GymManagerModel(ArrayList<Member> memberArrayList) {
        this.memberArrayList = memberArrayList;
    }

    public ArrayList<Member> getMemberArrayList() {
        return memberArrayList;
    }

    public void setMemberArrayList(ArrayList<Member> memberArrayList) {
        this.memberArrayList = memberArrayList;
    }

    //Search by Name
    //Search by Membership

    //insert
    public void insertMember(Member member) {
        this.memberArrayList.add(member);
    }
    //delete
    public void deleteMember(Member member) {
        this.memberArrayList.remove(member);
    }
    //edit

}
