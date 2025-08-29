package com.example.library;

import com.example.library.entity.Client;
import com.example.library.repository.ClientRepository;
import com.example.library.service.imp.ClientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Client client1 = new Client(1L, "John Doe", LocalDate.of(1990, 1, 1));
        Client client2 = new Client(2L, "Jane Smith", LocalDate.of(1995, 5, 15));
        when(clientRepository.findAll()).thenReturn(Arrays.asList(client1, client2));

        List<Client> clients = clientService.findAll();

        assertEquals(2, clients.size());
        assertEquals("John Doe", clients.get(0).getFullName());
        verify(clientRepository, times(1)).findAll();
    }

    @Test
    void testSave() {
        Client client = new Client(null, "New Client", LocalDate.of(2000, 6, 10));

        clientService.save(client);

        verify(clientRepository, times(1)).save(client);
    }

    @Test
    void testFindById() {
        Client client = new Client(1L, "John Doe", LocalDate.of(1990, 1, 1));
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        Client result = clientService.findById(1L);

        assertNotNull(result);
        assertEquals("John Doe", result.getFullName());
        verify(clientRepository, times(1)).findById(1L);
    }

    @Test
    void testEditClient() {
        Client existingClient = new Client(1L, "Old Name", LocalDate.of(1990, 1, 1));
        Client updatedClient = new Client(null, "New Name", LocalDate.of(1990, 1, 1));
        when(clientRepository.findById(1L)).thenReturn(Optional.of(existingClient));

        clientService.editClient(1L, updatedClient);

        assertEquals("New Name", existingClient.getFullName());
        verify(clientRepository, times(1)).save(existingClient);
    }
}
