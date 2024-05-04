package org.example.finalproject.Repository;

import org.example.finalproject.Model.Requests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestsRepository extends JpaRepository<Requests, Integer> {
    Requests findRequestsByRequestId(Integer requestId);
    Requests findRequestsBySportType(String sportName);

}
