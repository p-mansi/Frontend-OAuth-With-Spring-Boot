package edu.charusat.OAuthDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        System.out.println("CustomOAuth2UserService called!");
        OAuth2User oauthUser = super.loadUser(userRequest);
        Map<String, Object> attributes = oauthUser.getAttributes();

        String email = (String) attributes.get("email");
        String name = (String) attributes.get("name");
        String picture = (String) attributes.get("picture");

        System.out.println("Saving new user: " + name + ", " + email);

        Optional<User> existingUser = userRepository.findByEmail(email);
        if (existingUser.isEmpty()) {
            try {
                User newUser = new User();
                newUser.setName(name);
                newUser.setEmail(email);
                newUser.setPicture(picture);
                newUser.setCreatedAt(LocalDateTime.now());
                userRepository.save(newUser);
                System.out.println(" New user saved: " + email);
            } catch (Exception e) {
                System.out.println(" Failed to save user: " + email);
                e.printStackTrace();
            }
        }

        return oauthUser;
    }
}
