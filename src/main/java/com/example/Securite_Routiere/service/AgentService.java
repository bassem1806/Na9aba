package com.example.Securite_Routiere.service;

import com.example.Securite_Routiere.entities.Agent;
import com.example.Securite_Routiere.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {
    @Autowired
    AgentRepository agentRepository;


    public Page<Agent> findPage(int pageNumber) {

        Pageable pageable = PageRequest.of(pageNumber - 1, 30);
        return agentRepository.findAll(pageable);

    }

    public Page<Agent> findAlLWithSort(String field, String direction, int pageNumber) {
        Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(field).descending()
                : Sort.by(field).ascending();

        Pageable pageable = PageRequest.of(pageNumber - 1, 30, sort);

        return agentRepository.findAll(pageable);
    }


    public List<Agent> getAllAgent(){
        List<Agent> agents = (List<Agent>) agentRepository.findAll();
        return agents;
    }

    /*
     * TODO: Get Shop By keyword
     */
    public List<Agent> getByKeyword(String keyword){

        return agentRepository.findByKeyword(keyword);
    }

}

