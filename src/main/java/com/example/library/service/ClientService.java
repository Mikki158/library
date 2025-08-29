package com.example.library.service;

import com.example.library.entity.Book;
import com.example.library.entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> findAll();

    void save(Client client);

    Client findById(Long id);

    void editClient(Long id, Client clientDetails);
}
