package com.brs.idm.api.dto;
import com.brs.idm.api.Role;
import com.brs.idm.api.User;
import lombok.Data;

import java.util.List;

/**
 * @author tiny lin
 * @date 2019/2/21
 */
@Data
public class LoginUserInfoRepresentation {
    private User user;
    private List<Role> roles;
}
