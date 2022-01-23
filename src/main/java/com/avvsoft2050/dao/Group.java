package com.avvsoft2050.dao;

import java.util.List;

public interface Group {
    void addGroup(Group group);
    void deleteGroup(int groupId);
    void updateGroup(Group group);
    List<Group> getAllGroups();
    Group getGroupById(int groupId);
}
