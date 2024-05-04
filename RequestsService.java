package org.example.finalproject.Service;

import lombok.AllArgsConstructor;
import org.example.finalproject.API.ApiException;
import org.example.finalproject.Model.Requests;
import org.example.finalproject.Model.SportAdmin;
import org.example.finalproject.Model.TeamAdmin;
import org.example.finalproject.Repository.RequestsRepository;
import org.example.finalproject.Repository.SportAdminRepository;
import org.example.finalproject.Repository.SportRepository;
import org.example.finalproject.Repository.TeamAdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RequestsService {
    private RequestsRepository requestsRepository;
    private SportAdminRepository sportAdminRepository;
    private TeamAdminRepository teamAdminRepository;



    public List<Requests> getAllRequests() {
        return requestsRepository.findAll();
    }

    public void addRequest(Requests request) {
        requestsRepository.save(request);
    }

    public void updateRequest(Integer requestId,Requests request) {
        Requests requests1= requestsRepository.findRequestsByRequestId(requestId);
        if (requests1==null){
            throw new ApiException("Invalid ID");
        }
        requests1.setTeamName(request.getTeamName());
        requests1.setStatus(request.getStatus());
        requests1.setSportType(request.getSportType());
        requestsRepository.save(requests1);
    }

    public void deleteRequest(Integer requestId) {
        Requests requests= requestsRepository.findRequestsByRequestId(requestId);
        requestsRepository.delete(requests);
    }

    public void assign(Integer requestId) {
        Requests request= requestsRepository.findRequestsByRequestId(requestId);
           SportAdmin sportAdmin=sportAdminRepository.findSportAdminBySportType(request.getSportType());
        TeamAdmin teamAdmin=teamAdminRepository.findTeamAdminByteamName(request.getTeamName());
        if(sportAdmin==null||teamAdmin==null){
            throw new ApiException("Invalid");
        }
        request.getTeamAdminList().add(teamAdmin);
        sportAdmin.getJoinSet().add(request);
        request.getSportAdminList().add(sportAdmin);
        request.getTeamAdminList().add(teamAdmin);
        requestsRepository.save(request);
        teamAdminRepository.save(teamAdmin);
        sportAdminRepository.save(sportAdmin);
    }
}
