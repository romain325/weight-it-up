package fr.romain325.weightitup.repository;

import fr.romain325.weightitup.model.GroupMuscular;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupMuscularRepository extends CrudRepository<GroupMuscular, Long> {
    GroupMuscular findByName(String title);
}
