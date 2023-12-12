package com.example.samspringboot3appjoin;

import com.example.samspringboot3appjoin.model.MyGroup;
import com.example.samspringboot3appjoin.model.MyUser;
import com.example.samspringboot3appjoin.respository.MyGroupRepository;
import com.example.samspringboot3appjoin.respository.MyUserRepository;
import com.example.samspringboot3appjoin.vo.UserGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
@RequiredArgsConstructor
public class SamSpringboot3AppJoinApplication {
    private final MyGroupRepository myGroupRepository;
    private final MyUserRepository myUserRepository;

    public static void main(String[] args) {
        SpringApplication.run(SamSpringboot3AppJoinApplication.class);
    }

    @Bean
    public CommandLineRunner demo() {
        return (args) -> {
            this.myGroupRepository.create(new MyGroup("그룹1", "그룹1 설명"));
            this.myGroupRepository.create(new MyGroup("그룹2", "그룹2 설명"));
            this.myGroupRepository.create(new MyGroup("그룹3", "그룹3 설명"));

            this.myUserRepository.create(new MyUser(1L, "가가가", ""));
            this.myUserRepository.create(new MyUser(2L, "나나나", ""));
            this.myUserRepository.create(new MyUser(2L, "다다다", ""));
            this.myUserRepository.create(new MyUser(3L, "다다다", ""));
            this.myUserRepository.create(new MyUser(3L, "라라라", ""));
            this.myUserRepository.create(new MyUser(3L, "마마마", ""));

            List<MyGroup> myGroupList = this.myGroupRepository.getGroupList();
            List<MyUser> myUserList = this.myUserRepository.getUserList();

            Map<Long, List<MyGroup>> groupMap = myGroupList.stream().collect(Collectors.groupingBy(MyGroup::getId));
            Map<Long, List<MyUser>> userMap = myUserList.stream().collect(Collectors.groupingBy(MyUser::getGroupId));
            List<UserGroup> userGroupList = new ArrayList<>();
            groupMap.forEach((id, myGroups) -> {
                MyGroup group = myGroups.get(0);
                List<MyUser> myUsers = userMap.getOrDefault(id, null);
                myUsers.forEach(user -> {
                    userGroupList.add(new UserGroup(user.getId(), user.getName(), id, group.getName()));
                });
            });
            System.out.println(userGroupList);
        };
    }
}
