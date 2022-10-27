package fr.romain325.weightitup.controller;

import fr.romain325.weightitup.model.GroupMuscular;
import fr.romain325.weightitup.repository.GroupMuscularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class GroupMuscularController {

    @Autowired
    GroupMuscularRepository gmRepository;

    @GetMapping("/groupmuscu")
    public ResponseEntity<List<GroupMuscular>> getAllGroupMusculars(@RequestParam(required = false) String title) {
        try {
            List<GroupMuscular> groupMuscu = new ArrayList<GroupMuscular>();

            if (title == null)
                gmRepository.findAll().forEach(groupMuscu::add);
            else
                groupMuscu.add(gmRepository.findByName(title));

            if (groupMuscu.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(groupMuscu, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/groupmuscu/{id}")
    public ResponseEntity<GroupMuscular> getGroupMuscularById(@PathVariable("id") long id) {
        Optional<GroupMuscular> groupMuscuData = gmRepository.findById(id);

        if (groupMuscuData.isPresent()) {
            return new ResponseEntity<>(groupMuscuData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/groupmuscu")
    public ResponseEntity<GroupMuscular> createGroupMuscular(@RequestBody GroupMuscular gm) {
        try {
            GroupMuscular _gmRepository = gmRepository
                    .save(new GroupMuscular(gm.getName(), gm.getImg()));
            return new ResponseEntity<>(_gmRepository, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/groupmuscu/{id}")
    public ResponseEntity<GroupMuscular> updateGroupMuscular(@PathVariable("id") long id, @RequestBody GroupMuscular gm) {
        Optional<GroupMuscular> groupMuscuData = gmRepository.findById(id);

        if (groupMuscuData.isPresent()) {
            GroupMuscular _gm = groupMuscuData.get();
            _gm.setName(gm.getName());
            _gm.setImg(gm.getImg());
            return new ResponseEntity<>(gmRepository.save(_gm), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/groupmuscu/{id}")
    public ResponseEntity<HttpStatus> deleteGroupMuscular(@PathVariable("id") long id) {
        try {
            gmRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/groupmuscu")
    public ResponseEntity<HttpStatus> deleteAllGroupMusculars() {
        try {
            gmRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
