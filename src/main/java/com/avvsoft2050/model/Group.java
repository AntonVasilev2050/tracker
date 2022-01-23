package com.avvsoft2050.model;


import javax.persistence.*;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int groupId;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "group_color")
    private String groupColor;

    public Group() {
    }

    public Group(int groupId, String groupName, String groupColor) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupColor = groupColor;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupColor() {
        return groupColor;
    }

    public void setGroupColor(String groupColor) {
        this.groupColor = groupColor;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", groupColor='" + groupColor + '\'' +
                '}';
    }
}
