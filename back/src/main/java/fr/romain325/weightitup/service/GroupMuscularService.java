package fr.romain325.weightitup.service;

import fr.romain325.weightitup.model.GroupMuscular;
import java.util.List;

public interface GroupMuscularService {
    // Save operation
    GroupMuscular saveGroupMuscular(GroupMuscular name);

    // Read operation
    List<GroupMuscular> fetchGroupMuscularList();

    // Update operation
    GroupMuscular updateGroupMuscular(GroupMuscular name, Long groupId);

    // Delete operation
    void deleteGroupMuscularById(Long groupId);
}
