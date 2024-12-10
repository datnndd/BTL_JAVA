package model.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Member implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private int idMember;
    private String fullName;
    private Date dateOfBirth;
    private boolean gender;
    private String phoneNumber;
    private String email;
    private String address;
    private Date joinDate;
    private MembershipPlan membershipPlan;

    public Member() {}
    public Member(int idMember, String fullName, Date dateOfBirth, boolean gender, String phoneNumber, String email, String address, Date joinDate, MembershipPlan membershipPlan) {
        this.idMember = idMember;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.joinDate = joinDate;
        this.membershipPlan = membershipPlan;
    }

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public MembershipPlan getMembershipPlan() {
        return membershipPlan;
    }

    public void setMembershipPlan(MembershipPlan membershipPlan) {
        this.membershipPlan = membershipPlan;
    }

    @Override
    public String toString() {
        return "Member{" +
                "idMember=" + idMember +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", joinDate=" + joinDate +
                ", membershipPlan=" + membershipPlan +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return idMember == member.idMember && gender == member.gender && Objects.equals(fullName, member.fullName) && Objects.equals(dateOfBirth, member.dateOfBirth) && Objects.equals(phoneNumber, member.phoneNumber) && Objects.equals(email, member.email) && Objects.equals(address, member.address) && Objects.equals(joinDate, member.joinDate) && Objects.equals(membershipPlan, member.membershipPlan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMember, fullName, dateOfBirth, gender, phoneNumber, email, address, joinDate, membershipPlan);
    }
}
