package site.metacoding.blogv2.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.user.User;
import site.metacoding.blogv2.domain.user.UserRepository;
import site.metacoding.blogv2.web.api.dto.user.JoinDto;
import site.metacoding.blogv2.web.api.dto.user.LoginDto;
import site.metacoding.blogv2.web.api.dto.user.UpdateDto;

@RequiredArgsConstructor
@Service // 컴포넌트 스캔시에 IoC 컨테이너에 등록됨 // 트랜잭션 관리하는 오브젝트임. 기능 모임
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User 회원수정(Integer id, UpdateDto updateDto) {
        // UPDATE user SET password = ?, email = ?, addr = ? WHERE id = ?
        Optional<User> userOp = userRepository.findById(id); // 영속화 (디비 row를 영속성 컨텍스에 옮김)

        if (userOp.isPresent()) {
            // 영속화된 오브젝트 수정
            User userEntity = userOp.get();
            userEntity.setPassword(updateDto.getPassword());
            userEntity.setEmail(updateDto.getEmail());
            userEntity.setAddr(updateDto.getAddr());
            return userEntity;
        } else {
            throw new RuntimeException("아이디를 찾을 수 없습니다.");
        }
    } // 트랜잭션이 걸려있으면 @Service 종료시에 변경감지해서 디비에 update함 = 더티체킹

    public User 회원정보(Integer id) {
        Optional<User> userOp = userRepository.findById(id);

        if (userOp.isPresent()) {
            return userOp.get();
        } else {
            throw new RuntimeException("아이디를 찾을 수 없습니다.");
        }
    }

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
