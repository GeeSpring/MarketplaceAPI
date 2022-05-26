package com.geespring.marketapi.service;

import com.geespring.marketapi.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    /**
     * Creates and saves the requested {@link Account} object into the database
     * @param account
     * @return the requested account object
     */
    public Account create(Account account) {
        //TODO implement CRUDRepository
        return null;
    }

    /**
     * Locates the {@link Account} that is associated with the provided ID
     * @param id
     * @return the account object
     */
    public Account find(final Long id) {
        return null;
    }

    /**
     * Saves the account object into the database
     * @param account
     */
    public void update(final Account account) {
        //TODO update the account within the db
    }

    /**
     * Deletes the {@link Account} from the database that is associated with the provided ID
     * @param id
     */
    public void delete(final long id) {
        //TODO delete the account from the database
    }

}
