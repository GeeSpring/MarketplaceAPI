package com.geespring.marketapi.service;

import com.geespring.marketapi.model.User;
import com.geespring.marketapi.repository.UserRepository;
import com.geespring.marketapi.util.TimeUtil;
import com.geespring.marketapi.util.exceptions.DataNotFoundException;
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

    @Autowired
    private final TimeUtil timeUtil;

    /**
     * Creates and saves the requested {@link User} object into the database
     * @param user
     * @return the requested account object
     */
    public User create(User user) {
        user.setCreatedAt(timeUtil.getLocalDateTime());
        User use1 = repository.save(user);
        System.out.println(use1.toString());
        return use1;
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
     * Saves the account object into the database
     * @param user
     */
    public void update(final User user) {
        repository.save(user);
    }

    /**
     * Deletes the {@link User} from the database that is associated with the provided ID
     * @param id
     */
    public void delete(final Long id) {
        repository.deleteById(id);
    }

}
