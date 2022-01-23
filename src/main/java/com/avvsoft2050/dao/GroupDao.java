package com.avvsoft2050.dao;

import com.avvsoft2050.model.Group;

import java.util.List;

public interface GroupDao {
    void addGroup(Group group);
    void deleteGroup(int groupId);
    void updateGroup(Group group);
    List<Group> getAllGroups();
    Group getGroupById(int groupId);
}
