package entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "members")
@XmlAccessorType(XmlAccessType.FIELD)
public class MemberXML {

    private List<Member> member;

    public List<Member> getMembers() {
        return member;
    }

    public void setMembers(List<Member> member) {
        this.member = member;
    }
}
