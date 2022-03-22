package site.metacoding.blogv2.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.user.User;
import site.metacoding.blogv2.domain.user.UserRepository;
import site.metacoding.blogv2.web.api.dto.user.JoinDto;
import site.metacoding.blogv2.web.api.dto.user.LoginDto;

@RequiredArgsConstructor
@Service // 컴포넌트 스캔시에 IoC 컨테이너에 등록됨 // 트랜잭션 관리하는 오브젝트임. 기능 모임
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void 회원가입(JoinDto joinDto) {
        // save하면 db에 insert하고 insert된 결과를 다시 return 해준다.

        userRepository.save(joinDto.toEntity());

    }

    public User 로그인(LoginDto loginDto) {
        // 로그인 처리 쿼리를 JPA에서 제공해주지 않는다.
        // SELECT * FROM user WHERE username=:username AND password = :password
        User userEntity = userRepository.mLogin(loginDto.getUsername(), loginDto.getPassword());
        return userEntity;
    }
}
