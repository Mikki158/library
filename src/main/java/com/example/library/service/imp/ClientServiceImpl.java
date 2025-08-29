package com.example.library.service.imp;

import com.example.library.entity.Book;
import com.example.library.entity.Client;
import com.example.library.repository.ClientRepository;
import com.example.library.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Клиента с id: " + id + " нету"));
    }

    @Override
    public void editClient(Long id, Client clientDetails) {
        Client client = findById(id);
        client.setFullName(clientDetails.getFullName());
        client.setBirthDate(clientDetails.getBirthDate());
        save(client);
    }
}
