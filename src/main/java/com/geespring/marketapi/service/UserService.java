package com.geespring.marketapi.service;

import com.geespring.marketapi.model.User;
import com.geespring.marketapi.repository.UserRepository;
import com.geespring.marketapi.util.TimeUtil;
import com.geespring.marketapi.util.exceptions.DataNotFoundException;
import com.geespring.marketapi.util.exceptions.DuplicateDataFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    /**
     * Represents the Account Repository Provider
     */
    @Autowired
    private final UserRepository repository;

    /**
     * Represents the TimeUtil Component Instance
     */
    @Autowired
    private final TimeUtil timeUtil;

    /**
     * Creates and saves the requested {@link User} object into the database
     * @param user
     * @return the requested account object
     */
    public User create(User user) {
        user.setCreatedAt(timeUtil.getLocalDateTime());
        return repository.save(user);
    }

    /**
     * Locates the {@link User} that is associated with the provided ID
     * @param id
     * @return the account object
     */
    public User find(final Long id) {
        return repository.findById(id).orElseThrow(DataNotFoundException::new);
    }

    /**
     * Updates the {@link User} basic essential information excluding email address
     * @param id
     * @param name
     * @param password
     */
    @Transactional
    public void update(final Long id, String name, String password) {
        User existing = find(id);
        if (name != null && name.length() > 0 && !name.equalsIgnoreCase(existing.getName())) {
            existing.setName(name);
        }
        if (password != null && password.length() > 7 && !password.equalsIgnoreCase(existing.getPassword())) {
            existing.setPassword(password);
        }
    }

    /**
     * Deletes the {@link User} from the database that is associated with the provided ID
     * @param id
     */
    public void delete(final Long id) {
        repository.deleteById(id);
    }

}
