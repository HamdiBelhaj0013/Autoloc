package tn.esprit.autolocapi.sevice;

import tn.esprit.autolocapi.domain.Client;

import java.util.List;

public interface IClientService {
    Client ajouterClient(Client client);
    void supprimerClientById(Long id);
    Client modifierClient(Client client);
    Client getClientById(Long id);
    List<Client> getAllClients();
}
